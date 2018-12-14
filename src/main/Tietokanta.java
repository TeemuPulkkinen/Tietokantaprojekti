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
public class Tietokanta {
    
    private String esineUusiAseSQL = "insert into Esinelista(nimi,teho) values (?,?)";
    private String esineUusiPanssariSQL = "insert into Esinelista(nimi, puolustus) values (?,?)";
    private String esineHakuSQL = "select * from Esinelista order by ? DESC";
    
}
