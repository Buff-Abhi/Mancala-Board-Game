package com.example.springboottutorial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String p1;
    private String p2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return p1;
    }

    public void setFirstName(String p1) {
        this.p1 = p1;
    }

    public String getLastName() {
        return p2;
    }

    public void setLastName(String p2) {
        this.p2 = p2;
    }
}