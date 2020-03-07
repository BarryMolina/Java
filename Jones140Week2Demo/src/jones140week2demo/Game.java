/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jones140week2demo;

import java.util.Scanner;

public class Game {
    
    //Two dimensional array declaration
    int[][] playerScores = new int[10][5];
    int[][] computerScores = new int[10][5];
    Scanner keyboard = new Scanner(System.in);
    int round = 0;
    
    public Game()
    {
        introduction();
        int counter = 0;
        while(counter < 10)
        {
            startGame();
            counter++;
        }
        
        
        
    }
    
    
    public void introduction()
    {
       System.out.println("Welcome to my Of A Kind Game! ");
       System.out.println(
               "  ____\n" +
" /\\' .\\    _____\n" +
"/: \\___\\  / .  /\\\n" +
"\\' / . / /____/..\\\n" +
" \\/___/  \\'  '\\  /\n" +
"          \\'__'\\/");
    }
    
    
    public void directions()
    {
        System.out.println("The computer and the user will each throw five dice in a round. "
                + "\nThe winner of each round will be determined by how many of one number "
                + "\nof a die and the value of the number rolled. "
                + "\nThere will be ten rounds overall per game. ");
    
    }
    
    public int getRandomNumber()
    {
        int rollValue;
        rollValue = (int)(Math.random() * 6+1);     //get a random integer between 1-6.
        return rollValue;
    }
    
    public void startGame()
    {
      
        System.out.println("Press (R) to roll. Press (Q) to quit. ");
        char screenInput = keyboard.next().toUpperCase().charAt(0);
         
        if(screenInput == 'R' && round < 10)
        {
            for(int i = 0; i < 5; i++)
            {
               playerScores[round][i] = getRandomNumber();
               System.out.print("[" + playerScores[round][i] + "]");
            }
            
            //automatically roll for the computer
            System.out.println();
            for(int i = 0; i < 5; i++)
            {
               computerScores[round][i] = getRandomNumber();
               System.out.print("[" + computerScores[round][i] + "]");
            }
            System.out.println();
        }
        else
        {
            //write logic to quit or handle other necessary situations
        }
      
        determineOfAKinds(); 
        //add 1 to round
        round++;
    
    }
    
    public void determineOfAKinds()
    {
        int j = 0;
        int total6s = 0;
        int total5s = 0;
        int total4s = 0;
        int total3s = 0;
        int total2s = 0;
        int total1s = 0;
        int roll;
        
        while (j < 5) {
            
            roll = playerScores[round][j];
            
            switch(roll) {
            
                case 1: total1s++;
                    break;
                case 2: total2s++;
                    break;
                case 3: total3s++;
                    break;
                case 4: total4s++;
                    break;
                case 5: total5s++;
                    break;
                default: total6s++;
                        break;
              
            }//end switch
            j++;
     
        }
            
        System.out.println("total1s " + total1s);
        System.out.println("total2s " + total2s);
        System.out.println("total3s " + total3s);
        System.out.println("total4s " + total4s);
        System.out.println("total5s " + total5s);
        System.out.println("total6s " + total6s);   
    }
    
    
}
