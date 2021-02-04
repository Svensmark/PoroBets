/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dto;

import entities.Player;

/**
 *
 * @author Emil Svensmark
 */
public class PlayerDTO {

    private String first_name;
    private String last_name;
    private String ign;
    private String role;
    private String image_url;
    private int birthyear;
    private String birthday;
    private int api_id;
    private TeamDTO team;

    public PlayerDTO(String first_name, String last_name, String ign,
            String role, String image_url, int birthyear, String birthday, int api_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.ign = ign;
        this.role = role;
        this.image_url = image_url;
        this.birthyear = birthyear;
        this.birthday = birthday;
        this.api_id = api_id;
    }

    public PlayerDTO(Player player) {
        this.first_name = player.getFirst_name();
        this.last_name = player.getLast_name();
        this.ign = player.getIgn();
        this.role = player.getRole();
        this.image_url = player.getImage_url();
        this.birthyear = player.getBirthyear();
        this.birthday = player.getBirthday();
        this.api_id = player.getApi_id();
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
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public String toJson() {
        return "\n{ \n" + "\"first_name\": \"" + first_name + "\",\n \"last_name\": \"" + last_name + "\",\n \"ign\": \"" + ign + "\",\n \"role\": \"" + role + "\",\n \"image_url\": \"" + image_url + "\",\n \"birthyear\": \"" + birthyear + "\",\n \"birthday\": \"" + birthday + "\",\n \"api_id\": \"" + api_id + "\"\n}";
    }

}
