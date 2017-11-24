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
public class Masterclass extends PokerEvent {

    private int minimaleRating;
    private int maxAantalSpelers;
    private String omschrijving;
    private double prijs;
    private int s_code;

    public Masterclass(int id, String Naam, String Datum, String tPostcode, String tHuisnummer, int Aantal_deelnemers, int mRating, int mSpelers, String mOmschrijving, double mPrijs, int s_code) {
        super(id, Naam, Datum, tPostcode, tHuisnummer, Aantal_deelnemers);
        this.minimaleRating = mRating;
        this.maxAantalSpelers = mSpelers;
        this.omschrijving = mOmschrijving;
        this.prijs = mPrijs;
        this.s_code = s_code;
    }

    public int minimaleRating() {
        return this.minimaleRating;
    }

    public int maxAantalSpelers() {
        return this.maxAantalSpelers;
    }

    public int s_code() {
        return this.s_code;
    }

    public String omschrijving() {
        return this.omschrijving;
    }

    public double prijs() {
        return this.prijs;
    }

}
