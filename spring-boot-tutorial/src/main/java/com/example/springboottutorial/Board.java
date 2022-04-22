package com.example.springboottutorial;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Current Game")
public class Board {

    @Id
    private static int id;

    private int gameId;
    private String player1;
    private String player2;
    private String playedBy;
    private int m1;
    private int m2;
    private int pt1;
    private int pt2;
    private int pt3;
    private int pt4;
    private int pt5;
    private int pt6;
    private int pb1;
    private int pb2;
    private int pb3;
    private int pb4;
    private int pb5;
    private int pb6;

    private static Board inst = null;

    public static Board getInstance() {
        if (inst == null) inst = new Board();
        id++;
        return inst;
    }

    private Board() {
        this.m1 = 0;
        this.m2 = 0;
        this.pt1 = 5;
        this.pt2 = 5;
        this.pt3 = 5;
        this.pt4 = 5;
        this.pt5 = 5;
        this.pt6 = 5;
        this.pb1 = 5;
        this.pb2 = 5;
        this.pb3 = 5;
        this.pb4 = 5;
        this.pb5 = 5;
        this.pb6 = 5;
        this.gameId = 1;
        this.player1 = this.player2 = this.playedBy = "Abhi";
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

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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