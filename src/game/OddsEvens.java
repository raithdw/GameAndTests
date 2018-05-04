package game;

import java.util.Random;
import java.util.Scanner;

public class OddsEvens {
    public static void main(String[] args) {

        System.out.println("Let's play a game called \"Odds and Evens\"");
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();

        if (name.equals("")) {
            System.out.println("Invalid name");
        }else {
            System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens ?");
        }

        String song = input.nextLine();
         if (song.equalsIgnoreCase("o")){
            System.out.println(name + " has picked odds! The computer will be evens.");
        }else if (song.equalsIgnoreCase("e")){
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        System.out.println("-------------------------------------------------");


        System.out.print("how many \"fingers\" do you put out");
        int number =input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \"fingers\".");
        System.out.println("--------------------------------------------------");
        int sum = number + computer;
        System.out.println( number + " + " + computer + " = " + sum);
        if (sum%2==0){
            System.out.println(sum + " is...even");
            if (song.equalsIgnoreCase("e")){
                System.out.println("That means " + name + " Wins!");
            }else {
                System.out.println("That means the computer wins");
            }
        }else{
            if (sum%2==1){
                System.out.println(sum + " is...odd");
                if (song.equalsIgnoreCase("o")){
                    System.out.println("That means " + name + " Wins!");
                }else {
                    System.out.println("That means the computer wins");
                }
            }

        }

    }
}






