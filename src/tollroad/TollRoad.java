/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tollroad;

import java.util.ArrayList;


/**
 *
 * @author berkeley
 */
public class TollRoad {
    
    /*
    Using ArrayList as my collection type as I don't need mapping from
    key value pairs and also duplicates may occur to my CustomerAccount
    objects as people may have the same firstName, currentAccount balance etc.
    Used an ArrayList over LinkedList as they're the most access could be from
    wherever in the collection not just in the start or end, the list size 
    isn't of great significance and entries are not often inserted or removed.
     */
    private final ArrayList<CustomerAccount> customerList;
    private int moneyMade;
    
    public TollRoad(){
        //Use of diamond operator
        this.customerList = new ArrayList<>();
        this.moneyMade = 0; 
    }
    
    public int getMoneyMade(){
        
        return moneyMade;
        
    }
    public void setMoneyMade(int money){
        
        this.moneyMade = money;
        
    }
    /* 
    Do not need setter method for the customerList ArrayList as I can simply
    have callers call my getCustomerList method and then mutate the
    ArrayList themselves 
    */
    public ArrayList<CustomerAccount>getCustomerList(){
        
        return customerList;
        
    }
    
    public boolean addCustomer(CustomerAccount account){
        
        return customerList.add(account);
        
    }
    public CustomerAccount findCustomer(String regNum) throws CustomerNotFoundException{
        CustomerAccount matchingTrue = null;
        try{
            
             matchingTrue = match(regNum);
             
        }
        catch(CustomerNotFoundException e){           
            
            throw new CustomerNotFoundException("");
        }
        
        return matchingTrue;
    }
    
    public CustomerAccount match(String match) 
            throws CustomerNotFoundException{
        for(CustomerAccount customer : customerList){
            if(customer.getVehicle().getRegisterPlate().equals(match)){
                
                return customer;
            }
        }
        throw new CustomerNotFoundException(match + ": Customer not found.");
                
    }
    
    public void chargeCustomer(String registrationNumber) throws InsufficientAccountBalanceException, CustomerNotFoundException 
            {
            moneyMade += findCustomer(registrationNumber).makeTrip();
             
         }
         
    
    

    
    public static void main(String[] args) {
        Car veh = new Car("sdf", "Ssf", 5);
        TollRoad toll = new TollRoad();
        CustomerAccount ar6 = new CustomerAccount("dsga", "asdf",
                           500 , veh);
        Truck veh5 = new Truck("xxxxxxx", "dsa", 2);
        CustomerAccount ar5 = new CustomerAccount("dsga", "asdf",
                           0 , veh5);
        Van veh4 = new Van("df", "sad", 1000);
        CustomerAccount ar4 = new CustomerAccount("dsga", "asdf",
                           300 , veh4);
         Car veh2 = new Car("aaa", "asfS", 4);
        CustomerAccount ar = new CustomerAccount("dsga", "asdf",
                           1000 , veh2);
      //  ar.activateStaffDiscount();
//        System.out.println(ar.getCurrentBalance());
//        System.out.println(ar.makeTrip());
//        toll.addCustomer(ar);
//        System.out.println(toll.moneyMade);
//        ar.activateStaffDiscount();
//        ar.deactivateDiscount();
//        System.out.println(ar.getDiscountType());
//        System.out.println(ar.getCurrentBalance());
//        
//        toll.chargeCustomer("aaa");
//        System.out.println(toll.moneyMade);
//        toll.addCustomer(ar6);
//        System.out.println(toll.getCustomerList());
//        toll.addCustomer(ar5);
//        toll.getCustomerList();
//        System.out.println(toll.findCustomer("Ssf"));
//        System.out.println(toll.findCustomer("sdf"));
//        toll.chargeCustomer("asfdasdfdas");
//        toll.addCustomer(ar6);
//        toll.chargeCustomer("sdf");
//        
        //ar4.makeTrip();
        toll.addCustomer(ar4);
        System.out.println(toll.moneyMade);
        try {
            toll.chargeCustomer("dffff");
        } catch (CustomerNotFoundException ex) {
            System.out.println("df: makeTrip failed."
                     + " CustomerAccount does not exist");
        } catch (InsufficientAccountBalanceException ex) {
            System.out.println("df: makeTrip failed."
                     + " Insufficient funds");
        }
                
    }
    
}
