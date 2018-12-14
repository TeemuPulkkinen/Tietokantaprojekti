/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author s1800591
 */
public class Tietokanta {
    
    private String esineUusiAseSQL = "insert into Esinelista(nimi,teho) values (?,?)";
    private String esineUusiPanssariSQL = "insert into Esinelista(nimi, puolustus) values (?,?)";
    private String esineHakuSQL = "select * from Esinelista order by ? DESC";
    
    public void lisaaEsine(Esinelista tavara) {
        Connection yhteys = null;
        /*
    Tehdään try-catch rakenne, joka testaa onko tietokantayhteydessä ongelmia
    try-kohta kertoo mitä yritetään tehdä. Catch kertoo mitä tehdään jos ei onnistu.
         */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/s1800591", "s1800591", "oxZBgd9j");
            // Javan puolella ei haittaa vaik insertit ois pienellä.

            PreparedStatement aseLisays = yhteys.prepareStatement(esineUusiAseSQL);
            // parameter index tarkoittaa mones kysymysmerkki on kyseessä. eka kysmerkki on 1
            aseLisays.setString(1, tavara.getNimi());
            autonLisays.setString(2, karry.getMalli());
            autonLisays.setInt(3, karry.getVuosi());
            autonLisays.setString(4, karry.getVari());

            autonLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }
}
