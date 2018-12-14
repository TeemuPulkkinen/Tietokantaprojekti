/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author s1800591
 */
public class Tietokanta {

    private String esineUusiAseSQL = "insert into Esinelista(nimi,teho) values (?,?)";
    private String esineUusiPanssariSQL = "insert into Esinelista(nimi, puolustus) values (?,?)";
    private String esineHakuSQL = "select * from Esinelista order by ? DESC";

    public ArrayList Esinelista() {
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

            aseLisays.setString(1, ase.getNimi());
            aseLisays.setInt(2, ase.getTeho());

            aseLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
        return 
    }

    public void esinePanssari(Esinelista panssari) {
        Connection yhteys = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/s1800591", "s1800591", "oxZBgd9j");
            // Javan puolella ei haittaa vaik insertit ois pienellä.

            PreparedStatement panssariLisays = yhteys.prepareStatement(esineUusiPanssariSQL);

            panssariLisays.setString(1, panssari.getNimi());
            panssariLisays.setInt(2, panssari.getPuolustus());

            panssariLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }

    public void esineHaku(Esinelista haku) {
        Connection yhteys = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/s1800591", "s1800591", "oxZBgd9j");

            PreparedStatement haeEsine = yhteys.prepareStatement(esineHakuSQL);

            haeEsine.setString(1, haku.getNimi());
            

            haeEsine.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }
}
