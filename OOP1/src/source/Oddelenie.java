/*
 * TODO 
 * 
 * 
 */
package source;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Oddelenie predstavuje tok penazi na vyssej urovni, v prevedeni programu je to len
 * dalsia trieda, s ktorej instanciami moze manazer pracovat, t.j. menit peniaze
 */
public class Oddelenie {
   private String meno;
   private int peniaze;
   private List list= new ArrayList();

    public Oddelenie() {
   
    }

   public void initiate(){
       Oddelenie od1 = new Oddelenie("Toto", 0);
       Oddelenie od2 = new Oddelenie("Vedlajsie", 0);
       Oddelenie od3 = new Oddelenie("Stare", 0);
       list.add(od1);
       list.add(od2);
       list.add(od3);
   }

    public Oddelenie(String meno, int peniaze) {
        this.meno = meno;
        this.peniaze = peniaze;
    }
   
   public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
  
   
    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public int getPeniaze() {
        return peniaze;
    }

    public void setPeniaze(int peniaze) {
        this.peniaze = peniaze;
    }
   
   
}
