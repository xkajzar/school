
package source;



/**
 * Zamestnanec je abstraktna trieda, od ktorej dedia konkretny zamestnanci
 * 
 */
abstract class  Zamestnanec{
   private String Meno;
   private double peniaze;

    public String getMeno() {
        return Meno;
    }

    public void setMeno(String Meno) {
        this.Meno = Meno;
    }

    public double getPeniaze() {
        return peniaze;
    }

    public void setPeniaze(double peniaze) {
        this.peniaze = peniaze;
    }
    public void urob(){
        
    }

    public Zamestnanec(String meno, double peniaze) {
        this.setMeno(meno);
        this.setPeniaze(peniaze);
    }
    
}
