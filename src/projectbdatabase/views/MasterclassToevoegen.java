/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectBdatabase.views;

import ProjectBdatabase.databaseUtil.Connector;
import ProjectBdatabase.models.Locatie;
import ProjectBdatabase.models.Leraar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jelmer
 */
public class MasterclassToevoegen extends javax.swing.JFrame {

    private ArrayList<Locatie> locaties;
    private ArrayList<Leraar> leraren;
    private MasterClassFrame mcFrame;

    /**
     * Creates new form MasterclassToevoegen
     */
    public MasterclassToevoegen(MasterClassFrame frame) {
        initComponents();
        this.mcFrame = frame;
        vulComboboxLocaties();
        vulComboboxLeraar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void vulComboboxLocaties() {
        locaties = new ArrayList();
        DefaultComboBoxModel modelLocatie = new DefaultComboBoxModel();
        try {
            //Connectie ophalen met behulp van DataBaseConnector
            Connection conn = Connector.getConnection();

            //Statement object aanmaken met behulp van zojuist aangemaakte connectie
            Statement stat = conn.createStatement();

            //Klanten ophalen uit database
            ResultSet result = stat.executeQuery("SELECT * FROM locatie");

            //Resultset doorlopen.
            while (result.next()) {

                String naam = result.getString("naam");
                double huur = result.getDouble("huur");
                int aantaldeelnemers = result.getInt("max_aantal_deelnemers");
                String huisnummer = result.getString("huisnummer");
                String postcode = result.getString("postcode");
                String plaats = result.getString("plaats");

                Locatie locatie = new Locatie(naam, postcode, huisnummer, plaats, aantaldeelnemers, huur);
                locaties.add(locatie);
                modelLocatie.addElement(locatie.plaats() + " " + locatie.postcode());

            }
            this.cbLocatie.setModel(modelLocatie);

            //Afsluiten van resources.
            result.close();
            stat.close();

        } catch (SQLException exc) {
            System.err.println("Sql fout bij het ophalen van leraren: " + exc.toString());
        }

    }

    private void vulComboboxLeraar() {
        leraren = new ArrayList();
        DefaultComboBoxModel modelLeraar = new DefaultComboBoxModel();
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
                modelLeraar.addElement(leraar.naam());
            }
            this.cbLeraar.setModel(modelLeraar);

            //Afsluiten van resources.
            result.close();
            stat.close();

        } catch (SQLException exc) {
            System.err.println("Sql fout bij het ophalen van Leraren: " + exc.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cbLeraar = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tfMaxspelers = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfMinRating = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbLocatie = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbDag = new javax.swing.JComboBox();
        cbMaand = new javax.swing.JComboBox();
        cbJaar = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tfNaam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfPrijs = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfOmschrijving = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Masterclass Toevoegen");

        jLabel2.setText("Leraar:");

        cbLeraar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Max aantal spelers:");

        jLabel4.setText("Min rating:");

        jLabel5.setText("Locatie:");

        cbLocatie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel6.setText("Datum:");

        cbDag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMaand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbJaar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));

        jLabel7.setText("Naam:");

        tfNaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNaamActionPerformed(evt);
            }
        });

        jLabel8.setText("Prijs:");

        jLabel9.setText("Omschrijving:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(88, 88, 88)
                        .addComponent(cbLocatie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrijs)
                            .addComponent(tfMinRating, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfMaxspelers)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(cbMaand, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbJaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNaam)
                            .addComponent(cbLeraar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                    .addComponent(tfOmschrijving, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbLeraar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfMaxspelers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfMinRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfPrijs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbLocatie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbJaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(180, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tfOmschrijving, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(125, 125, 125)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int aantalValidFields = 0;
            String naam = this.tfNaam.getText();
            String maxspelers = this.tfMaxspelers.getText();
            String minRating = this.tfMinRating.getText();
            String prijs = this.tfPrijs.getText();
            String omschrijving = this.tfOmschrijving.getText();

            if (CheckInput.checkInput(naam) == 0) {
                tfNaam.setBackground(Color.RED);
            } else {
                tfNaam.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkNummer(maxspelers) == 0) {
                tfMaxspelers.setBackground(Color.RED);
            } else {
                tfMaxspelers.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkNummer(minRating) == 0) {
                tfMinRating.setBackground(Color.RED);
            } else {
                tfMinRating.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkDouble(prijs) == 0) {
                tfPrijs.setBackground(Color.RED);
            } else {
                tfPrijs.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (CheckInput.checkDouble(prijs) == 0) {
                tfPrijs.setBackground(Color.RED);
            } else {
                tfPrijs.setBackground(Color.WHITE);
                aantalValidFields = aantalValidFields + 1;
            }

            if (aantalValidFields == 5) {
                try {
                    Connection conn = Connector.getConnection();
                    Statement stat = conn.createStatement();

                    String prepStatInsertPokerEvent = "INSERT INTO poker_event ( naam,datum,huisnummer,postcode) "
                            + "VALUES (?,?,?,?)";
                    PreparedStatement prepStat = conn.prepareStatement(prepStatInsertPokerEvent);

                    int selected = this.cbLocatie.getSelectedIndex();
                    Locatie geselecteerd = locaties.get(selected);

                    prepStat.setString(1, naam);
                    prepStat.setString(2, this.cbJaar.getSelectedItem().toString() + "/" + this.cbMaand.getSelectedItem().toString() + "/" + this.cbDag.getSelectedItem().toString());
                    prepStat.setString(3, geselecteerd.huisnummer());
                    prepStat.setString(4, geselecteerd.postcode());

                    prepStat.executeUpdate();

                    int pe_code = SelectLatestRows();

                    String prepStatInsertMasterClass = "INSERT INTO masterclass ( pe_code,minimale_rating,max_aantal_spelers,omschrijving,prijs,leraar) "
                            + "VALUES (?,?,?,?,?,?)";
                    PreparedStatement prepStatMasterClass = conn.prepareStatement(prepStatInsertMasterClass);

                    int selectedLeraar = this.cbLeraar.getSelectedIndex();
                    Leraar geselecteerdleraar = leraren.get(selectedLeraar);

                    prepStatMasterClass.setInt(1, pe_code);
                    prepStatMasterClass.setInt(2, Integer.parseInt(minRating));
                    prepStatMasterClass.setInt(3, Integer.parseInt(maxspelers));
                    prepStatMasterClass.setString(4, omschrijving);
                    prepStatMasterClass.setDouble(5, Double.parseDouble(prijs));
                    prepStatMasterClass.setInt(6, geselecteerdleraar.s_code());

                    prepStatMasterClass.executeUpdate();
                    stat.close();

                    JOptionPane.showMessageDialog(this, "Masterclass opgeslagen in de database");
                    this.mcFrame.Vullijst();
                    this.dispose();
                } catch (SQLException exc) {
                    JOptionPane.showMessageDialog(this, "Masterclass niet opgeslagen in de database" + exc.toString());
                }
                this.dispose();
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private int SelectLatestRows() {
        try {
            //Connectie ophalen met behulp van DataBaseConnector
            Connection conn = Connector.getConnection();

            //Statement object aanmaken met behulp van zojuist aangemaakte connectie
            Statement stat = conn.createStatement();

            //Klanten ophalen uit database
            ResultSet result = stat.executeQuery("SELECT max(pe_code) as maxgetal FROM poker_event");

            //Resultset doorlopen.
            while (result.next()) {
                int nummer = result.getInt("maxgetal");
                return nummer;

            }

            //Afsluiten van resources.
            result.close();
            stat.close();

        } catch (SQLException exc) {
            System.err.println("Sql fout bij het ophalen van pecode: " + exc.toString());
        }

        return 0;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNaamActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDag;
    private javax.swing.JComboBox cbJaar;
    private javax.swing.JComboBox cbLeraar;
    private javax.swing.JComboBox cbLocatie;
    private javax.swing.JComboBox cbMaand;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tfMaxspelers;
    private javax.swing.JTextField tfMinRating;
    private javax.swing.JTextField tfNaam;
    private javax.swing.JTextField tfOmschrijving;
    private javax.swing.JTextField tfPrijs;
    // End of variables declaration//GEN-END:variables
}
