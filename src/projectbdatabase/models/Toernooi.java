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
public class Toernooi extends PokerEvent {

    private double inleggeld;
    private double totaalinleggeld;
    private int eerstePlek;
    private int tweedePlek;
    private int derdePlek;

    public Toernooi(int id, String Naam, String Datum, String tPostcode, String tHuisnummer, int Aantal_deelnemers, double tInleggeld, double tTotaalinleggeld, int tEerstePlek, int tTweedePlek, int tDerdePlek) {
        super(id, Naam, Datum, tPostcode, tHuisnummer, Aantal_deelnemers);
        this.inleggeld = tInleggeld;
        this.totaalinleggeld = tTotaalinleggeld;
        this.eerstePlek = tEerstePlek;
        this.tweedePlek = tTweedePlek;
        this.derdePlek = tDerdePlek;
    }

    public double inleggeld() {
        return this.inleggeld;
    }

    public double totaalinleggeld() {
        return this.totaalinleggeld;
    }

    public int eerstePlek() {
        return this.eerstePlek;
    }

    public int tweedePlek() {
        return this.tweedePlek;
    }

    public int derdePlek() {
        return this.derdePlek;
    }
}
