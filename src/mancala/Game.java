package mancala;

public class Game {
    private Board board;
    private Player[] players;

    public Game(boolean isMultiplayer){
        board = new Board();
        //make factory to create players of correct type depending on whether game is single player or multiplayer
        PlayerFactory factory = new PlayerFactory();
        Player player1 = factory.returnPlayer(HUMAN);
        if(isMultiplayer){
            Player player2 = factory.returnPlayer(HUMAN);
        }
        else{
            Player player2 = factory.returnPlayer(COMPUTER);
        }
        players = [player1, player2];
    }

    public void playGame(){

    }
}
