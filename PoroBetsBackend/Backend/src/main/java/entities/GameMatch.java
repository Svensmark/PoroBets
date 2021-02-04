/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.dto.GameMatchDTO;
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
public class GameMatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int number_of_games;
    private String scheduled_at;
    private int winner_api_id;
    private Team team1;
    private Team team2;
    private String tournament_name;

    public GameMatch() {
    }

    public GameMatch(String name, int number_of_games, String scheduled_at, int winner_api_id, Team team1, Team team2, String tournament_name) {
        this.name = name;
        this.number_of_games = number_of_games;
        this.scheduled_at = scheduled_at;
        this.winner_api_id = winner_api_id;
        this.team1 = team1;
        this.team2 = team2;
        this.tournament_name = tournament_name;
    }

    public GameMatch(GameMatchDTO match) {
        this.name = match.getName();
        this.number_of_games = match.getNumber_of_games();
        this.scheduled_at = match.getScheduled_at();
        this.winner_api_id = match.getWinner_api_id();
        this.team1 = match.getTeam1();
        this.team2 = match.getTeam2();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_games() {
        return number_of_games;
    }

    public void setNumber_of_games(int number_of_games) {
        this.number_of_games = number_of_games;
    }

    public String getScheduled_at() {
        return scheduled_at;
    }

    public void setScheduled_at(String scheduled_at) {
        this.scheduled_at = scheduled_at;
    }

    public int getWinner_api_id() {
        return winner_api_id;
    }

    public void setWinner_api_id(int winner_api_id) {
        this.winner_api_id = winner_api_id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    @Override
    public String toString() {
        return "GameMatch{" + "id=" + id + ", name=" + name + ", number_of_games=" + number_of_games + ", scheduled_at=" + scheduled_at + ", winner_api_id=" + winner_api_id + ", team1=" + team1.toString() + ", team2=" + team2.toString() + ", tournament_name=" + tournament_name + '}';
    }
    
    

}

