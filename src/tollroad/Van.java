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
public class Van extends Vehicle{
    
    private int payload;
    
    public Van(String registerPlate, String make, int payload){
        super(registerPlate, make);
        this.payload = payload;
    }
    public int getPayload(){
        return payload;
    }

    public void setPayload(int payload){
        this.payload = payload;
    }
    
    public String toString(int payload){
        return "Payload =" + payload;
    }
    @Override
    public int calculateBasicTripCost() {
        
        if( payload <= 600){
            return 500;
        }
        else if (payload > 600 && payload <= 800){
            return 750;
        }   
        else {
            return 1000;
        }
       
    }
//    public static void main(String[] args) {
//        
//        Van smallVan = new Van("ASDHAS", "FORD", 375);
//        System.out.println(smallVan.calculateBasicTripCost());
//        Van mediumVan = new Van("ASDFSVD", "FORD", 620);
//        System.out.println(mediumVan.payload);
//        System.out.println(mediumVan.getRegisterPlate());
//        System.out.println(mediumVan.calculateBasicTripCost() + "  " + smallVan.calculateBasicTripCost());
//        Van largeVan = new Van("ASdnasf", "Toyata", 1250);
//        System.out.println(largeVan.calculateBasicTripCost() + " " + largeVan.payload + " " + largeVan.getMake());
//    }
}