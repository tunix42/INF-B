/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.views;

import ProjectBdatabase.databaseUtil.Connector;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelmer
 */
public class LocatieToevoegen extends javax.swing.JFrame {

    /**
     * Creates new form LocatieToevoegen
     */
    private LocatieOpties locatieOpties;

    public LocatieToevoegen(LocatieOpties locatieOpties) {
        initComponents();
        this.locatieOpties = locatieOpties;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfNaam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfPostcode = new javax.swing.JTextField();
        tfHuisnummer = new javax.swing.JTextField();
        tfPlaats = new javax.swing.JTextField();
        tfMaxaantal = new javax.swing.JTextField();
        tfHuur = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Locatie toevoegen");

        jLabel2.setText("Locatienaam:");

        jLabel3.setText("Postcode:");

        jLabel4.setText("Huisnummer:");

        jLabel5.setText("Plaats:");

        jLabel6.setText("Max aantal deelnemers:");

        jLabel7.setText("Huur:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNaam)
                            .addComponent(tfPostcode)
                            .addComponent(tfHuisnummer)
                            .addComponent(tfPlaats)
                            .addComponent(tfMaxaantal)
                            .addComponent(tfHuur, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfHuisnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPlaats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfMaxaantal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfHuur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int aantalValidFields = 0;

            String naam = this.tfNaam.getText();
            String postcode = this.tfPostcode.getText();
            String plaats = this.tfPlaats.getText();
            String huisnummer = this.tfHuisnummer.getText();
            String maxaantal = this.tfMaxaantal.getText();
            String huur = this.tfHuur.getText();

            if (CheckInput.checkInput(naam) == 0) {
                tfNaam.setBackground(Color.RED);
            } else {
                tfNaam.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkPostcode(postcode) == 0) {
                tfPostcode.setBackground(Color.RED);
            } else {
                tfPostcode.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkLetters(plaats) == 0) {
                tfPlaats.setBackground(Color.RED);
            } else {
                tfPlaats.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkHuisnummer(huisnummer) == 0) {
                tfHuisnummer.setBackground(Color.RED);
            } else {
                tfHuisnummer.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkNummer(maxaantal) == 0) {
                tfMaxaantal.setBackground(Color.RED);
            } else {
                tfMaxaantal.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkDouble(huur) == 0) {
                tfHuur.setBackground(Color.RED);
            } else {
                tfHuur.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }
            if (aantalValidFields == 6) {
                try {
                    Connection conn = Connector.getConnection();
                    //Statement stat = conn.createStatement();

                    String prepStatInsertKlant = "INSERT INTO locatie (naam, huur,max_aantal_deelnemers,huisnummer,postcode,plaats) "
                            + "VALUES (?,?,?,?,?,?)";
                    PreparedStatement prepStat = conn.prepareStatement(prepStatInsertKlant);

                    prepStat.setString(1, naam);
                    prepStat.setDouble(2, Double.parseDouble(huur));
                    prepStat.setInt(3, Integer.parseInt(maxaantal));
                    prepStat.setString(4, huisnummer);
                    prepStat.setString(5, postcode);
                    prepStat.setString(6, plaats);

                    prepStat.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Locatie opgeslagen in de database");
                    this.locatieOpties.Vullijst();
                    this.dispose();
                } catch (SQLException exc) {
                    JOptionPane.showMessageDialog(this, "locatie niet opgeslagen in de database" + exc.toString());
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tfHuisnummer;
    private javax.swing.JTextField tfHuur;
    private javax.swing.JTextField tfMaxaantal;
    private javax.swing.JTextField tfNaam;
    private javax.swing.JTextField tfPlaats;
    private javax.swing.JTextField tfPostcode;
    // End of variables declaration//GEN-END:variables
}
