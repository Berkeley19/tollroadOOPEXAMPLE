/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tollroad;




enum DiscountType {NONE, STAFF, FRIENDS_AND_FAMILY};

public class CustomerAccount implements Comparable<Vehicle>{
    
    private final String firstName;
    private final String secondName;
    private int currentBalance;
    private DiscountType typeOfDiscount = DiscountType.NONE;
    private final Vehicle vehicle;
    
    
    public CustomerAccount(String firstName, String secondName,
                           int currentBalance,
                           Vehicle vehicle){
        
        this.currentBalance = currentBalance;
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicle = vehicle;
        
        
    }
    
    public void activateStaffDiscount(){
        this.typeOfDiscount = DiscountType.STAFF;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }

    
    public String getSecondName(){
        return secondName;
    }

    
    public int getCurrentBalance(){
        return currentBalance;
    }

    public void setCurrentBalance(int CurrentBalance){
        this.currentBalance = CurrentBalance;
    }
    
    public void activateFriendsAndFamilyDiscount(){
        this.typeOfDiscount = DiscountType.FRIENDS_AND_FAMILY;
    }
    
    public void deactivateDiscount(){
        
        this.typeOfDiscount = DiscountType.NONE;
    }
    
    public DiscountType getDiscountType(){
        return typeOfDiscount;
    }
    
    
    public void addFunds(int amount){
        
        this.currentBalance += amount;
    }
    
    public int makeTrip() throws InsufficientAccountBalanceException {
        
        double costOfTypeDouble = (double) vehicle.calculateBasicTripCost();   
        int costOfTypeInt;
        switch(typeOfDiscount){
            case NONE: 
                break;
            case STAFF: 
                costOfTypeDouble = costOfTypeDouble * 0.5;
                break;
            case FRIENDS_AND_FAMILY: costOfTypeDouble = costOfTypeDouble * 0.9;
            break;
        }
        
        try{
            check(currentBalance, costOfTypeDouble);
        }
        catch (InsufficientAccountBalanceException ex){
            
            throw new InsufficientAccountBalanceException(
                    this.vehicle.getRegisterPlate()
                            + ": make trip failed. Insufficient funds");
        }
        costOfTypeInt = (int) costOfTypeDouble;

        int newBalance = currentBalance - costOfTypeInt;
        this.currentBalance = newBalance;
        int newCostOfType = costOfTypeInt;
        return newCostOfType;
        
    }
    

    public int check(int balance, double costOfType) 
        throws InsufficientAccountBalanceException{
        
        if(balance < costOfType){
            
            throw new InsufficientAccountBalanceException(
                        this.vehicle.getRegisterPlate() 
                        + ": makeTrip failed Insufficient Funds");
            
        }else{
            return  balance;
        }   
    }    
    
    @Override
    public int compareTo(Vehicle A){
        String firstLicensePlate = A.getRegisterPlate();
        if(vehicle.getRegisterPlate().compareTo(firstLicensePlate) > 0){
            return 1;
        }
        else if(vehicle.getRegisterPlate().compareTo(firstLicensePlate) == 0){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public static void main(String[] args) {
        
////        Car veh = new Car("aaa", "asfS", 4);
////        CustomerAccount ar = new CustomerAccount("dsga", "asdf",
////                           1000 , veh);
////        System.out.println(ar.typeOfDiscount);
////        ar.activateStaffDiscount();
////        System.out.println(ar.currentBalance);
////        ar.addFunds(1);
////        System.out.println(ar.currentBalance);
////        ar.addFunds(2);
////        System.out.println(ar.currentBalance);
////        ar.addFunds(2);
////        System.out.println(ar.currentBalance);
////        Van veh2 = new Van("aaaaa", "asf", 670);
////        CustomerAccount ar2 = new CustomerAccount("dsga", "asdf",
////                           31, veh2);
////        
////        //System.out.println(ar2.makeTrip());
////       
////        
////        
////        //System.out.println(ar.compareTo(veh2));
////        
////        Van veh3 = new Van("aa", "catstring", 5000000);
////        CustomerAccount ar3 = new CustomerAccount("dsga", "asdf",
////                           3100 , veh3);
////        
////        //ar3.deactivateDiscount();
////        //System.out.println(ar3.getDiscountType());
////        
////        
////        Van veh4 = new Van("", "a", 1000);
////        CustomerAccount ar4 = new CustomerAccount("dsga", "asdf",
////                           31 , veh4);
        
        Truck veh5 = new Truck("xxxxxxx", "", 1);
        CustomerAccount ar5 = new CustomerAccount("dsga", "asdf",
                           1200 , veh5);
        ar5.activateStaffDiscount();
        try {
            ar5.makeTrip();
            
            
            //System.out.println(ar3.makeTrip());
            //System.out.println(ar4.makeTrip());
            //System.out.println(ar5.makeTrip());
            //System.out.println(ar3.compareTo(veh));
            //System.out.println(ar2.compareTo(veh2));
            //System.out.println(ar5.compareTo(veh3));
            //System.out.println(ar.compareTo(veh4));
            //System.out.println(ar5.compareTo(veh5));
            //System.out.println(ar4.compareTo(veh2));
            //System.out.println(ar3.compareTo(veh3));
            //System.out.println(ar3.compareTo(veh5));
            //System.out.println(ar3.compareTo(veh5));
        } catch (InsufficientAccountBalanceException ex) {
            System.out.println(ex);
        }
        
        
    }
}
