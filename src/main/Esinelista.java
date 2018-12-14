/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author s1800591
 */
public class Esinelista {

    private int esineID = 0;
    private String nimi;
    private int teho;
    private int puolustus;

    public Esinelista(int esineID, String nimi, int teho) {
        this.esineID = esineID;
        this.nimi = nimi;
        this.teho = teho;

    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getTeho() {
        return teho;
    }

    public void setTeho(int teho) {
        this.teho = teho;
    }

    public int getPuolustus() {
        return puolustus;
    }

    public void setPuolustus(int puolustus) {
        this.puolustus = puolustus;
    }
    

    @Override
    public String toString() {
        return "Esinelista{" + "esineID=" + esineID + ", nimi=" + nimi + ", teho=" + teho + ", puolustus=" + puolustus + '}';
    }
    
    
}
