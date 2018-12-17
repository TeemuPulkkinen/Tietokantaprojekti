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
    private int kesto;

    public Esinelista(int esineID, String nimi, int teho, int kesto) {
        this.esineID = esineID;
        this.nimi = nimi;
        this.teho = teho;
        this.kesto = kesto;

    }

    public Esinelista(String nimi, int teho, int kesto) {
        this.nimi = nimi;
        this.teho = teho;
        this.kesto = kesto;
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

    public int getKesto() {
        return kesto;
    }

    public void setKesto(int kesto) {
        this.kesto = kesto;
    }

    @Override
    public String toString() {
        return "Esine{" + "esineID=" + esineID + ", nimi=" + nimi + ", teho=" + teho + ", kesto=" + kesto + '}';
    }

}
