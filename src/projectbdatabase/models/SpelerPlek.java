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
public class SpelerPlek {

    private int ta_code;
    private int rondeNr;
    private int afvallerPlek;

    public SpelerPlek(int sTa_code, int sRondeNr) {
        this.ta_code = sTa_code;
        this.rondeNr = sRondeNr;

    }

    public int ta_code() {
        return this.ta_code;
    }

    public int rondeNr() {
        return this.rondeNr;
    }

    public int afvallerPlek() {
        return this.afvallerPlek;
    }

}
