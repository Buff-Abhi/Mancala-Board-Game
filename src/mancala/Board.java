package mancala;

import java.util.ArrayList;
import java.util.Iterator;

//singleton design pattern
public class Board {
    private ArrayList<Cup> cups;
    private Board instance = new Board();

    //constructor for new board, sets it up ready for a new game of Mancala with each cup that isn't the mancala cups holding 4 stones
    /* Visualize board and indices as:
        0   1   2   3   4   5
    13                         6
        12  11  10  9   8   7
    */
    private Board(){
        Cup temp;
        boolean mancalaCup;
        for (int i = 0; i < 14; i++){
            //if divisible by 6 it is Mancala
            if(i % 6 == 0){
                mancalaCup = true;
            }
            else{
                mancalaCup = false;
            }
            //make new cup, add to cups
            temp = new Cup(i, mancalaCup);
            cups.add(temp);
        }
    }

    public Board getInstance(){
        return instance;
    }

    //reset board for a new game
    public void resetBoard(){
        Iterator<Cup> iterator = cups.iterator();
        while(iterator.hasNext()){
            iterator.next().resetCup();
        }
    }

    //plays cup with location between 0 and 5 for both players and with playerNum of 1 or 2
    public void playCup(int location, int playerNum){
        //check if valid play
        boolean isValid = false;
        if(location > -1 && location < 6){
            isValid = true;
        }
        if(isValid){
            //update location to be correct for entire board
            location = 1;
        }
    }
}
