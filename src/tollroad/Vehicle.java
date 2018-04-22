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


public abstract class Vehicle {
    
    private String registerPlate;
    private String make;
    

    
    public Vehicle() {
    
        this.registerPlate = "";
        this.make = "";
        
     
        
}
    public Vehicle(String registerPlate, String make){
        
        this.registerPlate = registerPlate;
        this.make = make;
        
    }
    
    public String getMake(){
        
        return make;
    }
    
    public String getRegisterPlate(){
        
        return registerPlate;
        
    }
    
    
    public void setMake(String make){
        
        this.make = make;
    }
    
    public void setRegisterPlate(String registerPlate){
        
        this.registerPlate = registerPlate;
    }
    
    @Override
    public String toString(){
        
        return "Make = " + getMake() + "\n"  
               + "RegisterPlate = " + getRegisterPlate();
    }
                
    /**
     *
     * @return
     */
    public abstract int calculateBasicTripCost();
    
    
    
    
    public static void main(String[] args) {
        
        
    }
            
         
}
