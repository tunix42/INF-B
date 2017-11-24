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
public class Locatie {

    private String naam;
    private String postcode;
    private String huisnummer;
    private String plaats;
    private int maxAantalDeelnemers;
    private double huur;

    public Locatie(String lNaam, String lPostcode, String lHuisnummer, String lPlaats, int lMaxAantalDeelnemers, double lHuur) {
        this.naam = lNaam;
        this.huur = lHuur;
        this.maxAantalDeelnemers = lMaxAantalDeelnemers;
        this.huisnummer = lHuisnummer;
        this.postcode = lPostcode;
        this.plaats = lPlaats;
    }

    public String naam() {
        return this.naam;
    }

    public double huur() {
        return this.huur;
    }

    public int maxAantalDeelnemers() {
        return this.maxAantalDeelnemers;
    }

    public String huisnummer() {
        return this.huisnummer;
    }

    public String postcode() {
        return this.postcode;
    }

    public String plaats() {
        return this.plaats;
    }
}
