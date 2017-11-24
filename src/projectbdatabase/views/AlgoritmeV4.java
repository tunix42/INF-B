/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.views;

/**
 *
 * @author Martijn mogelikheden in een array zetten 3 arrays 1 voor
 * mogelijkheden 8*3 enz 1 voor aantaldeelnemers per ronde 1 voor keuze 8*3 de
 * rest nul met 1 getal moet los staan van i dus moet ook 1 van 8 kunnen als i =
 * 5
 */
public class AlgoritmeV4 {

    public static void main(String[] args) {
        String test = Test(36, 5);
        System.out.println(test);
        if (!test.equals("fout")) {
            System.out.println(test);
        }
    }

    public static String Test(int aantalDeelnemers, int i) {
        //Scanner input = new Scanner(System.in);
        //System.out.println("Geef aantal deelnemers: ");
        //int aantalDeelnemers = input.nextInt();
        if (aantalDeelnemers > 8 && aantalDeelnemers < 16) {
            System.err.println("ERROR: Aantal deelnemers mag niet tussen 8 en 16 liggen");
        }
        if (aantalDeelnemers < 0) {
            System.err.println("ERROR: Aantal deelnemers mag niet negatief zijn");
        }
        if (aantalDeelnemers < 4 && aantalDeelnemers > 0) {
            System.err.println("ERROR: Aantal deelnemers mag niet tussen 0 en 4 liggen");
        } else {
            String verdeling = "";
            String temp = "";
            int ronde = 0;
            int aantalDeelnemersErna = 0;
            int rest;
            int aantalTafelsVan = 2;
            int t11;
            int t10;
            int t9;
            int t7;
            int t6;
            int t5;
            int stopIniniteLoop = 0;
            //int i = 8;
            //int i = input.nextInt();    
            while ((aantalTafelsVan > 1 || aantalDeelnemersErna > 1 && i > 3)) {
                if (stopIniniteLoop > 100) {
                    break;
                }

                for (; i > 3; i--) {

                    if (ronde == 0) {
                        rest = aantalDeelnemers % i;
                        aantalTafelsVan = (aantalDeelnemers - rest) / i;
                        t11 = aantalDeelnemers - 11;
                        t10 = aantalDeelnemers - 10;
                        t9 = aantalDeelnemers - 9;
                        t7 = aantalDeelnemers - 7;
                        t6 = aantalDeelnemers - 6;
                        t5 = aantalDeelnemers - 5;
                    } else {
                        rest = aantalDeelnemersErna % i;
                        aantalTafelsVan = (aantalDeelnemersErna - rest) / i;
                        t11 = aantalDeelnemersErna - 11;
                        t10 = aantalDeelnemersErna - 10;
                        t9 = aantalDeelnemersErna - 9;
                        t7 = aantalDeelnemersErna - 7;
                        t6 = aantalDeelnemersErna - 6;
                        t5 = aantalDeelnemersErna - 5;
                    }
                    if (aantalDeelnemers > 3 && aantalDeelnemers < 9) {
                        System.out.println("tafels van " + aantalDeelnemers + ": 1");
                        System.out.println("---------------------------------");
                        ronde = ronde + 1;
                        temp = "/|" + ronde + "|" + aantalDeelnemers + "*1";
                        verdeling = verdeling + temp;
                        aantalDeelnemersErna = aantalTafelsVan;
                        break;
                    }
                    if (aantalDeelnemersErna > 3 && aantalDeelnemersErna < 9) {
                        System.out.println("tafels van " + aantalDeelnemersErna + ": 1");
                        System.out.println("---------------------------------");
                        ronde = ronde + 1;
                        temp = "/|" + ronde + "|" + aantalDeelnemersErna + "*1";
                        verdeling = verdeling + temp;
                        aantalDeelnemersErna = aantalTafelsVan;
                        break;
                    }

                    if (i == 8 && rest == 0) {
                        if (aantalTafelsVan < 9 && aantalTafelsVan > 3 || aantalTafelsVan > 15 || aantalTafelsVan == 1) {
                            System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                            System.out.println("---------------------------------");
                            ronde = ronde + 1;
                            temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan;
                            verdeling = verdeling + temp;
                            aantalDeelnemersErna = aantalTafelsVan;
                            break;
                        }
                    }

                    if (i == 7 && rest == 0) {
                        if (aantalTafelsVan < 9 && aantalTafelsVan > 3 || aantalTafelsVan > 15 || aantalTafelsVan == 1) {
                            System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                            System.out.println("---------------------------------");
                            ronde = ronde + 1;
                            temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan;
                            verdeling = verdeling + temp;
                            aantalDeelnemersErna = aantalTafelsVan;
                            break;
                        }
                    }
                    if (i == 6 && rest == 0) {
                        if (aantalTafelsVan < 9 && aantalTafelsVan > 3 || aantalTafelsVan > 15 || aantalTafelsVan == 1) {
                            System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                            System.out.println("---------------------------------");
                            ronde = ronde + 1;
                            temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan;
                            verdeling = verdeling + temp;
                            aantalDeelnemersErna = aantalTafelsVan;
                            break;
                        }
                    }
                    if (i == 5 && rest == 0) {
                        if (aantalTafelsVan < 9 && aantalTafelsVan > 3 || aantalTafelsVan > 15 || aantalTafelsVan == 1) {
                            System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                            System.out.println("---------------------------------");
                            ronde = ronde + 1;
                            temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan;
                            verdeling = verdeling + temp;
                            aantalDeelnemersErna = aantalTafelsVan;
                            break;
                        }
                    }

                    if (i == 4 && rest == 0) {
                        if (aantalTafelsVan < 9 && aantalTafelsVan > 3 || aantalTafelsVan > 15 || aantalTafelsVan == 1) {
                            System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                            System.out.println("---------------------------------");
                            ronde = ronde + 1;
                            temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan;
                            verdeling = verdeling + temp;
                            aantalDeelnemersErna = aantalTafelsVan;
                            break;
                        }
                    }

                    if (i == 8) {
                        int tafelsvan7 = 7 - rest;
                        aantalTafelsVan = aantalTafelsVan - tafelsvan7;
                        if ((((tafelsvan7 + 1) + aantalTafelsVan) < 9) && (((tafelsvan7 + 1) + aantalTafelsVan) > 3) || (((tafelsvan7 + 1) + aantalTafelsVan) > 15)) {
                            if (aantalTafelsVan > 0) {
                                System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                                System.out.println("tafels van 7" + ": " + (tafelsvan7 + 1));
                                System.out.println("Aantal tafels: " + ((tafelsvan7 + 1) + aantalTafelsVan));
                                System.out.println("Aantal spelers: " + ((i * aantalTafelsVan) + (7 * (tafelsvan7 + 1))));
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan + "|" + "7*" + (tafelsvan7 + 1);
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((tafelsvan7 + 1) + aantalTafelsVan);
                                break;
                            }
                        }
                    }

                    if (i == 7) {
                        int tafelsvan6 = 6 - rest;
                        aantalTafelsVan = aantalTafelsVan - tafelsvan6;
                        if ((((tafelsvan6 + 1) + aantalTafelsVan) < 9) && (((tafelsvan6 + 1) + aantalTafelsVan) > 3) || (((tafelsvan6 + 1) + aantalTafelsVan) > 15)) {
                            if (aantalTafelsVan > 0) {
                                System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                                System.out.println("tafels van 6" + ": " + (tafelsvan6 + 1));
                                System.out.println("Aantal tafels: " + ((tafelsvan6 + 1) + aantalTafelsVan));
                                System.out.println("Aantal spelers: " + ((i * aantalTafelsVan) + (6 * (tafelsvan6 + 1))));
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan + "|" + "6*" + (tafelsvan6 + 1);
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((tafelsvan6 + 1) + aantalTafelsVan);
                                break;
                            }
                        }
                    }
                    if (i == 6) {
                        int tafelsvan5 = 5 - rest;
                        aantalTafelsVan = aantalTafelsVan - tafelsvan5;
                        if ((((tafelsvan5 + 1) + aantalTafelsVan) < 9) && (((tafelsvan5 + 1) + aantalTafelsVan) > 3) || (((tafelsvan5 + 1) + aantalTafelsVan) > 15)) {
                            if (aantalTafelsVan > 0) {
                                System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                                System.out.println("tafels van 5" + ": " + (tafelsvan5 + 1));
                                System.out.println("Aantal tafels: " + ((tafelsvan5 + 1) + aantalTafelsVan));
                                System.out.println("Aantal spelers: " + ((i * aantalTafelsVan) + (5 * (tafelsvan5 + 1))));
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan + "|" + "5*" + (tafelsvan5 + 1);
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((tafelsvan5 + 1) + aantalTafelsVan);
                                break;
                            }
                        }
                    }
                    if (i == 5) {
                        int tafelsvan4 = 4 - rest;
                        aantalTafelsVan = aantalTafelsVan - tafelsvan4;
                        if ((((tafelsvan4 + 1) + aantalTafelsVan) < 9) && (((tafelsvan4 + 1) + aantalTafelsVan) > 3) || (((tafelsvan4 + 1) + aantalTafelsVan) > 15)) {
                            if (aantalTafelsVan > 0) {
                                System.out.println("tafels van " + i + ": " + aantalTafelsVan);
                                System.out.println("tafels van 4" + ": " + (tafelsvan4 + 1));
                                System.out.println("Aantal tafels: " + ((tafelsvan4 + 1) + aantalTafelsVan));
                                System.out.println("Aantal spelers: " + ((i * aantalTafelsVan) + (4 * (tafelsvan4 + 1))));
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + aantalTafelsVan + "|" + "4*" + (tafelsvan4 + 1);
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((tafelsvan4 + 1) + aantalTafelsVan);
                                break;
                            }
                        }
                    }
                    if (i == 4) {
                        if (aantalTafelsVan > 3 && aantalTafelsVan < 9 || aantalTafelsVan > 15) {
                            if ((t11 % i) == 0) {
                                System.out.println("tafels van " + i + ": " + (t11 / i));
                                System.out.println("tafels van 5: 1");
                                System.out.println("tafels van 6: 1");
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + (t11 / i) + "|5*1|6*1";
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((t11 / i) + 2);
                                break;
                            }
                        }
                        if ((t10 % i) == 0) {
                            if (aantalTafelsVan > 3 && aantalTafelsVan < 9 || aantalTafelsVan > 15) {
                                System.out.println("tafels van " + i + ": " + (t10 / i));
                                System.out.println("tafels van 5: 2");
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + (t10 / i) + "|5*2";
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((t10 / i) + 2);
                                break;
                            }
                        }
                        if ((t9 % i) == 0) {
                            if (aantalTafelsVan > 3 && aantalTafelsVan < 9 || aantalTafelsVan > 15) {
                                System.out.println("tafels van " + i + ": " + ((t9 / i) + 1));
                                System.out.println("tafels van 5: 1");
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + ((t9 / i) + 1) + "|5*1";
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((t9 / i) + 2);
                                break;
                            }
                        }
                        if ((t7 % i) == 0) {
                            if (aantalTafelsVan > 3 && aantalTafelsVan < 9 || aantalTafelsVan > 15) {
                                System.out.println("tafels van " + i + ": " + (t7 / i));
                                System.out.println("tafels van 7: 1");
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + (t11 / i) + "|7*1";
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((t7 / i) + 1);
                                break;
                            }
                        }
                        if ((t6 % i) == 0) {
                            if (aantalTafelsVan > 3 && aantalTafelsVan < 9 || aantalTafelsVan > 15) {
                                System.out.println("tafels van " + i + ": " + (t6 / i));
                                System.out.println("tafels van 6: 1");
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + (t6 / i) + "|6*1";
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((t6 / i) + 21);
                                break;
                            }
                        }
                        if ((t5 % i) == 0) {
                            if (aantalTafelsVan > 3 && aantalTafelsVan < 9 || aantalTafelsVan > 15) {
                                System.out.println("tafels van " + i + ": " + (t5 / i));
                                System.out.println("tafels van 5: 1");
                                System.out.println("---------------------------------");
                                ronde = ronde + 1;
                                temp = "/|" + ronde + "|" + i + "*" + (t5 / i) + "|5*1";
                                verdeling = verdeling + temp;
                                aantalDeelnemersErna = ((5 / i) + 1);
                                break;
                            }
                        }
                    }

                }
                stopIniniteLoop = stopIniniteLoop + 1;
            }
            if (ronde > 0 && ronde < 4 && aantalTafelsVan < 2) {
                System.out.println("Aantal rondes: " + ronde);
                //return ook begin grote of maak het met array volgorde
                return verdeling;

            } else {
                System.err.println("ERROR: komt niet goed uit.");
                verdeling = "fout";
                return verdeling;
            }
        }
        String verdeling = "fout";
        return verdeling;
    }

}
