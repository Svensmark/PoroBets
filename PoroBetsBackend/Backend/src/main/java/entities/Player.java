/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.dto.PlayerDTO;
import entities.dto.TeamDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Emil Svensmark
 */
@Entity
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;
    private String ign;
    private String player_role;
    private String image_url;
    private int birthyear;
    private String birthday;
    private int api_id;
   
    @ManyToOne
    private Team team;
    
    
            
    public Player() {
    }

    public Player(String first_name, String last_name, String ign, String role, String image_url, int birthyear, String birthday, int api_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.ign = ign;
        this.player_role = role;
        this.image_url = image_url;
        this.birthyear = birthyear;
        this.birthday = birthday;
        this.api_id = api_id;
    }

    public Player(PlayerDTO player) {
        this.first_name = player.getFirst_name();
        this.last_name = player.getLast_name();
        this.ign = player.getIgn();
        this.player_role = player.getRole();
        this.image_url = player.getImage_url();
        this.birthyear = player.getBirthyear();
        this.birthday = player.getBirthday();
        this.api_id = player.getApi_id();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public String getRole() {
        return player_role;
    }

    public void setRole(String role) {
        this.player_role = role;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getApi_id() {
        return api_id;
    }

    public void setApi_id(int api_id) {
        this.api_id = api_id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", ign=" + ign + ", player_role=" + player_role + ", image_url=" + image_url + ", birthyear=" + birthyear + ", birthday=" + birthday + ", api_id=" + api_id + ", team=" + team + '}';
    }

    
}
