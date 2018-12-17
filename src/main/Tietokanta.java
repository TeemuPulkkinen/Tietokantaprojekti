/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author s1800591
 */
public class Tietokanta {

    private String esineUusiAseSQL = "insert into Esinelista(nimi,teho,kesto) values (?,?,?)";
    private String esineHakuSQL = "select * from Esinelista order by ? DESC";
    private String esinePyssySQL = "select * from Esinelista where nimi = 'Pyssy'";

    public void esineAse(Esinelista pyssy) {
        Connection yhteys = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/s1800591", "s1800591", "oxZBgd9j");

            PreparedStatement aseLisays = yhteys.prepareStatement(esineUusiAseSQL);

            aseLisays.setString(1, pyssy.getNimi());
            aseLisays.setInt(2, pyssy.getTeho());
            aseLisays.setInt(3, pyssy.getKesto());

            aseLisays.executeUpdate();
        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }

    public ArrayList<Esinelista> haeEsine() {
        Connection yhteys = null;

        ArrayList<Esinelista> esineet = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/s1800591", "s1800591", "oxZBgd9j");

            PreparedStatement esineHaku = yhteys.prepareStatement(esineHakuSQL);
            esineHaku.setString(1, "nimi");
            // Koska SQL-haussa on tähti, tulokset tulevat ResultSettinä
            ResultSet hakutulos = esineHaku.executeQuery();

            while (hakutulos.next()) {
                Esinelista haettuEsine = new Esinelista(hakutulos.getInt(1), hakutulos.getString(2), hakutulos.getInt(3), hakutulos.getInt(4));
                esineet.add(haettuEsine);
                //System.out.println(hakutulos.getInt(1) + " " + hakutulos.getString(2) + " " + hakutulos.getString(3) + " " + hakutulos.getInt(4));
            }

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
        return esineet;
    }

    public ArrayList<Esinelista> haePyssy() {
        Connection yhteys = null;

        ArrayList<Esinelista> pyssyt = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/s1800591", "s1800591", "oxZBgd9j");

            PreparedStatement esineHakuPyssy = yhteys.prepareStatement(esinePyssySQL);
            //esineHakuPyssy.setString(1, "nimi");
            // Koska SQL-haussa on tähti, tulokset tulevat ResultSettinä
            ResultSet hakutulos = esineHakuPyssy.executeQuery();

            while (hakutulos.next()) {
                Esinelista haettuEsinePyssy = new Esinelista(hakutulos.getInt(1), hakutulos.getString(2), hakutulos.getInt(3), hakutulos.getInt(4));
                pyssyt.add(haettuEsinePyssy);
                //System.out.println(hakutulos.getInt(1) + " " + hakutulos.getString(2) + " " + hakutulos.getString(3) + " " + hakutulos.getInt(4));
            }

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
        return pyssyt;
    }
}
