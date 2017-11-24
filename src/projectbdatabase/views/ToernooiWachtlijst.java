/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.views;

import ProjectBdatabase.databaseUtil.Connector;
import ProjectBdatabase.models.Locatie;

import ProjectBdatabase.models.PokerEvent;
import ProjectBdatabase.models.Speler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class ToernooiWachtlijst extends javax.swing.JFrame {

    /**
     * Creates new form Spelerlijst
     */
    private ArrayList<PokerEvent> events;
    private ArrayList<Speler> spelers;
    private ArrayList<Speler> spelers2;

    public ToernooiWachtlijst() {
        initComponents();
        vulCombobox();
        vulWacht();
        vulIngeschreven();
    }

    private void vulCombobox() {
        events = new ArrayList();
        DefaultComboBoxModel modelEvents = new DefaultComboBoxModel();
        try {
            //Connectie ophalen met behulp van DataBaseConnector
            Connection conn = Connector.getConnection();

            //Statement object aanmaken met behulp van zojuist aangemaakte connectie
            Statement stat = conn.createStatement();

            //Klanten ophalen uit database
            ResultSet result = stat.executeQuery("SELECT * FROM poker_event p JOIN toernooi t ON p.pe_code = t.pe_code");

            //Resultset doorlopen.
            while (result.next()) {
                int eventID = result.getInt("pe_code");
                String naam = result.getString("naam");
                String datum = result.getString("datum");
                String postcode = result.getString("postcode");
                String huisnummer = result.getString("huisnummer");
                int aantal_deelnemers = result.getInt("aantal_deelnemers");

                PokerEvent pokerevents = new PokerEvent(eventID, naam, datum, postcode, huisnummer, aantal_deelnemers);
                events.add(pokerevents);
                modelEvents.addElement(pokerevents.pe_code() + " " + pokerevents.naam());

            }
            this.jComboBox1.setModel(modelEvents);

            //Afsluiten van resources.
            result.close();
            stat.close();

        } catch (SQLException exc) {
            System.err.println("Sql fout bij het ophalen van klanten: " + exc.toString());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void vulWacht() {
        int selected = this.jComboBox1.getSelectedIndex();
        PokerEvent geselecteerd = events.get(selected);
        String[] kolommen = {"ID:", "Naam:",};
        spelers2 = new ArrayList();
        DefaultTableModel spelerlijst = new DefaultTableModel(kolommen, 0);
        try {
            //Connectie ophalen met behulp van DataBaseConnector
            Connection conn = Connector.getConnection();

            //Statement object aanmaken met behulp van zojuist aangemaakte connectie
            Statement stat = conn.createStatement();

            //Klanten ophalen uit database
            //ResultSet result = stat.executeQuery("SELECT SP.naam, SP.s_code, I.betaald from speler SP join inschrijving I on I.s_code = I.s_code WHERE I.pe_code = 1");
            String prepString = "SELECT SP.naam, SP.s_code,SP.huisnummer,SP.postcode,SP.woonplaats,SP.telefoonnummer,SP.email,SP.rating,SP.totaalgewonnengeld, I.betaald from speler SP join inschrijving I on SP.s_code = I.s_code WHERE pe_code = ? && betaald != 1";
            //String prepString = "select * from speler S join speler_plek SP on S.s_code=SP.s_code where ta_code = ?";
            PreparedStatement prepStat = conn.prepareStatement(prepString);
            prepStat.setInt(1, geselecteerd.pe_code());
            ResultSet result = prepStat.executeQuery();

            //Resultset doorlopen.
            while (result.next()) {
                int nummer = result.getInt("s_code");
                String naam = result.getString("naam");
                String huisnummer = result.getString("huisnummer");
                String postcode = result.getString("postcode");
                String woonplaats = result.getString("woonplaats");
                String telefoonnummer = result.getString("telefoonnummer");
                String email = result.getString("email");
                int rating = result.getInt("rating");
                double totaalgewonnengeld = result.getDouble("totaalgewonnengeld");

                Speler speler = new Speler(nummer, naam, huisnummer, postcode, woonplaats, telefoonnummer, email, rating, totaalgewonnengeld);
                spelers2.add(speler);
                String[] spelerInfo = {String.valueOf(speler.s_code()), speler.naam(), String.valueOf(speler.huisnummer()), speler.postcode(), speler.woonplaats(), speler.telefoonnummer(), speler.email(), String.valueOf(speler.rating()), String.valueOf(speler.totaalgewonnengeld())};
                spelerlijst.addRow(spelerInfo);

            }
            tbWachtlijst.setModel(spelerlijst);

            //Afsluiten van resources.
            result.close();
            stat.close();

        } catch (SQLException exc) {
            System.err.println("Sql fout bij het ophalen van Speler: " + exc.toString());
        }
    }

    public void vulIngeschreven() {
        int selected = this.jComboBox1.getSelectedIndex();
        PokerEvent geselecteerd = events.get(selected);
        String[] kolommen = {"ID:", "Naam:",};
        spelers = new ArrayList();
        DefaultTableModel spelerlijst = new DefaultTableModel(kolommen, 0);
        try {
            //Connectie ophalen met behulp van DataBaseConnector
            Connection conn = Connector.getConnection();

            //Statement object aanmaken met behulp van zojuist aangemaakte connectie
            Statement stat = conn.createStatement();

            //Klanten ophalen uit database
            //ResultSet result = stat.executeQuery("SELECT SP.naam, SP.s_code, I.betaald from speler SP join inschrijving I on I.s_code = I.s_code WHERE I.pe_code = 1");
            String prepString = "SELECT SP.naam, SP.s_code,SP.huisnummer,SP.postcode,SP.woonplaats,SP.telefoonnummer,SP.email,SP.rating,SP.totaalgewonnengeld, I.betaald from speler SP join inschrijving I on SP.s_code = I.s_code WHERE pe_code = ? && betaald = 1";
            //String prepString = "select * from speler S join speler_plek SP on S.s_code=SP.s_code where ta_code = ?";
            PreparedStatement prepStat = conn.prepareStatement(prepString);
            prepStat.setInt(1, geselecteerd.pe_code());
            ResultSet result = prepStat.executeQuery();

            //Resultset doorlopen.
            while (result.next()) {
                int nummer = result.getInt("s_code");
                String naam = result.getString("naam");
                String huisnummer = result.getString("huisnummer");
                String postcode = result.getString("postcode");
                String woonplaats = result.getString("woonplaats");
                String telefoonnummer = result.getString("telefoonnummer");
                String email = result.getString("email");
                int rating = result.getInt("rating");
                double totaalgewonnengeld = result.getDouble("totaalgewonnengeld");

                Speler speler = new Speler(nummer, naam, huisnummer, postcode, woonplaats, telefoonnummer, email, rating, totaalgewonnengeld);
                spelers.add(speler);
                String[] spelerInfo = {String.valueOf(speler.s_code()), speler.naam(), String.valueOf(speler.huisnummer()), speler.postcode(), speler.woonplaats(), speler.telefoonnummer(), speler.email(), String.valueOf(speler.rating()), String.valueOf(speler.totaalgewonnengeld())};
                spelerlijst.addRow(spelerInfo);

            }
            jTable1.setModel(spelerlijst);

            //Afsluiten van resources.
            result.close();
            stat.close();

        } catch (SQLException exc) {
            System.err.println("Sql fout bij het ophalen van Speler: " + exc.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbWachtlijst = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wachtlijst");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "SpelerID", "Voornaam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Sluit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Deelnemende Spelers:");

        jLabel3.setText("Wachtlijst:");

        tbWachtlijst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "SpelerID", "Voornaam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbWachtlijst.setMinimumSize(new java.awt.Dimension(60, 320));
        jScrollPane2.setViewportView(tbWachtlijst);

        jButton2.setText("<-------");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        vulWacht();
        vulIngeschreven();

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int selected = this.tbWachtlijst.getSelectedRow();
            Speler geselecteerd = spelers2.get(selected);
            int selected1 = this.jComboBox1.getSelectedIndex();
            PokerEvent geselecteerd1 = events.get(selected1);

            int gekozenEvent = geselecteerd1.pe_code();
            int gekozenSpeler = geselecteerd.s_code();
            int max_aantal_deelnemers = 0;

            try {
                Connection conn = Connector.getConnection();
                Statement stat = conn.createStatement();
                String prepStatlocatie = "SELECT max_aantal_deelnemers FROM locatie WHERE postcode=? AND huisnummer=? ";
                PreparedStatement prepStatlo = conn.prepareStatement(prepStatlocatie);
                prepStatlo.setString(1, geselecteerd1.postcode());
                prepStatlo.setString(2, geselecteerd1.huisnummer());
                ResultSet result = prepStatlo.executeQuery();

                //Resultset doorlopen.
                while (result.next()) {
                    max_aantal_deelnemers = result.getInt("max_aantal_deelnemers");
                }

                if (geselecteerd1.aantal_deelnemers() <= max_aantal_deelnemers) {
                    String prepStatInsertKlant = "UPDATE inschrijving SET betaald=1  WHERE pe_code=? AND s_code=? ";

                    String prepStatUpdatePokerevent = "UPDATE poker_event SET aantal_deelnemers = aantal_deelnemers +1  WHERE pe_code =?";
                    PreparedStatement prepStat = conn.prepareStatement(prepStatInsertKlant);
                    PreparedStatement prepStatUpdate = conn.prepareStatement(prepStatUpdatePokerevent);
                    prepStat.setInt(1, gekozenEvent);
                    prepStat.setInt(2, gekozenSpeler);
                    prepStatUpdate.setInt(1, gekozenEvent);

                    prepStatUpdate.executeUpdate();
                    prepStat.executeUpdate();

                    stat.close();

                    JOptionPane.showMessageDialog(this, "Klant heeft betaald");
                } else {
                    JOptionPane.showMessageDialog(this, "Toernooi zit vol!");
                }

            } catch (SQLException exc) {
                JOptionPane.showMessageDialog(this, "Klant niet opgeslagen in de database" + exc.toString());
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbWachtlijst;
    // End of variables declaration//GEN-END:variables
}
