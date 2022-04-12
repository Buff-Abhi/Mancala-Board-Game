package mancala;

public class Game {
    private Board board;
    private Player[] players;

    public Game(boolean isMultiplayer){
        //get board instance and reset it
        board = Board.getInstance();
        board.resetBoard();
        //make factory to create players of correct type depending on whether game is single player or multiplayer
        PlayerFactory factory = new PlayerFactory();
        Player player1 = factory.returnPlayer(PlayerType.HUMAN);
        Player player2;
        if(isMultiplayer){
            player2 = factory.returnPlayer(PlayerType.HUMAN);
        }
        else{
            player2 = factory.returnPlayer(PlayerType.COMPUTER);
        }
        Player[] players = {player1, player2};
    }

    public void playGame(){
        boolean gameOver = false;
        Player currentPlayer;
        while (!gameOver){
            for(int i = 0; i < players.length; i++){
                currentPlayer = players[i];
                currentPlayer.makeMove();
            }
        }
    }
}
