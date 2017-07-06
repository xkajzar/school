package source;

import java.util.List;

/**
 *Typ zamestnanca, pomocou metody urob predava tovar, tovar musi byt v zozname tovaru
 * a musi ho byt dostatocne mnozstvo, kazdy predavac ma nastavenu marzu, co je percentualne
 * navysenie ceny
 */

public class Predavac extends Zamestnanec{
private double marza;
    
    
    public Predavac(String meno, double peniaze, int marza, List l) {
        super(meno, peniaze);
        this.setMarza(marza);
        l.add(this);
    }

    public double getMarza() {
        return marza;
    }

    public void setMarza(int marza) {
        this.marza = marza;
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
    
    public Tovar urob(Tovar tovar, int mnozstvo, int cena, List l){
        if(tovar.getMnozstvo()>=mnozstvo){
        this.setPeniaze(this.getPeniaze() + (cena*(1+(this.marza/100)))*mnozstvo);
        System.out.println("Zamestnanec "+ this.getMeno() + " " + this.getPeniaze());
        
        tovar.setMnozstvo(tovar.getMnozstvo()-mnozstvo);
       
        Faktura fakt = new Faktura();
            fakt.vytvorFakturu(this, tovar, (int)tovar.getCena(),mnozstvo, l);
            
        
        return tovar;}
        else{
        System.out.println("Tovaru nie je dost na operaciu");
        return tovar;
        }
        }
            
        
    }
   
