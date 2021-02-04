/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.dto.TeamDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Emil Svensmark
 */
@Entity
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acronym;
    private String name;
    private String image_url;
    private int api_id;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team() {
    }

    public Team(String acronym, String name, String image_url, int api_id) {
        this.acronym = acronym;
        this.name = name;
        this.image_url = image_url;
        this.api_id = api_id;
        this.players = new ArrayList<>();
    }

    public Team(TeamDTO team) {
        this.acronym = team.getAcronym();
        this.name = team.getName();
        this.image_url = team.getImage_url();
        ArrayList<Player> playerList = new ArrayList();
        for (int i = 0; i > team.getPlayers().size(); ++i) {
            playerList.add(new Player(team.getPlayers().get(i)));
        }
        this.players = playerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getApi_id() {
        return api_id;
    }

    public void setApi_id(int api_id) {
        this.api_id = api_id;
    }


    
    
}
