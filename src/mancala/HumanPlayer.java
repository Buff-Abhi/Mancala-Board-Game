package mancala;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private String name;
    private int playerNum;
    private int score;

    public HumanPlayer(String n, int num){
        name = n;
        playerNum = num;
        score = 0;
    }

    //ask user for move, play off of it on Board
    public void makeMove(Board board){
        //ask user for a move between 0 and 5
        System.out.println("Please choose a # between 0 and 5 (inclusive) according to your cup location you would like to play");
        Scanner in = new Scanner((System.in));
        int chosenNum = in.nextInt();
        if(chosenNum > 5 || chosenNum < 0){
            while(chosenNum < 0 && chosenNum > 5){
                System.out.println("This input is not in the specified range, please enter a number between 0 and 5 inclusive");
                chosenNum = in.nextInt();
            }
            System.out.println("this works");
        }
        //play cup based on that choice
        board.playCup(chosenNum, playerNum);
    }
}
