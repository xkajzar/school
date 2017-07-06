/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mário
 */
public class UI3 {
    
    public static void main(String[] args) {
     Scanner input= new Scanner(System.in);
     int n=0, m=0, j=5, i=0;
     Map startmap= new Map();
     List<Individual> list = new ArrayList<Individual>();
   //  Comparator comp= new Comparator() 
         
  
     System.out.println("Enter size (m-height, n-width)");
      m=input.nextInt();
      n=input.nextInt();   
      startmap.map= new int[m][n];
      startmap.createmap(m, n);
      startmap.render();
      
      
    for(i=0; i<j; i++){
        Individual init = new Individual();
        System.out.println("Init "+i);
        init.fill(n, m);
        list.add(init);
    }
     
    Individual init=new Individual();
    init.child(list.get(0), list.get(1), (n+m));
    list.add(init);
    
     i=0;
    
     
     while(i<list.size()){
     Individual test1= list.get(i);
    
     
      
      
     // test1.fill(n, m);
      test1.calculate(startmap);
      test1.m2.render();
      test1.countvalue();
      i++;
     }
    
     /* list.sort(c);*/
    }
    
        
}
