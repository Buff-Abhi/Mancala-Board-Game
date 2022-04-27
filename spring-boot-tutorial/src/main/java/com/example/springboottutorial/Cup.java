package com.example.springboottutorial;

public class Cup {
    private Board board = Board.getInstance();
    private int numStones;
    private boolean isMancala;
    private final int location;
    private final int opposite;
    private int playerNum;

    //constructor for cup in new game of mancala
    public Cup(int loc, boolean isM){
        Board board = Board.getInstance();
        if(isM){
            numStones = 0;
        }
        else{
            numStones = 4;
        }
        if(loc > 0)
        isMancala = isM;
        location = loc;
        opposite = board.getNumCups()-location;
    }

    //returns numerical location of the cup
    public int getLocation(){
        return location;
    }

    //returns numerical location of the cup opposite of this one
    public int getOppositeLocation(){
        return opposite;
    }

    //returns whether or not the cup is one of the end Mancala cups
    public boolean getIsMancala(){
        return isMancala;
    }

    public boolean isEmpty() {
        return (numStones == 0);
    }

    public boolean isOnPlayerSide(int playerNum){
        if(location < (board.getNumCups()/2) -1 && playerNum == 1){
            return true;
        }
        else if(location > board.getNumCups()/2 && playerNum == 2){
            return true;
        }
        else {
            return false;
        }
    }
    //adds specified number to numStones
    public void addStones(int num){
        numStones += num;
    }

    //empties the cup and returns the number of stones that were in it
    public int emptyCup(){
        int temp = numStones;
        numStones = 0;
        return temp;
    }

    //reset cup for a new game
    public void resetCup(){
        if(isMancala){
            numStones = 0;
        }
        else{
            numStones = 4;
        }
    }
}