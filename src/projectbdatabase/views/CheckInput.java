/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.views;

/**
 *
 * @author Martijn
 */
public class CheckInput {

    public static int checkLetters(String tekst) {
        String regx = "^[\\p{L} .'-]+$";

        if (tekst.matches(regx) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }

    }

    public static int checkInput(String tekst) {
        if (tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }

    }

    public static int checkHuisnummer(String tekst) {
        String regx = "([0-9]){1,}([a-z]){0,3}";

        if (tekst.matches(regx) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkDouble(String tekst) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regx = regexDecimal + "|" + regexInteger;
        String regx2 = "[0-9]+";
        if (tekst.matches(regx) == true | tekst.matches(regx2) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkNummer(String tekst) {
        String regx = "[0-9]+";

        if (tekst.matches(regx) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkPostcode(String tekst) {
        String regx = "\\d{4}+[a-zA-Z]{2}";

        if (tekst.matches(regx) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkTelefoonnummer(String tekst) {
        String regx = "([0]{1}[6]{1}[-\\s]*[1-9]{1}[\\s]*([0-9]{1}[\\s]*){7})|([0]{1}[1-9]{1}[0-9]{1}[0-9]{1}[-\\s]*[1-9]{1}[\\s]*([0-9]{1}[\\s]*){5})|([0]{1}[1-9]{1}[0-9]{1}[-\\s]*[1-9]{1}[\\s]*([0-9]{1}[\\s]*){6})";

        if (tekst.matches(regx) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkEmail(String tekst) {
        String regx = "^((?:(?:(?:[a-zA-Z0-9][\\.\\-\\+_]?)*)[a-zA-Z0-9])+)\\@((?:(?:(?:[a-zA-Z0-9][\\.\\-_]?){0,62})[a-zA-Z0-9])+)\\.([a-zA-Z0-9]{2,6})$";

        if (tekst.matches(regx) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkDatum(String tekst) {
        String regx = "^^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";

        if (tekst.matches(regx) == true && tekst.equals("") == false) {
            return 1;
        } else {
            return 0;
        }
    }

}
