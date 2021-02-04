/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dto;

import entities.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emil Svensmark
 */
public class TeamDTO {

    private String acronym;
    private String name;
    private String image_url;
    private List<PlayerDTO> players;
    private int api_id;

    public TeamDTO(String acronym, String name, String image_url, List<PlayerDTO> players, int api_id) {
        this.acronym = acronym;
        this.name = name;
        this.image_url = image_url;
        this.players = players;
        this.api_id = api_id;
    }

    public TeamDTO(String acronym, String name, String image_url, int api_id) {
        this.acronym = acronym;
        this.name = name;
        this.image_url = image_url;
        this.players = new ArrayList();
        this.api_id = api_id;
    }

    public TeamDTO(Team team) {
        this.acronym = team.getAcronym();
        this.name = team.getName();
        ArrayList<PlayerDTO> playerDTOList = new ArrayList();
        for (int i = 0; i < team.getPlayers().size(); ++i) {
            playerDTOList.add(new PlayerDTO(team.getPlayers().get(i)));
        }
        this.players = playerDTOList;
        this.image_url = team.getImage_url();
        this.api_id = team.getApi_id();
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

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
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

    public String toJson() {
        String playersJson = "";
        for (int i = 0; i < this.players.size(); ++i) {
            PlayerDTO playerDTO = this.players.get(i);
            playersJson += playerDTO.toJson();
            if (i != this.players.size()-1) {
                playersJson += ",";
            }
        }
        return "{\n" + "\"acronym\": \"" + acronym + "\",\n\"name\": \"" + name + "\",\n\"image_url\": \"" + image_url + "\",\n\"api_id\": " + api_id + ",\n\"players\": [\n" + playersJson + "\n]\n}";
    }

}
