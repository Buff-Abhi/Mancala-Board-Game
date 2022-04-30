package com.example.springboottutorial;

import java.util.ArrayList;

public class Board {
    //Singleton Design pattern as the Board instance is static.
    private static Board instance;
    private ArrayList<Cup> cups = new ArrayList<Cup>();

    private static int size = 14;

    //constructor for new board, sets it up ready for a new game of Mancala with each cup that isn't the mancala cups holding 4 stones
    /* Visualize board and indices as:
        12  11  10  9   8   7
    13                         6
        0   1   2   3   4   5
    */
    private Board(){ }

    //singleton getInstance function
    public static Board getInstance(){
        if(instance==null) {
            instance = new Board();
        }
        return instance;
    }

    public Cup getCup(int location){
        return cups.get(location);
    }

    public int getNumCups(){
        return cups.size();
    }

    //reset every cup in the board
    public void resetBoard(){
        Cup temp;
        boolean mancalaCup;
        for (int i = 0; i < size; i++){
            //if divisible by half of board size it is Mancala
            if((i+1) % (size/2) == 0){
                mancalaCup = true;
            }
            else{
                mancalaCup = false;
            }
            //make new cup, add to cups
            temp = new Cup(i, mancalaCup, this);
            cups.add(temp);
        }
        for(int i = 0; i < cups.size(); i++){
            cups.get(i).resetCup();
        }
    }
    //plays cup with location between 0 and 5 for both players and with playerNum of 1 or 2, returns the cup that the final stone is placed in
    //if not a valid move, returns null
    public Cup playCup(int location, int playerNum){
        //check if valid play
        int numStones;
        int l = 0;
        Cup finalCup = null;
        boolean isValid = false;
        if(playerNum == 1 && location > -1 && location < 6){
            isValid = true;
        }
        if(playerNum == 2 && location > 6 && location < 13){
            isValid = true;
        }
        if(isValid){
            //empty first cup
//               12 11 10 9 8 7
//            13                6
//                0 1 2 3 4 5
            numStones = cups.get(location).emptyCup();
            //loop through adding one stone to each cup after until there aren't any left
            for(int i = 1; i <= numStones; i++){
                if(location+i>13){
                    finalCup = cups.get(l);
                    l++;
                }
                else{
                    finalCup = cups.get((location+i));
                }
                //if cup is a mancala cup and isn't that player's, then skip over depositing
                if(finalCup.getIsMancala() && !finalCup.isOnPlayerSide(playerNum)){
                    numStones++;
                }
                else { //otherwise, deposit normally
                    finalCup.addStones(1);
                }
            }
        }
        return finalCup;
    }

    //check to see if either of the sides of the board are empty, and the game is over
    public boolean oneSideEmpty(){
        boolean isEmpty = true;
        //check each players' side
        for(int i = 0; i < 2; i++){
            //reset boolean
            isEmpty = true;
            //check each cup on that side
            for(int j = 0; j < 6; j++){
                //if there is a cup with stones, break from inner loop
                if(!cups.get(i*7 + j).isEmpty()){
                    isEmpty = false;
                    break;
                };
            }
            if(isEmpty){
                break;
            }
        }
        return isEmpty;
    }
}
