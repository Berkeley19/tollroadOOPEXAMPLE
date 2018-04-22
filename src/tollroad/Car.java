/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tollroad;

/**
 *
 * @author berkeley
 */
//Subclass Car inherits from SuperClass Vehicle
public class Car extends Vehicle{
    
    private int numberOfSeats;
    
    
    public Car(String registerPlate, String make, int numberOfSeats){
        //
        super(registerPlate, make);
        this.numberOfSeats = numberOfSeats;
    }
    
    public int getNumberOfSeats(){
        return numberOfSeats;
    }
    
    public void setNumberOfSeats(int numberOfSeats ){
        this.numberOfSeats = numberOfSeats;
    }
    
    @Override
    public String toString(){
        
        return "Number of Seats: " + numberOfSeats;
    }
    
    @Override
    public int calculateBasicTripCost() {
        
        if(numberOfSeats <= 5){
            return 500;
            
        }
        else{
            return 600;
        }
    }
    
//    public static void main(String[] args) {
//        
//        Car car = new Car("ASDHAS", "FORD", 6);
//        System.out.println(car.calculateBasicTripCost());
//        Car bigCar = new Car("ASDFSVD", "FORD", 3);
//        System.out.println(car.numberOfSeats);
//        System.out.println(car.getMake());
//        String descriptionBig = bigCar.getRegisterPlate() + " "
//                           + bigCar.getMake();
//        System.out.println(descriptionBig);
//        String descriptionSmall = car.getMake() + " " 
//                           + car.getRegisterPlate();
//        System.out.println(bigCar.calculateBasicTripCost() 
//                           + " " + descriptionBig + "\n"
//                           + car.calculateBasicTripCost() 
//                           + " " +
//                           descriptionSmall);
        
    }
    

