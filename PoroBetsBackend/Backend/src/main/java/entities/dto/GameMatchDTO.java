/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dto;

import entities.GameMatch;
import entities.Team;

/**
 *
 * @author Emil Svensmark
 */
public class GameMatchDTO {

    private String name;
    private int number_of_games;
    private String scheduled_at;
    private int winner_api_id;
    private Team team1;
    private Team team2;
    private String tournament_name;

    public GameMatchDTO(String name, int number_of_games, String scheduled_at, int winner_api_id, Team team1, Team team2, String tournament_name) {
        this.name = name;
        this.number_of_games = number_of_games;
        this.scheduled_at = scheduled_at;
        this.winner_api_id = winner_api_id;
        this.team1 = team1;
        this.team2 = team2;
        this.tournament_name = tournament_name;
    }

    public GameMatchDTO(GameMatch gm) {
        this.name = gm.getName();
        this.number_of_games = gm.getNumber_of_games();
        this.scheduled_at = gm.getScheduled_at();
        this.winner_api_id = gm.getWinner_api_id();
        this.team1 = gm.getTeam1();
        this.team2 = gm.getTeam2();
        this.tournament_name = gm.getTournament_name();
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

    public String toJson() {
        return "{\n" + "\"name\": \"" + name + "\",\n\"number_of_games\": " + number_of_games + ",\n\"scheduled_at\": \"" + scheduled_at + "\",\n\"winner_api_id\": " + winner_api_id + ",\n \"team1\": " + new TeamDTO(team1).toJson() + ",\n \"team2\": " + new TeamDTO(team2).toJson() + ",\n\"tournament_name\": \"" + tournament_name + "\"}";
    }

}
