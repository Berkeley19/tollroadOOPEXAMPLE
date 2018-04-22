/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tollroad;
import java.util.Scanner;
import java.io.*;


public class TollRoadMain{
        
    public TollRoad initialiseTollRoadFromFile(){
        TollRoad road = new TollRoad();

        File inputFile = new File("./src/tollroad/customerData.txt");
        try{
        Scanner scan = new Scanner(inputFile);
        scan.useDelimiter("#");
        Scanner commaScan;
        String firstName, lastName, regNum, vehicleType,
               discountType, make;
        int vehicleInformation, startingBalance;

        while(scan.hasNext()){
            commaScan = new Scanner(scan.next());
            commaScan.useDelimiter(",");
            vehicleType = commaScan.next();
            regNum = commaScan.next();
            firstName = commaScan.next();
            lastName = commaScan.next();
            make = commaScan.next();
            vehicleInformation = Integer.parseInt(commaScan.next());               
            startingBalance = Integer.parseInt(commaScan.next());
            discountType = commaScan.next();    
            System.out.println();
            Van van;
            Car car;
            Truck truck;

            switch (vehicleType) {
                case "Van":
                    {
                        van = new Van(regNum, make, vehicleInformation);
                        CustomerAccount customer = new CustomerAccount(
                                firstName, lastName, startingBalance, van);
                    switch (discountType) {
                        case "NONE":
                            break;
                        case "STAFF":
                            customer.activateStaffDiscount();
                            break;
                        default:
                            customer.activateFriendsAndFamilyDiscount();
                            break;
                    }
                        road.getCustomerList().add(customer);
                        break;
                    }
                case "Car":
                    {
                        car = new Car(regNum, make, vehicleInformation);
                        CustomerAccount customer = new CustomerAccount(
                                firstName, lastName, startingBalance, car);
                    switch (discountType) {
                        case "NONE":
                            break;
                        case "STAFF":
                            customer.activateStaffDiscount();
                            break;
                        default:
                            customer.activateFriendsAndFamilyDiscount();
                            break;
                    }
                        road.getCustomerList().add(customer);
                        break;
                    }
                case "Truck":
                    {
                        truck = new Truck(regNum, make, vehicleInformation);
                        CustomerAccount customer = new CustomerAccount(
                                firstName, lastName, startingBalance, truck);
                    switch (discountType) {
                        case "NONE":
                            break;
                        case "STAFF":
                            customer.activateStaffDiscount();
                            break;
                        default:
                            customer.activateFriendsAndFamilyDiscount();
                            break;
                    }
                        road.getCustomerList().add(customer);
                        break;
                    }
                default:
                    break;
            }
        }       
        }catch(FileNotFoundException ex){
            System.out.printf("ERROR: %s\n", ex);
        }
        return road;
    }

    public void simulateFromFile(TollRoad road){

        File inputFile = new File("./src/tollroad/transactions.txt");
        try{
        Scanner scan = new Scanner(inputFile);
        String file = "";
        while(scan.hasNext()){
            file = scan.next();
        }   //splitting up each part by $ sign
            String[] split1 = file.split("\\$");
            //for loop through file as a string
            for (String split11 : split1) {
                //splitting each part 
                String[] split2 = split11.split(",");
                if("makeTrip".equals(split2[0])){
                    String regNum = split2[1];
                    try {
                           road.chargeCustomer(regNum);
                           System.out.println(regNum 
                                   + "Trip completed successfully");
                       } catch (CustomerNotFoundException ex) {
                           System.out.println(regNum + ": makeTrip failed."
                                   + " CustomerAccount does not exist");
                       } catch (InsufficientAccountBalanceException ex) {
                           System.out.println(regNum + ": makeTrip failed."
                                   + " Insufficient funds");
                       }

                } else if("addFunds".equals(split2[0])){
                    String regNum = split2[1];
                    int amount = Integer.parseInt(split2[2]);
                    try { 
                          road.findCustomer(regNum).addFunds(amount);
                          System.out.println(regNum + ": " + amount 
                                   + " added successfully");
                        } catch (CustomerNotFoundException ex) {
                           System.out.println(regNum + ": makeTrip failed."
                                   + " CustomerAccount does not exist");
                        }
                } 
            }
        }catch(FileNotFoundException ex){
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    public static void main(String[] args) {
        
        TollRoadMain hey = new TollRoadMain();
        TollRoad road = hey.initialiseTollRoadFromFile();
        hey.simulateFromFile(road);
        System.out.println("Money made =" + road.getMoneyMade());
        
        

    }
} 
   
    
