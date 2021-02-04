/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.GameMatch;
import entities.Team;
import entities.dto.GameMatchDTO;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Emil Svensmark
 */
public class GameMatchFacade {

    private static EntityManagerFactory emf;
    private static GameMatchFacade instance;

    private GameMatchFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static GameMatchFacade getGameMatchFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GameMatchFacade();
        }
        return instance;
    }

    public GameMatch createNewMatch(GameMatchDTO dto) {
        EntityManager em = emf.createEntityManager();
        GameMatch match = new GameMatch(dto);
        try {
            em.getTransaction().begin();
            em.persist(match);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return match;
    }

    public void saveToDatabaseUpcomingMatches(int tournamentID, String type) throws Exception {
        HttpURLConnection con = null;
        EntityManager em = emf.createEntityManager();
        TeamFacade tf = TeamFacade.getTeamFacade(emf);
        try {
            em.getTransaction().begin();
            URL url = new URL("https://api.pandascore.co/matches/" + type + "?filter[tournament_id]=" + tournamentID + "&token=" + System.getenv("api.token"));
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.addRequestProperty("User-Agent", "Mozilla/4.76;Chrome");
            String jsonStr = "{ \"jsonArray\":";
            try ( Scanner scan = new Scanner(con.getInputStream())) {
                while (scan.hasNext()) {
                    jsonStr += scan.nextLine();
                }
            }
            jsonStr += "}";
            JsonObject json = new JsonParser().parse(jsonStr).getAsJsonObject();
            JsonArray jsonArray = json.getAsJsonArray("jsonArray");
            for (int i = 0; i < jsonArray.size(); ++i) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                //Name of match
                String name = jsonObject.get("name").getAsString();

                //Number of games
                int number_of_games = jsonObject.get("number_of_games").getAsInt();

                //Scheduled at
                //Formatting schedule
                String scheduled_at1 = jsonObject.get("scheduled_at").getAsString();
                String scheduled_at2 = scheduled_at1.replace('T', ' ');
                String scheduled_at3 = scheduled_at2.replace("Z", "");
                String[] scheduled_at_array = scheduled_at3.split(" ");
                String[] scheduled_at_array1 = scheduled_at_array[0].split("-");
                String[] scheduled_at_array2 = scheduled_at_array[1].split(":");
                int time = 1 + Integer.parseInt(scheduled_at_array2[0]);
                String scheduled_at = scheduled_at_array1[2] + "-" + scheduled_at_array1[1] + "-" + scheduled_at_array1[2] + " " + time + ":" + scheduled_at_array2[1];

                //Winner id
                //If no winner id = 0;
                int winner_id = 0;
                try {
                    winner_id = jsonObject.get("winner_id").getAsInt();
                } catch (UnsupportedOperationException e) {
                }

                //Math participants / opponents
                //Adding 2 team ids to math.
                JsonArray opponents = jsonObject.get("opponents").getAsJsonArray();
                ArrayList<Team> opponentslist = new ArrayList();
                for (int j = 0; j < opponents.size(); ++j) {
                    JsonObject jsonopponent = opponents.get(j).getAsJsonObject();
                    JsonObject op = jsonopponent.get("opponent").getAsJsonObject();
                    String acronym = op.get("acronym").getAsString();
                    opponentslist.add(tf.readTeamByAcronym(acronym));
                }

                //Tournament name
                JsonObject league = jsonObject.get("league").getAsJsonObject();
                String league_name = league.get("name").getAsString();
                JsonObject serie = jsonObject.get("serie").getAsJsonObject();
                String serie_full_name = serie.get("full_name").getAsString();
                String tournament_name = league_name + " " + serie_full_name;

                //Check if match already exists
                TypedQuery<GameMatch> query = em.createQuery("SELECT c FROM GameMatch c WHERE c.scheduled_at = :scheduled_at", GameMatch.class);
                try {
                    //Update if already exists
                    GameMatch gm = query.setParameter("scheduled_at", scheduled_at).getResultList().get(0);
                    gm.setName(name);
                    gm.setNumber_of_games(number_of_games);
                    gm.setScheduled_at(scheduled_at);
                    gm.setWinner_api_id(winner_id);
                    gm.setTeam1(tf.readTeamByAcronym(opponentslist.get(0).getAcronym()));
                    gm.setTeam2(tf.readTeamByAcronym(opponentslist.get(1).getAcronym()));
                    gm.setTournament_name(tournament_name);
                    em.merge(gm);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Persist if doesnt exist
                    Team t1 = tf.readTeamByAcronym(opponentslist.get(0).getAcronym());
                    Team t2 = tf.readTeamByAcronym(opponentslist.get(1).getAcronym());
                    em.persist(new GameMatch(name, number_of_games, scheduled_at, winner_id, t1, t2, tournament_name));
                }

            }
            em.getTransaction().commit();
            System.out.println("The database has been updated with the newest matches: " + new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
            em.close();
        }
    }

    public List<GameMatch> readPastMatches() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TypedQuery<GameMatch> query = em.createQuery("SELECT c FROM GameMatch c WHERE c.winner_api_id != :value", GameMatch.class);
            List<GameMatch> matches = query.setParameter("value", 0).getResultList();
            return query.setParameter("value", 0).getResultList();
        } finally {
            em.close();
        }
    }

    public List<GameMatch> readUpcomingMatches() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TypedQuery<GameMatch> query = em.createQuery("SELECT c FROM GameMatch c WHERE c.winner_api_id = :value", GameMatch.class);
            return query.setParameter("value", 0).getResultList();
        } finally {
            em.close();
        }
    }
}
