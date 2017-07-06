/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 * Typ tovaru, dan je navysena o 15%
 * 
 */
public class Alkohol extends Tovar{
    
   private double AlkDan=15;
   @Override
    public int vypocitaj(){
         this.setCena((int)((this.getCena()*(1+(this.getDan()+this.AlkDan)/100))));
        return (int)this.getCena();
    }

    public double getAlkDan() {
        return AlkDan;
    }

    public void setAlkDan(double AlkDan) {
        this.AlkDan = AlkDan;
    }

    
    
}
