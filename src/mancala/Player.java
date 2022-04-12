package mancala;

enum PlayerType{HUMAN, COMPUTER};

public interface Player {
    void makeMove(Board board);
}
