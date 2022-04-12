package mancala;

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
    public void makeMove(){
        //ask user for a move between 0 and 5

        //call playCup(chosenNum, playerNum)
    }
}
