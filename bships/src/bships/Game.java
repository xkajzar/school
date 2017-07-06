/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bships;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Game {
    int board[][], z, x, y, pokusy=0;
    
    
    
    
    
    
    
    
    public Game(int x, int y, int z){           //Inicializacia
        Random generator= new Random();
        this.x=x;
        this.y=y;
        this.board=new int[x][y];
        this.z=z;
        int xint, yint;
        
        for(int i=0; i<z; i++){
            xint=generator.nextInt(x);
            yint=generator.nextInt(y);
            if(board[xint][yint]==0){
                board[xint][yint]=1;
            }
            else{
                i--;
            }
        }
        
        
        
        
        
    }
    public void display(){                      //zobrazi hraciu plochu
        System.out.print("   ");
        for(int i=0; i<this.y; i++){
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for(int i=0; i<this.x; i++){
            System.out.print(i + "  ");
            for(int j=0; j<this.y; j++){
                if(this.board[i][j]==0 || this.board[i][j]==1){
                    System.out.print("0 ");
                }
                else if(this.board[i][j]==3){
                    System.out.print("X ");
                }
                else if(this.board[i][j]==2){
                    System.out.print("# ");
                }
            }
            System.out.print("\n");
            
        }
        System.out.print("\n\n");
        System.out.println("0 - Nezname policko, # - Strela vedla, X - Zasah");
    }
    
    public void play(Game game){                    //Hra
        int i=0, xcoor, ycoor;
        Scanner scan=new Scanner(System.in);
        
        while(i<this.z){
            this.display();
            System.out.println("Zadajte 2 koordinaty medzi 0 az " + (x-1) + " a 0 az " + (y-1) + ".");
            if(scan.hasNextInt()){
                xcoor=scan.nextInt();
            }
            else{
                scan.next(); continue;
            }
            
            if(scan.hasNextInt()){
                ycoor=scan.nextInt();
            }
            else{
                scan.next(); continue;
            }
            
            
            if(xcoor>=this.x || ycoor>=this.y){
                System.out.println("Tah je mimo hracej plochy");
                continue;
            }
            
            switch (this.board[xcoor][ycoor]) {
                case 0:
                    this.board[xcoor][ycoor]=2;
                    this.pokusy++;
                    continue;
                case 1:
                    this.board[xcoor][ycoor]=3;
                    i++;
                    this.pokusy++;
                    break;
                default:
                   System.out.println("Neplatny tah");
                   break;
            }
            
        }
        this.display();
        System.out.println("Trafili ste vsetky/vsetkych "+ z + " lodi.\n" + "Potrebovali ste na to "+ pokusy + " pokusov.");
    }
}
