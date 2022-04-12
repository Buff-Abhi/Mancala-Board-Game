package mancala;

public class ComputerPlayer implements Player{
    int playerNum;

    public ComputerPlayer(){
        playerNum = 2;
    }
    //decide a move randomly, play off of it on Board
    public void makeMove(Board board){
        //random # generator choose a # between 0 and 5
        int randomNumber = (int) (Math.random() * 5);
        //play cup based on that #
        board.playCup(randomNumber, playerNum);
    }
}
