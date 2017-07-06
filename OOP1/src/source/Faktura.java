
package source;

import java.util.List;

/**
 *Faktura vznika pri kazdom nakupe alebo predaji, uklada sa do zoznamu faktur
 * 
 */
public class Faktura {
private Zamestnanec z;
private Tovar t;
private int cena;
private int mnozstvo;

    

public void vytvorFakturu(Zamestnanec z, Tovar t, int cena,int mnozstvo, List l){
   this.setZ(z);
   this.setCena(cena);
   this.setT(t);
   this.setMnozstvo(mnozstvo);
   l.add(this);
      
}
public void vypis(){
    System.out.println("Zamestnanec "+this.getZ().getMeno()+" Tovar "+ this.getT().getMeno() +" Cena " +this.getCena() + " Mnozstvo " + this.getMnozstvo());
    
    
}

    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

    public Zamestnanec getZ() {
        return z;
    }

    public void setZ(Zamestnanec z) {
        this.z = z;
    }

    public Tovar getT() {
        return t;
    }

    public void setT(Tovar t) {
        this.t = t;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
