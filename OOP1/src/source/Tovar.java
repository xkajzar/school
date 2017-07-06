/*d
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * Tovar je druha hierarchia, kazdy druh tovaru ma prekonanu metodu vypocitaj,
 * v ktorej sa meni vypocet ceny v zavislosti na dani.
 * Trieda tovar nie je abstraktna a berie sa ako zakladna trieda, ktorej instancie
 * maju iba zakladne zdanenie
 */


public class Tovar {
   private String meno;
   private float dan;
   private float cena;
   private int mnozstvo;
   private String jednotka;



   public Tovar() {
        
    }

   
    public int vypocitaj(){
        this.setCena((int)((this.cena*(1+this.dan/100))));
        System.out.println("cena " + this.getCena());
        return (int)this.cena;
    }
   public Tovar(String name, float tax, float prize, int amount, String jed) {
        this.meno=name;
        this.dan = tax;
        this.cena = prize;
        this.mnozstvo = amount;
        this.jednotka=jed;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public float getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

    public String getJednotka() {
        return jednotka;
    }

    public void setJednotka(String jednotka) {
        this.jednotka = jednotka;
    }
    
}

