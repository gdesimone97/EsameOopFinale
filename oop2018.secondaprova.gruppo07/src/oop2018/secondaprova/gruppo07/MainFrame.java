package oop2018.secondaprova.gruppo07;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author desio
 */
public class MainFrame extends javax.swing.JFrame {

    private ElencoPromemoria ep;
    private DefaultListModel dm = new DefaultListModel();
    private boolean flag = false;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        ep = new ElencoPromemoria();

        initComponents();

    }

    private void initInserisciFrame() {
        inserisciFrame.setLocationRelativeTo(this);
        inserisciFrame.setSize(inserisciFrame.getPreferredSize());
        campoDescrizione.setVisible(false);
        campoOrario.setVisible(false);
        descrizioneText.setText("");
        giornoSpinner.setValue(LocalDate.now().getDayOfMonth());
        meseSpinner.setValue(LocalDate.now().getMonthValue());
        annoSpinner.setValue(LocalDate.now().getYear());
        orarioText.setText(LocalTime.now().toString());
    }

    private void aggiornaModello() {
        dm.clear();
        ep.forEach(p -> dm.addElement(p));
        lista.setModel(dm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inserisciFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        giornoSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        meseSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        annoSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        orarioText = new javax.swing.JFormattedTextField();
        campoOrario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        descrizioneText = new javax.swing.JTextField();
        campoDescrizione = new javax.swing.JLabel();
        confermaButton = new javax.swing.JButton();
        annullaButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        inserisciButton = new javax.swing.JButton();
        cancellaButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        inserisciFrame.setPreferredSize(new java.awt.Dimension(400, 340));
        inserisciFrame.setResizable(false);
        inserisciFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                inserisciFrameWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserimento"));
        jPanel2.setPreferredSize(new java.awt.Dimension(390, 340));

        jLabel1.setText("Giorno:");

        giornoSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabel2.setText("Mese:");

        meseSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabel3.setText("Anno:");

        annoSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel5.setText("Orario:");

        try {
            orarioText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        campoOrario.setForeground(new java.awt.Color(255, 0, 0));
        campoOrario.setText("*Data/ora non valida");

        jLabel7.setText("Descrizione:");

        campoDescrizione.setForeground(new java.awt.Color(255, 0, 0));
        campoDescrizione.setText("*Campo obbligatorio");
        campoDescrizione.setToolTipText("");

        confermaButton.setText("Conferma");
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        annullaButton.setText("Annulla");
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(descrizioneText)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(giornoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(meseSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(annoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoOrario)
                            .addComponent(jLabel7)
                            .addComponent(campoDescrizione)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(confermaButton)
                        .addGap(18, 18, 18)
                        .addComponent(annullaButton)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(meseSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(annoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(orarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoOrario)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descrizioneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDescrizione)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaButton)
                    .addComponent(annullaButton))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inserisciFrameLayout = new javax.swing.GroupLayout(inserisciFrame.getContentPane());
        inserisciFrame.getContentPane().setLayout(inserisciFrameLayout);
        inserisciFrameLayout.setHorizontalGroup(
            inserisciFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        inserisciFrameLayout.setVerticalGroup(
            inserisciFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lista);

        inserisciButton.setText("Inserisci");
        inserisciButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserisciButtonActionPerformed(evt);
            }
        });

        cancellaButton.setText("Cancella");
        cancellaButton.setEnabled(false);
        cancellaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellaButtonActionPerformed(evt);
            }
        });

        modificaButton.setText("Modifica");
        modificaButton.setEnabled(false);
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inserisciButton)
                    .addComponent(cancellaButton)
                    .addComponent(modificaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inserisciButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancellaButton)
                        .addGap(18, 18, 18)
                        .addComponent(modificaButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        resultArea.setEditable(false);
        resultArea.setColumns(20);
        resultArea.setRows(5);
        jScrollPane1.setViewportView(resultArea);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inserisciFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_inserisciFrameWindowClosing
        setEnabled(true);
    }//GEN-LAST:event_inserisciFrameWindowClosing

    private void inserisciButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserisciButtonActionPerformed
        setEnabled(false);
        initInserisciFrame();
        flag = false;
        inserisciFrame.setVisible(true);
    }//GEN-LAST:event_inserisciButtonActionPerformed

    private void annullaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButtonActionPerformed
        inserisciFrame.setVisible(false);
        this.setVisible(true);
        this.setEnabled(true);
    }//GEN-LAST:event_annullaButtonActionPerformed

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        campoDescrizione.setVisible(false);
        campoOrario.setVisible(false);
        int giorno, mese, anno, ora, minuti;
        Scanner sc = new Scanner(orarioText.getText());
        sc.useDelimiter(":");
        ora = sc.nextInt();
        minuti = sc.nextInt();
        String descrizione = descrizioneText.getText();
        giorno = (int) giornoSpinner.getValue();
        mese = (int) meseSpinner.getValue();
        anno = (int) annoSpinner.getValue();

        try {
            if (flag) {
                ep.rimuoviPromemoria((Promemoria) dm.getElementAt(lista.getSelectedIndex()));
            }
            ep.inserisciPromemoria(descrizione, giorno, mese, anno, ora, minuti);
            
            
            if (flag) {
                resultArea.append("Promemoria modificato correttamente" + '\n');
            } else {
                resultArea.append("Promemoria aggiunto correttamente" + '\n');
            }
            inserisciFrame.setVisible(false);
            this.setEnabled(true);
            this.setVisible(true);
            modificaButton.setEnabled(false);
            cancellaButton.setEnabled(false);
            aggiornaModello();
        } catch (DataNonValidaException ex) {
            campoOrario.setVisible(true);
            if (descrizioneText.getText().equals("")) {
                campoDescrizione.setVisible(true);
            }
        } catch (DescrizioneNonValidaException ex) {
            campoDescrizione.setVisible(true);
        } catch (PromemoriaPresenteException ex) {
            JOptionPane.showMessageDialog(this, "Già è presente un promemoria con questa data/orario");
        } catch (PromemoriaNonEsistenteException ex) {
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        if (!ep.isEmpty()) {
            cancellaButton.setEnabled(true);
            modificaButton.setEnabled(true);
        }
    }//GEN-LAST:event_listaMouseClicked


    private void cancellaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellaButtonActionPerformed
        try {
            ep.rimuoviPromemoria((Promemoria) dm.getElementAt(lista.getSelectedIndex()));
            aggiornaModello();
            resultArea.append("Promemoria rimosso correttamente" + '\n');
            cancellaButton.setEnabled(false);
            modificaButton.setEnabled(false);
        } catch (PromemoriaNonEsistenteException ex) {
        }
    }//GEN-LAST:event_cancellaButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
        campoDescrizione.setVisible(false);
        campoOrario.setVisible(false);
        inserisciFrame.setVisible(true);
        this.setEnabled(false);
        Promemoria p = (Promemoria) dm.getElementAt(lista.getSelectedIndex());
        giornoSpinner.setValue(p.getData().getDayOfMonth());
        meseSpinner.setValue(p.getData().getMonthValue());
        annoSpinner.setValue(p.getData().getYear());
        orarioText.setText(String.format("%d:%d", p.getData().getHour(), p.getData().getMinute()));
        descrizioneText.setText(p.getDescrizione());
        flag = true;
    }//GEN-LAST:event_modificaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner annoSpinner;
    private javax.swing.JButton annullaButton;
    private javax.swing.JLabel campoDescrizione;
    private javax.swing.JLabel campoOrario;
    private javax.swing.JButton cancellaButton;
    private javax.swing.JButton confermaButton;
    private javax.swing.JTextField descrizioneText;
    private javax.swing.JSpinner giornoSpinner;
    private javax.swing.JButton inserisciButton;
    private javax.swing.JFrame inserisciFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lista;
    private javax.swing.JSpinner meseSpinner;
    private javax.swing.JButton modificaButton;
    private javax.swing.JFormattedTextField orarioText;
    private javax.swing.JTextArea resultArea;
    // End of variables declaration//GEN-END:variables
}
