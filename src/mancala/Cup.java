package mancala;

public class Cup {
    private int numStones;
    private boolean isMancala;
    private int location;
    private int opposite;

    private Cup nextCup;
    private Cup prevCup;

    //constructor for cup in new game of mancala
    public Cup(int loc, boolean isM){
        if(isM){
            numStones = 0;
        }
        else{
            numStones = 4;
        }
        isMancala = isM;
        location = loc;
        opposite = 13-location;
    }

    //getters//
    public int getLocation(){
        return location;
    }

    public int getOppositeLocation(){
        return opposite;
    }

    public boolean getIsMancala(){
        return isMancala;
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
