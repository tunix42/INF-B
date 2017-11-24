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
public class Leraar extends Speler {

    private int s_code;
    private String naam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;
    private String telefoonnummer;
    private String email;
    private int rating;
    private double totaalgewonnengeld;
    private double salaris;

    public Leraar(int id, String sNaam, String sHuisnummer, String sPostcode, String sWoonplaats, String sTelefoonnummer, String sEmail, int sRating, double sTotaalgewonnengeld, double salaris) {
        super(id, sNaam, sHuisnummer, sPostcode, sWoonplaats, sTelefoonnummer, sEmail, sRating, sTotaalgewonnengeld);
        this.s_code = id;

        this.naam = sNaam;
        this.huisnummer = sHuisnummer;
        this.postcode = sPostcode;
        this.woonplaats = sWoonplaats;
        this.telefoonnummer = sTelefoonnummer;
        this.email = sEmail;
        this.rating = sRating;
        this.salaris = salaris;
        this.totaalgewonnengeld = sTotaalgewonnengeld;
    }

    public double salaris() {
        return this.salaris;
    }
}
