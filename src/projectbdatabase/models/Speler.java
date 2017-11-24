/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.models;

/**
 *
 * @author pimdewringer
 */
public class Speler {

    private int s_code;
    private String naam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;
    private String telefoonnummer;
    private String email;
    private int rating;
    private double totaalgewonnengeld;

    public Speler(int id, String sNaam, String sHuisnummer, String sPostcode, String sWoonplaats, String sTelefoonnummer, String sEmail, int sRating, double sTotaalgewonnengeld) {
        this.s_code = id;
        this.naam = sNaam;
        this.huisnummer = sHuisnummer;
        this.postcode = sPostcode;
        this.woonplaats = sWoonplaats;
        this.telefoonnummer = sTelefoonnummer;
        this.email = sEmail;
        this.rating = sRating;
        this.totaalgewonnengeld = sTotaalgewonnengeld;
    }

    public double totaalgewonnengeld() {
        return this.totaalgewonnengeld;
    }

    public String naam() {
        return this.naam;
    }

    public String email() {
        return this.email;
    }

    public String huisnummer() {
        return this.huisnummer;
    }

    public String postcode() {
        return this.postcode;
    }

    public String woonplaats() {
        return this.woonplaats;
    }

    public String telefoonnummer() {
        return this.telefoonnummer;
    }

    public int rating() {
        return this.rating;
    }

    public int s_code() {
        return this.s_code;
    }

    @Override

    public String toString() {
        return "" + this.s_code + " " + this.naam + " " + this.huisnummer + " " + this.postcode + " " + this.woonplaats + " " + this.telefoonnummer + " " + " " + this.email + this.rating;
    }

    public String[] getInfo() {
        return new String[]{this.s_code + "", this.naam, this.postcode, this.huisnummer + "", this.woonplaats, this.email, this.telefoonnummer, this.rating + ""};
    }

}
