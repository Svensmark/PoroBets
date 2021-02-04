/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.dto.BetDTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Emil Svensmark
 */
@Entity
public class Bet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long gamematch;
    private String username;
    private int amount;
    private int winner_api_id;
    private boolean active;

    public Bet() {
    }

    public Bet(Long gamematch, String username, int amount, int winner_api_id, boolean active) {
        this.gamematch = gamematch;
        this.username = username;
        this.amount = amount;
        this.winner_api_id = winner_api_id;
        this.active = active;
    }

    public Bet(BetDTO bet) {
        this.gamematch = bet.getGamematch();
        this.username = bet.getUsername();
        this.amount = bet.getAmount();
        this.winner_api_id = bet.getWinner_api_id();
        this.active = bet.isActive();
    }

    public Long getGamematch() {
        return gamematch;
    }

    public void setGamematch(Long gamematch) {
        this.gamematch = gamematch;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWinner_api_id() {
        return winner_api_id;
    }

    public void setWinner_api_id(int winner_api_id) {
        this.winner_api_id = winner_api_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
