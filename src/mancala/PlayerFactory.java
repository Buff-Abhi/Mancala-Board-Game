package mancala;

public class PlayerFactory {
    public PlayerFactory(){

    }
    //TODO decide if player should be abstract class or interface
    public Player returnPlayer(PlayerType type){
        Player p;
        if (type == PlayerType.HUMAN){
            System.out.println("Human player needs name and number");
            p = null;
        }
        else{
            p = new ComputerPlayer();
        }
        return p;
    }

    public Player returnPlayer(PlayerType type, String name, int num){
        Player p;
        if (type == PlayerType.HUMAN){
            p = new HumanPlayer(name, num);
        }
        else{
            p = new ComputerPlayer();
        }
        return p;
    }
}
