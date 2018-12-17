/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author s1800591
 */
public class Paaohjelma {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lukija = new Scanner(System.in);
        //tehdään kanta-niminen olio luokasta Tietokanta
        Tietokanta kanta = new Tietokanta();

        System.out.println("Tämä sovellus listaa erilaisia aseita.");
        System.out.println("Anna aseen tyyppi jonka haluat hakea: (Pyssy)");
        String nimi = lukija.nextLine();
        if (nimi.equals("Pyssy")) {

            //Esinelista pyssy = new Esinelista(nimi);
            System.out.println("Tässä tulostus pyssyistä");

            kanta.haePyssy();
            ArrayList<Esinelista> tulos = kanta.haePyssy();

            for (Esinelista pyssy : tulos) {
                System.out.println(pyssy);
            }
        } else {
            System.out.println("Anna aseen nimi:");
            //String nimi = lukija.nextLine();
            System.out.println("Anna aseen teho numeroina:");
            int teho = Integer.parseInt(lukija.nextLine());
            System.out.println("Anna aseen kesto numeroina:");
            int kesto = Integer.parseInt(lukija.nextLine());

            // luodaan Esine-olio johon lähetetään kolme parametria
            Esinelista ase = new Esinelista(nimi, teho, kesto);
            kanta.esineAse(ase);
            System.out.println("Tässä tulostus aseista:");

            ArrayList<Esinelista> tulos = kanta.haeEsine();

            //for each looppi
            for (Esinelista pyssy : tulos) {
                System.out.println(pyssy);
            }
        }
    }
}
