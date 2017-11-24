/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.views;

import ProjectBdatabase.databaseUtil.Connector;
import ProjectBdatabase.models.Leraar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class LeraarOpties extends javax.swing.JFrame {

    private static Leraar leraarKeuze;
    private MasterClassFrame masterClassFrame;
    private ArrayList<Leraar> leraren;

    public LeraarOpties(MasterClassFrame masterClassFrame) {
        this.masterClassFrame = masterClassFrame;
        initComponents();
        Vullijst();
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
        tbLeraren = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leraar opties");

        tbLeraren.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "s_code", "naam", "rating", "salaris"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLeraren);

        jLabel1.setText("Leraren:");

        jButton1.setText("sluit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Leraar aanmaken");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Leraar aanpassen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Leraar Gegevens");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 474, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LeraarAanmaken leraarAanmaken = new LeraarAanmaken(this);
        leraarAanmaken.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int colIndex = tbLeraren.getSelectedRow();

            LeraarAanpassen leraarAanpassen = new LeraarAanpassen(this, leraren.get(colIndex));
            leraarAanpassen.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int leraarKeuzeIndex = tbLeraren.getSelectedRow();
            leraarKeuze = leraren.get(leraarKeuzeIndex);
            LeraarGegevens leraarGegevens = new LeraarGegevens(this);
            leraarGegevens.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static Leraar getLeraarKeuze() {
        return leraarKeuze;
    }

    public void Vullijst() {
        String[] kolommen = {"Speler ID:", "Naam:", "Rating:", "Salaris:"};
        leraren = new ArrayList();
        DefaultTableModel leraarlijst = new DefaultTableModel(kolommen, 0);
        try {
            //Connectie ophalen met behulp van DataBaseConnector
            Connection conn = Connector.getConnection();

            //Statement object aanmaken met behulp van zojuist aangemaakte connectie
            Statement stat = conn.createStatement();

            //Klanten ophalen uit database
            ResultSet result = stat.executeQuery("select S.s_code, naam, huisnummer, postcode, woonplaats, telefoonnummer, email, rating, totaalgewonnengeld, salaris from speler S join leraar L on S.s_code=L.s_code");
            //Resultset doorlopen.
            while (result.next()) {
                int spelerID = result.getInt("s_code");
                String naam = result.getString("naam");
                String huisnummer = result.getString("huisnummer");
                String postcode = result.getString("postcode");
                String woonplaats = result.getString("woonplaats");
                String telefoonnummer = result.getString("telefoonnummer");
                String email = result.getString("email");
                int rating = result.getInt("rating");
                int totaalgewonnengeld = result.getInt("totaalgewonnengeld");
                double salaris = result.getDouble("salaris");

                Leraar leraar = new Leraar(spelerID, naam, huisnummer, postcode, woonplaats, telefoonnummer, email, rating, totaalgewonnengeld, salaris);
                leraren.add(leraar);
                String[] leraarInfo = {String.valueOf(spelerID), naam, String.valueOf(rating), String.valueOf(salaris)};
                leraarlijst.addRow(leraarInfo);

            }
            tbLeraren.setModel(leraarlijst);

            //Afsluiten van resources.
            result.close();
            stat.close();

        } catch (SQLException exc) {
            System.err.println("Sql fout bij het ophalen van leraren: " + exc.toString());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLeraren;
    // End of variables declaration//GEN-END:variables
}
