/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Player;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Emil Svensmark
 */
public class SetupLECPlayers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();

        ArrayList<Player> players = new ArrayList();
        //Astralis
        players.add(new Player("Erlend", "Våtevik Holm", "nukeduck", "mid", "https://cdn.pandascore.co/images/player/image/92/220px_og_nukeduck_2020_split_2.png", 1996, "1996-05-21", 92));
        players.add(new Player("Hampus Mikael", "Abrahamsson", "Promisq", "sup", "https://cdn.pandascore.co/images/player/image/99/220px_mouz_promisq_2020_split_1.png", 1994, "1994-03-04", 99));
        players.add(new Player("Nikolay", "Akatov", "Zanzarah", "jun", "https://cdn.pandascore.co/images/player/image/1391/rgo_zanzarah_2020_split_1.png", 1996, "1996-08-27", 1391));
        players.add(new Player("Matti", "Sormunen", "WhiteKnight", "top", "https://cdn.pandascore.co/images/player/image/1570/220px_big_white_knight_2020_split_1.png", 1996, "1996-02-16", 1570));
        players.add(new Player("Jesper", "Klarin Strömberg", "Jeskla", "adc", "https://cdn.pandascore.co/images/player/image/19574/220px_mouz_jeskla_2020_split_1.png", 2000, "2000-07-08", 19574));

        //MAD Lions
        players.add(new Player("İrfan", "Berk Tükek", "Armut", "top", "https://cdn.pandascore.co/images/player/image/3546/sup_armut_2020_split_2.png", 1998, "1998-12-13", 3546));
        players.add(new Player("Matyáš", "Orság", "Carzzy", "adc", "https://cdn.pandascore.co/images/player/image/14972/220px_mad_carzzy_2020_split_2.png", 2002, "2002-01-31", 14972));
        players.add(new Player("Marek", "Brázda", "Humanoid", "mid", "https://cdn.pandascore.co/images/player/image/17222/220px_mad_humanoid_2020_split_2.png", 2000, "2000-03-14", 17222));
        players.add(new Player("Norman", "Kaiser", "Kaiser", "sup", "https://cdn.pandascore.co/images/player/image/18037/220px_mad_kaiser_2020_split_2.png", 1998, "1998-11-19", 18037));
        players.add(new Player("Javier", "Prades", "Elyoya", "jun", "https://cdn.pandascore.co/images/player/image/24428/220px_mrds_elyoya_2020_split_1.png", 2000, "2000-01-01", 24428));

        //Rogue
        players.add(new Player("Steven", "Liv", "Hans sama", "adc", "https://cdn.pandascore.co/images/player/image/871/220px_rge_hans_sama_2020_split_2.png", 1999, "1999-09-02", 871));
        players.add(new Player("Emil", "Larsson", "Larssen", "mid", "https://cdn.pandascore.co/images/player/image/1429/220px_rge_larssen_2020_split_2.png", 2000, "2000-03-30", 1429));
        players.add(new Player("Andrei", "Pascu", "Odoamne", "top", "https://cdn.pandascore.co/images/player/image/2159/s04_odoamne_2020_split_2.png", 1995, "1995-01-18", 2159));
        players.add(new Player("Kacper", "Sloma", "Inspired", "jun", "https://cdn.pandascore.co/images/player/image/18036/220px_rge_inspired_2020_split_2.png", 2002, "2002-01-24", 18036));
        players.add(new Player("Adrian", "Trybus", "Trymbi", "sup", "https://cdn.pandascore.co/images/player/image/22950/220px_skp_trymbi_2020_split_1.png", 2000, "2000-10-20", 22950));

        //Excel Esports
        players.add(new Player("Daniel", "Hockley", "Dan", "jun", "https://cdn.pandascore.co/images/player/image/248/dan.png", 1996, "1996-09-11", 248));
        players.add(new Player("Patrik", "Jiru", "Patrik", "adc", "https://cdn.pandascore.co/images/player/image/377/220px_xl_patrik_2020_split_1.png", 2000, "2000-04-07", 377));
        players.add(new Player("Tore", "Hoel Eilertsen", "Tore", "sup", "https://cdn.pandascore.co/images/player/image/1166/220px_xl_tore_2020_split_1.png", 1999, "1999-12-27", 1166));
        players.add(new Player("Paweł", "Szczepanik", "Czekolad", "mid", "https://cdn.pandascore.co/images/player/image/20297/rgo_czekolad_2020_split_1.png", 2000, "2000-02-15", 20297));
        players.add(new Player("Felix", "Hellström", "Kryze", "top", "https://cdn.pandascore.co/images/player/image/23604/220px_use_kryze_2020_split_1.png", 1999, "1999-07-01", 23604));

        //SK Gaming
        players.add(new Player("Janik", "Bartels", "Jenax", "top", "https://cdn.pandascore.co/images/player/image/1372/220px_sk_jenax_2020_split_1.png", 1998, "1998-12-10", 1372));
        players.add(new Player("Kristian", "Ostergard", "TynX", "jun", "https://cdn.pandascore.co/images/player/image/1529/220px_ldlc_tynx_2020_split_1.png", 1999, "1999-10-22", 1529));
        players.add(new Player("Erik", "Wessén", "Treatz", "sup", "https://cdn.pandascore.co/images/player/image/1532/220px_tsm_treatz_2020_split_1.png", 1996, "1996-04-30", 1532));
        players.add(new Player("Ersin", "Gören", "Blue", "mid", "https://cdn.pandascore.co/images/player/image/23012/220px_fb_blue_2020_split_1.png", 2001, "2001-03-07", 23012));
        players.add(new Player("Jean", "Massol", "Jezu", "adc", "https://cdn.pandascore.co/images/player/image/25747/220px_msf.p_jezu_2020_split_1.png", 2000, "2000-07-27", 25747));

        //Fnatic
        players.add(new Player("Zdravets", "Galabov", "Hylissang", "sup", "https://cdn.pandascore.co/images/player/image/74/220px_fnc_hylissang_2020_split_1.png", 1995, "1995-04-30", 74));
        players.add(new Player("Elias", "Lipp", "Upset", "adc", "https://cdn.pandascore.co/images/player/image/1168/220px_og_upset_2020_split_2.png", 1999, "1999-12-16", 1168));
        players.add(new Player("Yasin", "Dinçer", "Nisqy", "mid", "https://cdn.pandascore.co/images/player/image/1284/220px_c9_nisqy_2020_split_2.png", 1998, "1998-07-28", 1284));
        players.add(new Player("Gabriël", "Belgium", "Bwipo", "top", "https://cdn.pandascore.co/images/player/image/1343/220px_fnc_bwipo_2020_split_2.png", 1998, "1998-12-24", 1343));
        players.add(new Player("Oskar", "Boderek", "Selfmade", "jun", "https://cdn.pandascore.co/images/player/image/14985/220px_fnc_selfmade_2020_split_2.png", 1999, "1999-12-15", 14985));

        //FC Schalke 04 Esports
        players.add(new Player("Erberk", "Demir", "Gilius", "jun", "https://cdn.pandascore.co/images/player/image/141/220px_s04_gilius_2020_split_1.png", 1997, "1997-01-05", 141));
        players.add(new Player("Felix", "Braun", "Abbedagge", "mid", "https://cdn.pandascore.co/images/player/image/1381/220px_s04_abbedagge_2020_split_1.png", 1999, "1999-10-09", 1381));
        players.add(new Player("Sergen", "Çelik", "Broken Blade", "top", "https://cdn.pandascore.co/images/player/image/1718/220px_tsm_broken_blade_2020_split_1.png", 2000, "2000-01-19", 1718));
        players.add(new Player("Matus", "Jakubcik", "Neon", "adc", "https://cdn.pandascore.co/images/player/image/3515/220px_s04_e_neon_2020_split_1.png", 1999, "1999-04-24", 3515));
        players.add(new Player("Dino", "Tot", "LIMIT", "sup", "https://cdn.pandascore.co/images/player/image/18059/sk_limit_2020_split_2.png", 1997, "1997-12-27", 18059));

        //Team Vitality
        players.add(new Player("Aljoša", "Kovandžić", "Milica", "mid", "https://cdn.pandascore.co/images/player/image/239/220px_vit_milica_2020_split_2.png", 2000, "2000-01-01", 239));
        players.add(new Player("Duncan", "Marquet", "Skeanz", "jun", "https://cdn.pandascore.co/images/player/image/1293/220px_vit_skeanz_2020_split_1.png", 2000, "2000-09-25", 1293));
        players.add(new Player("Labros", "Papoutsakis", "Labrov", "sup", "https://cdn.pandascore.co/images/player/image/14980/220px_vit_labrov_2020_split_2.png", 2002, "2002-02-12", 14980));
        players.add(new Player("Mathias", "Jensen", "Szygenda", "top", "https://cdn.pandascore.co/images/player/image/20300/rgo_szygenda_2020_split_1.png", 2001, "2001-04-14", 20300));
        players.add(new Player("Markos", "Stamkopoulos", "Comp", "adc", "https://cdn.pandascore.co/images/player/image/21577/220px_vit_comp_2020_split_2.png", 2001, "2001-12-20", 21577));

        //G2 Esports
        players.add(new Player("Kristoffer", "Albao Lund Pedersen", "P1noy", "adc", "https://cdn.pandascore.co/images/player/image/482/g2_p1noy_2020_split_2.png", 1996, "1996-05-16", 482));
        players.add(new Player("Mihael", "Mehle", "Mikyx", "sup", "https://cdn.pandascore.co/images/player/image/605/220px_g2_mikyx_2020_split_2.png", 1998, "1998-11-02", 605));
        players.add(new Player("Rasmus", "Winther", "Caps", "mid", "https://cdn.pandascore.co/images/player/image/1132/220px_g2_caps_2020_split_2.png", 1999, "1999-11-17", 1132));
        players.add(new Player("Martin", "Hansen", "Wunder", "top", "https://cdn.pandascore.co/images/player/image/1172/220px_g2_wunder_2020_split_2.png", 1998, "1998-11-09", 1172));
        players.add(new Player("Martin", "Larsson", "Rekkles", "adc", "https://cdn.pandascore.co/images/player/image/2146/fnc_rekkles_2020_split_2.png", 1996, "1996-09-20", 2146));
        players.add(new Player("Marcin", "Jankowski", "Jankos", "jun", "https://cdn.pandascore.co/images/player/image/2147/220px_g2_jankos_2020_split_2.png", 1995, "1995-07-23", 2147));

        //Misfits Gaming        
        players.add(new Player("Kasper", "Kobberup", "Kobbe", "adc", "https://cdn.pandascore.co/images/player/image/304/220px_msf_kobbe_2020_split_2.png", 1996, "1996-09-21", 304));
        players.add(new Player("Oskar", "Bogdan", "Vander", "sup", "https://cdn.pandascore.co/images/player/image/2161/rge_vander_2020_wc.png", 1994, "1994-04-18", 2161));
        players.add(new Player("Iván", "Martín Díaz", "Razork", "jun", "https://cdn.pandascore.co/images/player/image/3503/220px_msf_razork_2020_split_2.png", 2000, "2000-10-07", 3503));
        players.add(new Player("Petr", "Haramach", "Denyk", "sup", "https://cdn.pandascore.co/images/player/image/18039/220px_msf_denyk_2020_split_1.png", 1995, "1995-04-30", 18039));
        players.add(new Player("Tobiasz", "Ciba", "Agresivoo", "top", "https://cdn.pandascore.co/images/player/image/18043/msf.p_agresivoo_2020_split_2.png", 1999, "1999-07-09", 18043));
        players.add(new Player("Shin", "Tae-min", "HiRit", "top", "https://cdn.pandascore.co/images/player/image/21576/220px_fb_hi_rit_2020_split_1.png", 2000, "2000-01-01", 21576));
        players.add(new Player("Vincent", "Berrié", "Vétheo", "mid", "https://cdn.pandascore.co/images/player/image/25741/220px_ldlc_vetheo_2020_split_1.png", 2002, "2002-06-26", 25741));

        em.getTransaction().begin();
        for (int i = 0; i < players.size(); ++i) {
            em.persist(players.get(i));
        }
        em.getTransaction().commit();

    }

}
