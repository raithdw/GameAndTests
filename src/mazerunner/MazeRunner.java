package mazerunner;


import java.util.Scanner;

public class MazeRunner {
    static Maze myMap = new Maze();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String node = "";
        boolean alive = false, wall;
        int movecount = 0;

        intro();
        while(!alive){
            wall = false;   //Resets wall variable
            node = userMove();
            if(!navigatePit(node)) {
                break;
            }
            switch (node) {
                case "R":
                    movecount++;
                    if (myMap.canIMoveRight()) {
                        myMap.moveRight();
                    }
                    else {
                        wall = true;
                    }
                    break;
                case "L":
                    movecount++;
                    if (myMap.canIMoveLeft()) {
                        myMap.moveLeft();
                    }
                    else {
                        wall = true;
                    }
                    break;
                case "U":
                    movecount++;
                    if (myMap.canIMoveUp()) {
                        myMap.moveUp();
                    }
                    else {
                        wall = true;
                    }
                    break;
                case "D":
                    movecount++;
                    if (myMap.canIMoveDown()) {
                        myMap.moveDown();
                    }
                    else {
                        wall = true;
                    }
                    break;
                default:
            }
            myMap.printMap();

            if (wall) {
                System.out.println("Sorry. you have hit a wall");
            }

            System.out.println("Remaining moves: "+ (100 - movecount));

            if (!moveMessage(movecount)) {
                break;
            }

            alive=myMap.didIWin();
            if(myMap.didIWin()){
                System.out.println("Congratulations, you have made it out alive in " + movecount + " moves");
            }
        }
    }

    //Greet user and show current position
    private static void intro(){
        System.out.println("Welcome to Maze Runner!\nHere is your current position: ");
        myMap.printMap();
    }

    //Prompt user for navigation direction
    private static String userMove() {
        boolean move = true;
        String dir = "";
        while (move) {
            System.out.println("Where would you like to move? (R, L, U, D): ");
            dir = sc.nextLine().trim().toUpperCase();
            if (dir.matches("[RLUD]")) {
                move = false;
            }
        }
        return dir;
    }

    //Warn user about pit and navigate.
// Exit on discontinuation or wrong entry.
    private static boolean navigatePit(String s) {
        String ans = "";
        if (myMap.isThereAPit(s)) {
            while (!(ans.matches("[yYnN]"))) {
                System.out.print("Watch out! There's a pit ahead, jump it?");
                ans = sc.nextLine().trim();
                if (ans.matches("[yY]")) {
                    myMap.jumpOverPit(s);
                    return true;
                } else {
                    System.out.print("Sorry! You have lost!");
                    return false;
                }
            }
        }
        return true;
    }

    //Alert user on move status
    private static boolean moveMessage(int n) {
        if (n == 50 ){
            System.out.println("Warning: You have made 50 moves, " +
                    "you have 50 remaining before the maze exit closes");
            return true;
        }
        if (n == 75 ){
            System.out.println("Alert! You have made 75 moves, " +
                    "you only have 25 moves left to escape.");
            return true;
        }
        if (n == 90 ){
            System.out.println("DANGER! You have made 90 moves, " +
                    "you only have 10 moves left to escape!!");
            return true;
        }
        if (n == 100 ){
            System.out.println("Oh no! You took too long to escape, " +
                    "and now the maze exit is closed FOREVER >:[\n" +
                    "Sorry, but you didn't escape in time - you lose!");
            return false;
        }
        return true;
    }
}







