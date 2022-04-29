package com.example.springboottutorial;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Document(collection = "Current Game")
public class Game {
    @Id
    private static int id;

//    private String cupId;


    private int pb1;
    private int pb2;
    private int pb3;
    private int pb4;
    private int pb5;
    private int pb6;
    private int m1;
    private String player1;
    private int pt1;
    private int pt2;
    private int pt3;
    private int pt4;
    private int pt5;
    private int pt6;
    private int m2;
    private String player2;
    private String playedBy;

    private int gameId;

    @Transient
    private Board board;
//    private Player[] players;


    public Game(){
        //get board instance and reset it
        board = Board.getInstance();
        board.resetBoard();
        updateDB();
//        //make factory to create players of correct type depending on whether game is single player or multiplayer
//        PlayerFactory factory = new PlayerFactory();
//        Player player1 = factory.returnPlayer(PlayerType.HUMAN, name1, 1);
//        Player player2 = factory.returnPlayer(PlayerType.HUMAN, name2, 2);
//        Player[] players = {player1, player2};
    }

//    public void playGame(){
//        boolean gameOver = false;
//        Cup lastCup;
//        int move;
//        int playerCupMax;
//        boolean turnContinues;
//        Player currentPlayer;
//        while (!gameOver){
//            for(int i = 0; i < players.length; i++){
//                turnContinues = true;
//                while(turnContinues){
//                    //check if the game is over
//                    if(board.oneSideEmpty()){
//                        gameOver = true;
//                        break;
//                    }
//                    //set current player and have them make move
//                    currentPlayer = players[i];
//                    //get move here
//                    move = 1;
//                    lastCup = currentPlayer.makeMove(board, move);
//                    turnContinues = false;
//                    //check if last cup was their mancala cup, if yes then they get to play again
//                    if(lastCup.getIsMancala() && lastCup.getLocation() == board.getNumCups()/2*currentPlayer.getPlayerNum()-1){
//                        turnContinues = true;
//                    }
//                    //check if last cup was empty, if so, empty both that cup and its opposite into the players mancala
//                    else if(lastCup.isEmpty() && lastCup.isOnPlayerSide(currentPlayer.getPlayerNum())){
//                        lastCup.addStones(board.getCup(lastCup.getOppositeLocation()).emptyCup());
//                    }
////                    gam.save(this);
//                }
//                updateDB();
//            }
//        }
//    }
//
    public void updateDB(){
        board = Board.getInstance();
        pb1 = board.getCup(0).getNumStones();
        pb2 = board.getCup(1).getNumStones();
        pb3 = board.getCup(2).getNumStones();
        pb4 = board.getCup(3).getNumStones();
        pb5 = board.getCup(4).getNumStones();
        pb6 = board.getCup(5).getNumStones();
        m1 = board.getCup(6).getNumStones();
        pt1 = board.getCup(7).getNumStones();
        pt2 = board.getCup(8).getNumStones();
        pt3 = board.getCup(9).getNumStones();
        pt4 = board.getCup(10).getNumStones();
        pt5 = board.getCup(11).getNumStones();
        pt6 = board.getCup(12).getNumStones();
        m2 = board.getCup(13).getNumStones();
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getM1() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getPt1() {
        return pt1;
    }

    public void setPt1(int pt1) {
        this.pt1 = pt1;
    }

    public int getPt2() {
        return pt2;
    }

    public void setPt2(int pt2) {
        this.pt2 = pt2;
    }

    public int getPt3() {
        return pt3;
    }

    public void setPt3(int pt3) {
        this.pt3 = pt3;
    }

    public int getPt4() {
        return pt4;
    }

    public void setPt4(int pt4) {
        this.pt4 = pt4;
    }

    public int getPt5() {
        return pt5;
    }

    public void setPt5(int pt5) {
        this.pt5 = pt5;
    }

    public int getPt6() {
        return pt6;
    }

    public void setPt6(int pt6) {
        this.pt6 = pt6;
    }

    public int getPb1() {
        return pb1;
    }

    public void setPb1(int pb1) {
        this.pb1 = pb1;
    }

    public int getPb2() {
        return pb2;
    }

    public void setPb2(int pb2) {
        this.pb2 = pb2;
    }

    public int getPb3() {
        return pb3;
    }

    public void setPb3(int pb3) {
        this.pb3 = pb3;
    }

    public int getPb4() {
        return pb4;
    }

    public void setPb4(int pb4) {
        this.pb4 = pb4;
    }

    public int getPb5() {
        return pb5;
    }

    public void setPb5(int pb5) {
        this.pb5 = pb5;
    }

    public int getPb6() {
        return pb6;
    }

    public void setPb6(int pb6) {
        this.pb6 = pb6;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(String playedBy) {
        this.playedBy = playedBy;
    }
}