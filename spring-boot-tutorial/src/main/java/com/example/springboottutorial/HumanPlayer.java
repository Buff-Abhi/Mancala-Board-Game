package com.example.springboottutorial;

public class HumanPlayer implements Player{
    private String name;
    private int playerNum;

    public HumanPlayer(String n, int num){
        name = n;
        playerNum = num;
    }

    //plays move based off of integer given, should be in proper range for that player
    public Cup makeMove(Board board, int move){
        return board.playCup(move, playerNum);
    }

    public int getPlayerNum() {
        return playerNum;
    }
}

