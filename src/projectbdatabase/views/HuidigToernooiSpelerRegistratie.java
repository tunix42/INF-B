/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.views;

import ProjectBdatabase.databaseUtil.Connector;
import ProjectBdatabase.models.Speler;
import ProjectBdatabase.models.SpelerPlek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author Ruben
 */
public class HuidigToernooiSpelerRegistratie extends javax.swing.JFrame {

    private static Speler spelerKeuze;
    private ArrayList<Speler> tafelSpelers;
    private ArrayList<Speler> tafelSpelersOver;
    private ArrayList<Double> perc;
    private ArrayList<Integer> winst;
    private int taCode;
    private String toernooiKeuzeNaam;

    public HuidigToernooiSpelerRegistratie(HuidigToernooi huidigToernooi, String toernooiKeuzeNaam) {
        initComponents();
        this.toernooiKeuzeNaam = toernooiKeuzeNaam;
        tabelVullen();
    }

    public void tabelVullen() {
        //Tafel Code 
        SpelerPlek tafelKeuze = HuidigToernooi.getTafelKeuze();
        taCode = tafelKeuze.ta_code();
        lbTaCode.setText(String.valueOf(taCode));

        //Table vullen
        String[] kolommen = {"Speler ID:", "Naam:", "Rating:", "Afvallerplek:"};
        DefaultTableModel spelerGegevens = new DefaultTableModel(kolommen, 0);
        tafelSpelers = new ArrayList();

        try {
            Connection conn = Connector.getConnection();
            String prepString = "select * from speler S join speler_plek SP on S.s_code=SP.s_code join poker_event PE on PE.pe_code = SP.pe_code where ta_code = ? and PE.naam = ?";
            PreparedStatement prepStat = conn.prepareStatement(prepString);
            prepStat.setInt(1, taCode);
            prepStat.setString(2, toernooiKeuzeNaam);
            ResultSet result = prepStat.executeQuery();

            while (result.next()) {
                int sCode = result.getInt("s_code");
                String naam = result.getString("naam");
                String huisnummer = result.getString("huisnummer");
                String postcode = result.getString("postcode");
                String woonplaats = result.getString("woonplaats");
                String telefoonnummer = result.getString("telefoonnummer");
                String email = result.getString("email");
                double totaalGewonnenGeld = result.getDouble("totaalgewonnengeld");
                int rating = result.getInt("rating");
                String afvallerplek = result.getString("afvallerplek");

                Speler spelerInfo = new Speler(sCode, naam, huisnummer, postcode, woonplaats, telefoonnummer, email, rating, totaalGewonnenGeld);
                tafelSpelers.add(spelerInfo);
                String[] spelerGegevensOutput = {String.valueOf(sCode), naam, String.valueOf(rating), afvallerplek};
                spelerGegevens.addRow(spelerGegevensOutput);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQL fout bij het ophalen van speler en speler_plek: " + e.toString());
        }
        tbSpelers.setModel(spelerGegevens);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSpelers = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btSpelerGegevens = new javax.swing.JButton();
        btRegistreerAfvaller = new javax.swing.JButton();
        lbTafel = new javax.swing.JLabel();
        lbTaCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Speler lijst");

        tbSpelers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Speler ID:", "Naam:", "Rating:", "Afvaller plek:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSpelers);

        jButton1.setText("Sluit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btSpelerGegevens.setText("Speler gegevens");
        btSpelerGegevens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSpelerGegevensActionPerformed(evt);
            }
        });

        btRegistreerAfvaller.setText("Registreer afvaller");
        btRegistreerAfvaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistreerAfvallerActionPerformed(evt);
            }
        });

        lbTafel.setText("Tafel: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btSpelerGegevens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRegistreerAfvaller)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTafel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTaCode)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTafel)
                    .addComponent(lbTaCode))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSpelerGegevens)
                    .addComponent(jButton1)
                    .addComponent(btRegistreerAfvaller))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btSpelerGegevensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSpelerGegevensActionPerformed
        try {
            int spelerKeuzeIndex = tbSpelers.getSelectedRow();
            spelerKeuze = tafelSpelers.get(spelerKeuzeIndex);
            HuidigToernooiSpelerGegevens huidigToernooiSpelerGegevens = new HuidigToernooiSpelerGegevens(tafelSpelers.get(spelerKeuzeIndex));
            huidigToernooiSpelerGegevens.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_btSpelerGegevensActionPerformed

    private void btRegistreerAfvallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistreerAfvallerActionPerformed
        try {
            int afvallerplek = 0;
            Integer check = 0;

            //peCode opvragen
            int peCode = HuidigToernooi.getPeCode();

            //sCode ophalen uit de database
            int spelerKeuzeIndex = tbSpelers.getSelectedRow();
            spelerKeuze = tafelSpelers.get(spelerKeuzeIndex);
            int sCode = spelerKeuze.s_code();

            //CHECKEN of de speler al is geregistreerd als afvaller
            try {
                Connection conn = Connector.getConnection();
                String prepStringCheck = "select afvallerplek from speler_plek where s_code = ?";
                PreparedStatement prepCheck = conn.prepareStatement(prepStringCheck);
                prepCheck.setInt(1, sCode);
                ResultSet resultCheck = prepCheck.executeQuery();

                while (resultCheck.next()) {
                    check = resultCheck.getInt("afvallerplek");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "SQL fout bij het checken of de speler al is afgevallen: " + e.toString());
            }

            if (check == 0) {
                //AFVALLERPLEK BEPALEN
                try {
                    Connection conn = Connector.getConnection();
                    String prepStringAfvallerplekBepalen = "select count(*) as aantal from speler_plek where afvallerplek is null and pe_code = ?";
                    PreparedStatement prepAfvallerplekBepalen = conn.prepareStatement(prepStringAfvallerplekBepalen);
                    prepAfvallerplekBepalen.setInt(1, peCode);
                    ResultSet resultAfvallerplekBepalen = prepAfvallerplekBepalen.executeQuery();

                    while (resultAfvallerplekBepalen.next()) {
                        afvallerplek = resultAfvallerplekBepalen.getInt("aantal");
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "SQL fout bij het bepalen van afvallerplek in speler_plek: " + e.toString());
                }

                //AFVALLERPLEK REGISTREREN
                try {
                    Connection conn = Connector.getConnection();
                    String prepStringAfvallerplekRegistreren = "update speler_plek set afvallerplek = ? where s_code = ?";
                    PreparedStatement prepAfvallerplekRegistreren = conn.prepareStatement(prepStringAfvallerplekRegistreren);
                    prepAfvallerplekRegistreren.setInt(1, afvallerplek);
                    prepAfvallerplekRegistreren.setInt(2, sCode);
                    prepAfvallerplekRegistreren.executeUpdate();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "SQL fout bij het registreren van afvallerplek in speler_plek: " + e.toString());
                }

                //RATING AANPASSEN
                int aantalOverigeSpelers = 0;
                tafelSpelersOver = new ArrayList();
                Speler verliezer = null;

                //Verliezer in tafelSpelersOver toevoegen
                try {
                    Connection conn = Connector.getConnection();
                    String prepString = "Select * from speler where s_code = ?";
                    PreparedStatement prepVerliezer = conn.prepareStatement(prepString);
                    prepVerliezer.setInt(1, sCode);
                    ResultSet resultVerliezer = prepVerliezer.executeQuery();

                    while (resultVerliezer.next()) {
                        aantalOverigeSpelers++;
                        int s_Code = resultVerliezer.getInt("s_code");
                        String naam = resultVerliezer.getString("naam");
                        String huisnummer = resultVerliezer.getString("huisnummer");
                        String postcode = resultVerliezer.getString("postcode");
                        String woonplaats = resultVerliezer.getString("woonplaats");
                        String telefoonnummer = resultVerliezer.getString("telefoonnummer");
                        String email = resultVerliezer.getString("email");
                        int rating = resultVerliezer.getInt("rating");
                        double totaalGewonnenGeld = resultVerliezer.getDouble("totaalgewonnengeld");

                        verliezer = new Speler(s_Code, naam, huisnummer, postcode, woonplaats, telefoonnummer, email, rating, totaalGewonnenGeld);
                        tafelSpelersOver.add(verliezer);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "SQL fout bij het bepalen van de verliezer: " + e.toString());
                }

                //Overige spelers bepalen
                try {
                    Connection conn = Connector.getConnection();
                    String prepString = "Select * from speler S join speler_plek SP on S.s_code=SP.s_code where SP.pe_code = ? and SP.ta_code = ? and SP.afvallerplek is null";
                    PreparedStatement prepAantalOverigeSpelers = conn.prepareStatement(prepString);
                    prepAantalOverigeSpelers.setInt(1, HuidigToernooi.getPeCode());
                    prepAantalOverigeSpelers.setInt(2, taCode);
                    ResultSet resultAantalOverigeSpelers = prepAantalOverigeSpelers.executeQuery();

                    while (resultAantalOverigeSpelers.next()) {
                        aantalOverigeSpelers++;
                        int s_Code = resultAantalOverigeSpelers.getInt("s_code");
                        String naam = resultAantalOverigeSpelers.getString("naam");
                        String huisnummer = resultAantalOverigeSpelers.getString("huisnummer");
                        String postcode = resultAantalOverigeSpelers.getString("postcode");
                        String woonplaats = resultAantalOverigeSpelers.getString("woonplaats");
                        String telefoonnummer = resultAantalOverigeSpelers.getString("telefoonnummer");
                        String email = resultAantalOverigeSpelers.getString("email");
                        int rating = resultAantalOverigeSpelers.getInt("rating");
                        double totaalGewonnenGeld = resultAantalOverigeSpelers.getDouble("totaalgewonnengeld");

                        Speler speler = new Speler(s_Code, naam, huisnummer, postcode, woonplaats, telefoonnummer, email, rating, totaalGewonnenGeld);
                        tafelSpelersOver.add(speler);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "SQL fout bij het aanpassen van de rating: " + e.toString());
                }

                if (tafelSpelersOver.size() != 1) {
                    //Huidige punten bepalen
                    int totaleRating = 0;
                    for (int i = 0; i < tafelSpelersOver.size(); i++) {
                        totaleRating += tafelSpelers.get(i).rating();
                    }

                    //Huidige punten verliezer bepalen
                    spelerKeuze = tafelSpelers.get(spelerKeuzeIndex);
                    int puntenVerliezer = spelerKeuze.rating();

                    //Percs bepalen
                    perc = new ArrayList();
                    double percTotaal = 0;
                    for (int i = 1; i < tafelSpelersOver.size(); i++) {
                        int rating = tafelSpelersOver.get(i).rating();
                        double berekening = (double) puntenVerliezer / rating * 1.0;
                        perc.add(berekening);
                        percTotaal += berekening;
                    }

                    //Formule toepassen
                    double aantalVerlorenPuntenFormule = round(2, (puntenVerliezer * 1.0 / ((totaleRating - puntenVerliezer) / (aantalOverigeSpelers - 1))) * 200);
                    int aantalVerlorenPunten = (int) aantalVerlorenPuntenFormule;
                    if (aantalVerlorenPunten > puntenVerliezer) {
                        aantalVerlorenPunten = puntenVerliezer;
                    }

                    //Winst verdelen
                    winst = new ArrayList();
                    int winstTotaal = 0;
                    for (int i = 1; i < tafelSpelersOver.size(); i++) {
                        double percSpeler = perc.get(i - 1);
                        int berekening = (int) round(2, ((percSpeler / percTotaal) * aantalVerlorenPunten));
                        winst.add(berekening);
                        winstTotaal += berekening;
                    }
                    if (aantalVerlorenPunten != winstTotaal) {
                        int fixAantalVerlorenPunten = winstTotaal - aantalVerlorenPunten;
                        aantalVerlorenPunten = aantalVerlorenPunten + fixAantalVerlorenPunten;
                    }

                    //Rating aanpassen in database
                    try {
                        Connection conn = Connector.getConnection();
                        String prepString = "update speler set rating = ? where s_code = ?";
                        PreparedStatement prepStat = conn.prepareStatement(prepString);
                        prepStat.setInt(1, verliezer.rating() - aantalVerlorenPunten);
                        prepStat.setInt(2, sCode);
                        prepStat.executeUpdate();
                        for (int i = 1; i < tafelSpelersOver.size(); i++) {
                            int rating = tafelSpelersOver.get(i).rating() + winst.get(i - 1);
                            int S_Code = tafelSpelersOver.get(i).s_code();
                            prepStat.setInt(1, rating);
                            prepStat.setInt(2, S_Code);
                            prepStat.executeUpdate();
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "SQL fout bij het aanpassen van de rating: " + e.toString());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Speler is al geregisteerd als afvaller");
            }

            tabelVullen();
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_btRegistreerAfvallerActionPerformed

    public static Speler getSpelerKeuze() {
        return spelerKeuze;
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistreerAfvaller;
    private javax.swing.JButton btSpelerGegevens;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTaCode;
    private javax.swing.JLabel lbTafel;
    private javax.swing.JTable tbSpelers;
    // End of variables declaration//GEN-END:variables
}