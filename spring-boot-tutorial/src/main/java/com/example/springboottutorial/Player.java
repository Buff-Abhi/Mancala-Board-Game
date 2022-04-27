package com.example.springboottutorial;

enum PlayerType{HUMAN, COMPUTER};

public interface Player {
    Cup makeMove(Board board, int move);
    public int getPlayerNum();
}