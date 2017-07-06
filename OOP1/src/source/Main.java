
package source;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*  
 *  Objekty treba najskor vytvorit v gui, potom zobrazit ich zoznam, ich miesto
 *  v zozname je ID pomocou ktoreho sa k nim pristupuje.
 *  Vacsina funkcionality je v metode urob, ktoru dedia vsetci zamestnanci
 *  a je prekonana/pretazena.
 *  Tovar sa pridava cez nakupujuceho formou kup.
 */
public class Main {

PrintStream output;
static Zamestnanec model;
static JFrame frame= new JFrame();
static NewJDialog gui = new NewJDialog(frame, true);



List<Manazer> list = new ArrayList<Manazer>();
List<Nakupujuci> nlist = new ArrayList<Nakupujuci>();
List<Predavac> plist = new ArrayList<Predavac>();
List<Tovar> tlist = new ArrayList<Tovar>();
List<Faktura> flist = new ArrayList<Faktura>();
/**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
    
  PrintStream out1 = new PrintStream( new TextAreaOutputStream( gui.getOutputArea(1) ) );
  
  Oddelenie init = new Oddelenie();
  init.initiate();
  
  System.setOut( out1 );
     
    gui.setVisible(true);
    gui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    System.exit(0);
   
  
    
    }
   
    public void createM(String name, double peniaze){
        Manazer man = new Manazer(name, peniaze, list);
        //this.list.add(man);
    }
    
    public void createP(String name, double peniaze, int marza){
    Predavac p= new Predavac(name, peniaze, marza, plist);
    //this.plist.add(p);
    }
    
    public void createN(String name, double peniaze, int provizia){
    Nakupujuci n = new Nakupujuci(name, peniaze, provizia, nlist);  
    //this.nlist.add(n);
    }
    
    /*public void createT(String meno, float cena, int zdanenie, String jednotky, int mnozstvo){
        Tovar t = new Tovar(meno, zdanenie, cena, mnozstvo, jednotky);
        this.tlist.add(t);
    }*/
    
    public void presun(int idm, int idsource, int iddest, int peniaze, String strsr, String strdt){
        Manazer m;
        Zamestnanec source= null;
        Zamestnanec dest = null;
        m=list.get(idm);
        if(strsr=="Manazer")
        source = list.get(idsource);
        if(strsr=="Nakupujuci")
        source=nlist.get(idsource);
        if(strsr=="Predavajuci")
        source=plist.get(idsource);
        
        
        if(strdt=="Manazer")
        dest = list.get(iddest);
        if(strdt=="Nakupujuci")
        dest=nlist.get(iddest);
        if(strdt=="Predavajuci")
        dest=plist.get(iddest);
        
        m.urob(peniaze, source, dest);
    }
    
    public void kup(int idnak, String meno, float cena, int mnozstvo , String jednotky, int zdanenie, int typ){
       Nakupujuci n = nlist.get(idnak);
       if(n.getPeniaze()>=cena*mnozstvo+n.getProvizia()){
       
       Tovar t=null;
       if(typ==0){
           t=new Tovar();
       }
       
       if(typ==1){
           t=new Alkohol();
       }
       if(typ==2){
           t=new Tabak();
       }
       t=n.urob(t, meno, cena, zdanenie, jednotky, mnozstvo, flist);
       this.tlist.add(t);
               
      
       
       
    }
    }
    public void predaj(int idpred, int idtov, int mnozstvo){
        Predavac pred;
        Tovar to;
        pred = plist.get(idpred);
        to = tlist.get(idtov);
        int cena=(int)to.getCena();
        to=pred.urob(to, mnozstvo, cena, flist);
        if(to.getMnozstvo()==0){
            tlist.remove(idtov);
        }
        
        
    }
    
    
    public void showManList(){
        int i = 0;
      //  Manazer[] man= new Manazer[list.size()];
        Manazer ma;
        for(Iterator<Manazer> m = list.iterator(); m.hasNext();){
          ma = m.next();
          System.out.println(i+ " "+ ma.getMeno()+ " "+ ma.getPeniaze());
          i++;
        }
    }
   
    public void PList(Predavac m){
        plist.add(m);
    }
    public void showPList(){
        
        Predavac ma=null;
        int i=0;
        for(Iterator<Predavac> m = plist.iterator(); m.hasNext();){
          ma = m.next();
          System.out.println(i+" "+ma.getMeno()+ " "+ ma.getPeniaze() + " " +ma.getMarza());
          i++;
        }
    }
    /*public void getPList(){
        Predavac[] man= new Predavac[plist.size()];
        Predavac ma;
        Iterator<Predavac> m = plist.iterator();
        
    }*/
    public void showNList(){
        int i = 0;
       
        Nakupujuci na=null;
        for(Iterator<Nakupujuci> n = nlist.iterator(); n.hasNext();){
          na = n.next();
          System.out.println(i+ " "+ na.getMeno()+ " "+ na.getPeniaze()+ " " +na.getProvizia());
          i++;
        }
    
    }
    
    public void showFList(){
      
       System.out.println("Faktury: ");
        Faktura na=null;
        for(Iterator<Faktura> n = flist.iterator(); n.hasNext();){
          na = n.next();
          na.vypis();
          
        }
    
    }
    
    public void showTList(){
        
        Tovar to=null;
        int i=0;
        for(Iterator<Tovar> t = tlist.iterator(); t.hasNext();){
          to = t.next();
          System.out.println("ID: "+ i +" " +to.getMeno()+ " Cena: " + to.getCena() + " Mnozstvo: "+ to.getMnozstvo() +" "+ to.getJednotka() +"." );
        i++;
        }
        
    }
    
    public void getList(String str){
        if(str == "Manazer")
            this.showManList();
        if(str=="Predavajuci")
            this.showPList();
        if(str=="Nakupujuci")
            this.showNList();
        if(str=="Tovar")
            this.showTList();
    }
  /*  public void workList(String str){
        if(str == "Manazer")
            
        if(str=="Predavajuci")
            
        if(str=="Nakupujuci")
            str="";
    }*/
    public void  zrataj(){
        int spolu=0;
        
        Zamestnanec za;
        for(Iterator<Manazer> z = list.iterator(); z.hasNext();){
          za = z.next();
          spolu+=za.getPeniaze();
          }
        
         for(Iterator<Nakupujuci> z = nlist.iterator(); z.hasNext();){
          za = z.next();
          spolu+=za.getPeniaze();
    }
          for(Iterator<Predavac> z = plist.iterator(); z.hasNext();){
          za = z.next();
          spolu+=za.getPeniaze();
}
          System.out.println("Zamestnanci maju spolu " + spolu+" penazi" );
          
    }
    
        /*public void OdList(){
            int spolu = zrataj();
            
        }*/
}
