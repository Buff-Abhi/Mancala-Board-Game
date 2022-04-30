package com.example.springboottutorial;
//Factory Design Pattern
public class PlayerFactory {
    public PlayerFactory(){

    }
    public Player returnPlayer(PlayerType type){
        Player p=null;
        if (type == PlayerType.HUMAN){
            System.out.println("Human player needs name and number");
            p = null;
        }
        return p;
    }

    public Player returnPlayer(PlayerType type, String name, int num){
        Player p=null;
        if (type == PlayerType.HUMAN){
            p = new HumanPlayer(name, num);
        }
        return p;
    }
}
