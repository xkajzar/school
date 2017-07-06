/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.ArrayList;
import java.util.List;

/**
 * Typ zamestnanca, pomocou metody urob presuva peniaze medzi zamestnancami
 * 
 */
public class Manazer extends Zamestnanec{
//List<Manazer> l = new ArrayList<>();
//private int pocet;
    public Manazer(String meno, double peniaze, List l) {
        super(meno, peniaze);
        l.add(this);
    }

   public String getMeno() {
        return super.getMeno();
    }

    public void setMeno(String Meno) {
        super.setMeno(Meno);
    }

    public double getPeniaze() {
        return super.getPeniaze();
    }

    public void setPeniaze(double peniaze) {
        super.setPeniaze(peniaze);
    }
    public void urob(int amount, Zamestnanec source, Zamestnanec dest){
    
    if(source !=null && dest !=null){    
    if(source.getPeniaze()>=amount){
        
        source.setPeniaze(source.getPeniaze()-amount);
        dest.setPeniaze(dest.getPeniaze()+amount);
        System.out.println("Manazer "+ this.getMeno() + " presunul "+ amount +" od zamestnanca "+ source.getMeno() + " k zamestnancovi " + dest.getMeno()+ ".");
        System.out.println(source.getMeno() + " : " + source.getPeniaze());
        System.out.println(dest.getMeno() + " : " + dest.getPeniaze());
    }
    else
        System.out.println("Zamestnanec nema dost penazi na presun");}
    else
        System.out.println("Zamestnanec neexistuje");
    }
    
    
    
   
        
    
    public void urob(int amount, Oddelenie source, Oddelenie dest, List l){
      
      source.setPeniaze(source.getPeniaze()-amount);
      dest.setPeniaze(dest.getPeniaze()+amount);
    }
    
    /*public Manazer(String meno, double peniaze) {
        this.setMeno(meno);
        this.setPeniaze(peniaze);
    }*/
    
    
    
}
