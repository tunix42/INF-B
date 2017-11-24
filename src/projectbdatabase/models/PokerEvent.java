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
public class PokerEvent {

    private int pe_code;
    private String naam;
    private String postcode;
    private String huisnummer;
    private String datum;
    private int aantal_deelnemers;

    public PokerEvent(int id, String Naam, String Datum, String postcode, String huisnummer, int Aantal_deelnemers) {
        this.pe_code = id;
        this.naam = Naam;
        this.datum = Datum;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.aantal_deelnemers = Aantal_deelnemers;
    }

    public int aantal_deelnemers() {
        return this.aantal_deelnemers;
    }

    public int pe_code() {
        return this.pe_code;
    }

    public String naam() {
        return this.naam;
    }

    public String datum() {
        return this.datum;
    }

    public String postcode() {
        return this.postcode;

    }

    public String huisnummer() {
        return this.huisnummer;
    }

}
