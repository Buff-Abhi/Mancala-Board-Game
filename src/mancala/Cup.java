package mancala;

public class Cup {
    private int numStones;
    private final boolean isMancala;
    private final int location;
    private final int opposite;

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
