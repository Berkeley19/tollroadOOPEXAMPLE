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
public class Truck extends Vehicle {
    
    private int numTrailers;
    
    public Truck(String registerPlate, String make, int numTrailers){
        super(registerPlate, make);
        this.numTrailers = numTrailers;
    }
    public int getNumTrailers(){
        return numTrailers;
    }

    public void setNumTrailers(int NumTrailers){
        this.numTrailers = NumTrailers;
    }
    
    public String toString(int numTrailers){
        return "Number of Trailers =" + numTrailers;
    }
    @Override
    public int calculateBasicTripCost() {
        
        if(numTrailers == 1){
            return 1250;
        }else{
            return 1500;
        }
        
    }    
    
    public static void main(String[] args) {
        
        Truck truck = new Truck("JH67HRE", "FORD", 1);
        System.out.println(truck.calculateBasicTripCost());
//        Truck longTruck = new Truck("ASDFSVD", "FORD", 3);
//        System.out.println(longTruck.numTrailers);
//        System.out.println(truck.getRegisterPlate());
//        String descriptionNormal = truck.getMake() + " " 
//                                 + truck.getRegisterPlate() 
//                                 + " " + truck.numTrailers;
//        String descriptionLong = longTruck.getMake() + " "
//                                 + longTruck.getRegisterPlate() + " "
//                                 + longTruck.numTrailers;
//        System.out.println(truck.calculateBasicTripCost() 
//                                 + " " + descriptionNormal);
//        System.out.println(longTruck.calculateBasicTripCost() 
//                                 + " " + descriptionLong);
//        System.out.println();
        //Truck,JH67HRE,Abram,Wanamaker,Ford,1,1200,STAFF#
    }
}
