package ui3;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.util.Random;

/**
 *
 * @author Mário
 */
public class Individual implements Comparable<Individual>{
    int genes[];
    int value;
    int generation;
    Map m2;
    
    public void fill(int n, int m){

  Random generator = new Random();
  
  this.genes=new int[(m+n)] ;    
  for(int i=0; i<m+n; i++){
            this.genes[i]  =generator.nextInt(2*(m+n)); //((int)(Math.random() * (m+n)));
      //      System.out.println(this.genes[i]+ " ");
        }
        
      //  System.out.print("Fill done ");
    }  

    public void child(Individual ind1, Individual ind2, int n){
        
 //     Individual ind4= new Individual();
    int[] temparray;
    temparray = new int[n+1];
    System.out.println(n);
    System.out.println(ind2.genes.length + " " +ind1.genes.length);
        System.arraycopy(ind1.genes, 0, temparray, 0, (n/2)-1);
        //System.arraycopy(ind1.genes, (int)n/2, temparray,(int) n/2 ,(int)n-1 );
        for(int i=n/2; i<n; i++){
            temparray[i]= ind2.genes[i];
        }
        this.genes= temparray;
        Random gen = new Random();
        if(gen.nextInt(100)>95){
            int i=(int) (Math.random() *(n -1));
            this.genes[i]=(int)(Math.random() * n);
      System.out.println("Change "+ i + " " + this.genes[i]);
        }
    }


public void calculate(Map m1){
  int i=0, x=0, y=0,z=0, entry, movex=0, movey=0;
 this.m2=new Map();
 
//  this.m2.map = m1.getMap();

 

 this.m2.m=m1.m;
 this.m2.n=m1.n;
 
int[][] temparray;
temparray= new int[m1.m][m2.m];
 
 
 for(int j=0; j<m1.m; j++){
  System.arraycopy(m1.map[j], 0, temparray[j], 0, this.m2.n); //output map
 }
 this.m2.map = temparray;

 while(i<(m2.m+m2.n) && z==0){
   
    entry=this.genes[i];        //entry point
   if(entry<m2.n){
       x=0; y=entry; movex=1; movey=0;
   }
   if((!(entry<m2.n)) && entry<m2.n + m2.m){
       x=entry-m2.n;
       y=m2.n-1;
       movex=0; movey=-1;}
   if(!(entry<m2.n) && !(entry<m2.n + m2.m) && entry< 2*m2.n+m2.m){
       x=m2.m-1; y=entry%(m2.n+m2.m);
       movex=-1;
       movey=0;
   }
   if(entry>=2*m2.n +m2.m){
       x=entry%(2*m2.n + m2.m);
       y=0; movex=0; movey=1;
   } 
   if(m2.map[x][y]!=0){ // Entry point control
       i++;
       continue;
   }
   while(z==0 && x<m2.n && y<m2.m && x>=0 && y>=0){   
       
      if(m2.map[x][y]==0){
         m2.map[x][y]=i+1;
         x+=movex; y+=movey;
      continue;}
      else{
      x-=movex; y-=movey; 
          if(movex==0 && (x<=0 || x==m2.n-1)) //edge
              break;
          if(movey==0 && (y<=0 || y==m2.m-1)) // edge
              break;
          if(movex==0  && m2.map[x+1][y]!=0 && m2.map[x-1][y]!=0){ //stuck
              z=1;
              break;
          }
          if(movey==0  && m2.map[x][y+1]!=0 && m2.map[x][y-1]!=0){ //stuck
              z=1;
              break;
          }
          if(movex==0){         //turn
              movey=0;
              if(this.genes[i]<(m2.m+m2.n)/2 && m2.map[x-1][y]==0){
                  
                  movex=-1;
                  x+=movex;
                  
                  
              }
              else{
                  if(m2.map[x+1][y]==0){
                  movex=1;
                  x+=movex;}
                  else{
                  movex=-1;
                  x+=movex;  
                          }
              }
              
          }
          else{
              movex=0;
              if(this.genes[i]<(m2.m+m2.n)/2 && m2.map[x][y-1]==0){
                 
                  movey=-1;
                  y+=movey;}
               
              
              
              else {
              if(m2.map[x][y+1]==0){
              movey=1;
              y+=movey;}
              else{
              movey=-1;
              y+=movey;       
                      }
          }}
          
          
          /* if(genes[i]<n.n/2)
          //left
      else
      right   */ 
          }
      } i++;// System.out.println("loop:" + i);
   //   else
     
  }
  } 
    public void countvalue(){
        int value=0;
        for(int i=0; i<m2.m; i++){
            for(int j=0; j<m2.n; j++){
            if(m2.map[i][j]!=0)
                value++;
            }
            
        }
        this.value=value;
        System.out.println(this.value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Individual o) {
         if(this.getValue()==o.getValue())
        return 0;
    if(this.getValue()>o.getValue())
        return 1;
    if(this.getValue()<o.getValue())
        return -1;
    
   return 0;
    
   }
    }

