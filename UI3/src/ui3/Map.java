/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui3;

import java.util.Scanner;

/**
 *
 * @author Mário
 */
public class Map {
int map[][];
int n;
int m;


public void createmap( int m, int n ){
this.n=n;
this.m=m;
Scanner input= new Scanner(System.in);
int x=0, y, z=1;
while(true){
System.out.println("Enter 1 to place rocks, 0 to finish");
      z=input.nextInt();
      if(z==0){
          break;
      }
    System.out.println("Enter rocks (m n)");
      x=input.nextInt();
      y=input.nextInt(); 
      this.map[x][y]=-1;
      
      
}
}

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }


public void render(){
for(int i=0; i<this.m; i++){
    for(int j=0; j<this.n; j++){
        System.out.print(" " + this.map[i][j] + " ");
    }System.out.print("\n");
}    
}
}
