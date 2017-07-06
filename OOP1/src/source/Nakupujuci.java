package source;

import java.util.List;

/**
 * Typ zamestnanca, nakupuje tovar, cim sa vlastne tovar pridava do zoznamu tovaru
 * 
 */

public class Nakupujuci extends Zamestnanec{
    private int provizia;
    public Nakupujuci(String meno, double peniaze, int provizia, List l) {
        super(meno, peniaze);
        this.setProvizia(provizia);
        l.add(this);
    }

    public int getProvizia() {
        return provizia;
    }

    public void setProvizia(int provizia) {
        this.provizia = provizia;
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
    
    public Tovar urob(Tovar tovar, String meno, float cena, int zdanenie, String jednotky, int mnozstvo, List l){
        tovar.setCena(cena);        
        tovar.setDan(zdanenie);
        tovar.vypocitaj();
        
        
        if(this.getPeniaze()>=(tovar.getCena()*mnozstvo)+provizia){
            this.setPeniaze((this.getPeniaze()-tovar.getCena()*mnozstvo)-provizia);
    // pridat typ a podla to ho vypocitat cenu s danou.        
    
    
            tovar.setMeno(meno);
            
            
            tovar.setMnozstvo(mnozstvo);
            tovar.setJednotka(jednotky);
            
            System.out.println("Tovar " + tovar.getMeno() +" " + tovar.getCena()+ " pridany.");
            System.out.println("Zamestnanec: " + this.getMeno() + " ma zostatok " + this.getPeniaze()+ ".");
            
            Faktura fakt = new Faktura();
            fakt.vytvorFakturu(this, tovar, (int)tovar.getCena(),mnozstvo, l);
            
        }
        return tovar;
    }
}
