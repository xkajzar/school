/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 * Typ tovaru, k cene kazdeho kusu sa pripocita clo, je prekonana metoda vypocitaj
 * 
 */
public class Tabak extends Tovar{
   private int clo=2;
    public int vypocitaj(){
         this.setCena((int)((this.getCena()*(1+this.getDan()/100))+this.getClo()));
         return (int)this.getCena();
    }

    public int getClo() {
        return clo;
    }

    public void setClo(int clo) {
        this.clo = clo;
    }
    
}
