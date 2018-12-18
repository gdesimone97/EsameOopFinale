package oop2018.secondaprova.gruppo07;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gruppo07
 */
public class MainFrame extends javax.swing.JFrame {

    private ElencoPromemoria ep;
    private DefaultListModel dm = new DefaultListModel();
    private final String nomeFile = "backup.dat";
    private final ControlloScadenza threadSalvataggio;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        ep = new ElencoPromemoria();
        setFrameIcon(this, "/icone/frameIcon.png");
        initComponents();
        aggiornaModello();
        resultLabel.setText("");
        threadSalvataggio = new ControlloScadenza(ep, 15, this);
        threadSalvataggio.start();
        new Thread(() -> {
            while (true) {
                synchronized (ep) {
                    try {
                        ep.wait();
                        aggiornaModello();
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }).start();
    }

    private void setFrameIcon(JFrame frame, String path) {
        URL iconURL = getClass().getResource(path);
        ImageIcon image = new ImageIcon(iconURL);
        frame.setIconImage(image.getImage());
    }

    private Icon setIcon(String path) {
        return new ImageIcon(getClass().getResource(path));
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

    private void initModificaFrame() {
        modificaFrame.setLocationRelativeTo(this);
        modificaFrame.setSize(inserisciFrame.getPreferredSize());

        campoDescrizione1.setVisible(false);
        campoOrario1.setVisible(false);

        Promemoria p = (Promemoria) dm.getElementAt(lista.getSelectedIndex());
        giornoSpinner1.setValue(p.getData().getDayOfMonth());
        meseSpinner1.setValue(p.getData().getMonthValue());
        annoSpinner1.setValue(p.getData().getYear());
        orarioText1.setText(String.format("%02d:%02d", p.getData().getHour(), p.getData().getMinute()));
        descrizioneText1.setText(p.getDescrizione());
    }

    private synchronized void aggiornaModello() {

        dm.clear();

        ep.forEach(p -> dm.addElement(p));

        lista.setModel(dm);

        if (ep.isEmpty()) {
            rimuoviAllButton.setEnabled(false);
        } else {
            rimuoviAllButton.setEnabled(true);
        }

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
        modificaFrame = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        giornoSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        meseSpinner1 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        annoSpinner1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        orarioText1 = new javax.swing.JFormattedTextField();
        campoOrario1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        descrizioneText1 = new javax.swing.JTextField();
        campoDescrizione1 = new javax.swing.JLabel();
        confermaButton1 = new javax.swing.JButton();
        annullaButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        inserisciButton = new javax.swing.JButton();
        cancellaButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        rimuoviAllButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        salvaButton = new javax.swing.JMenuItem();
        caricaButton = new javax.swing.JMenuItem();

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
        giornoSpinner.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                giornoSpinnerMouseWheelMoved(evt);
            }
        });

        jLabel2.setText("Mese:");

        meseSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        meseSpinner.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                meseSpinnerMouseWheelMoved(evt);
            }
        });

        jLabel3.setText("Anno:");

        annoSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        annoSpinner.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                annoSpinnerMouseWheelMoved(evt);
            }
        });

        jLabel5.setText("Orario:");

        try {
            orarioText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        orarioText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orarioTextFocusGained(evt);
            }
        });
        orarioText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orarioTextKeyPressed(evt);
            }
        });

        campoOrario.setForeground(new java.awt.Color(255, 0, 0));
        campoOrario.setText("*Data/ora non valida");

        jLabel7.setText("Descrizione:");

        descrizioneText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descrizioneTextFocusGained(evt);
            }
        });
        descrizioneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descrizioneTextKeyPressed(evt);
            }
        });

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
                .addGap(0, 39, Short.MAX_VALUE))
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
                .addContainerGap(109, Short.MAX_VALUE))
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifica"));
        jPanel3.setPreferredSize(new java.awt.Dimension(390, 340));

        jLabel4.setText("Giorno:");

        giornoSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        giornoSpinner1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                giornoSpinner1MouseWheelMoved(evt);
            }
        });

        jLabel6.setText("Mese:");

        meseSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        meseSpinner1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                meseSpinner1MouseWheelMoved(evt);
            }
        });

        jLabel8.setText("Anno:");

        annoSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        annoSpinner1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                annoSpinner1MouseWheelMoved(evt);
            }
        });

        jLabel9.setText("Orario:");

        try {
            orarioText1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        orarioText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orarioText1FocusGained(evt);
            }
        });
        orarioText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orarioText1KeyPressed(evt);
            }
        });

        campoOrario1.setForeground(new java.awt.Color(255, 0, 0));
        campoOrario1.setText("*Data/ora non valida");

        jLabel10.setText("Descrizione:");

        descrizioneText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descrizioneText1FocusGained(evt);
            }
        });
        descrizioneText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descrizioneText1KeyPressed(evt);
            }
        });

        campoDescrizione1.setForeground(new java.awt.Color(255, 0, 0));
        campoDescrizione1.setText("*Campo obbligatorio");
        campoDescrizione1.setToolTipText("");

        confermaButton1.setText("Conferma");
        confermaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButton1ActionPerformed(evt);
            }
        });

        annullaButton1.setText("Annulla");
        annullaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(descrizioneText1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(giornoSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(meseSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(annoSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoOrario1)
                            .addComponent(jLabel10)
                            .addComponent(campoDescrizione1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orarioText1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(confermaButton1)
                        .addGap(18, 18, 18)
                        .addComponent(annullaButton1)))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornoSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(meseSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(annoSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(orarioText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoOrario1)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descrizioneText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDescrizione1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confermaButton1)
                    .addComponent(annullaButton1))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout modificaFrameLayout = new javax.swing.GroupLayout(modificaFrame.getContentPane());
        modificaFrame.getContentPane().setLayout(modificaFrameLayout);
        modificaFrameLayout.setHorizontalGroup(
            modificaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        modificaFrameLayout.setVerticalGroup(
            modificaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, 300, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lista);

        inserisciButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/addIcon.png"))); // NOI18N
        inserisciButton.setText("Inserisci");
        inserisciButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserisciButtonActionPerformed(evt);
            }
        });

        cancellaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/removeIcon.png"))); // NOI18N
        cancellaButton.setText("Cancella");
        cancellaButton.setEnabled(false);
        cancellaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellaButtonActionPerformed(evt);
            }
        });

        modificaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/editItemIcon.png"))); // NOI18N
        modificaButton.setText("Modifica");
        modificaButton.setEnabled(false);
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });

        rimuoviAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/removeAllItemsIcon.png"))); // NOI18N
        rimuoviAllButton.setText("Svuota");
        rimuoviAllButton.setEnabled(false);
        rimuoviAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rimuoviAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modificaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inserisciButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancellaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rimuoviAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inserisciButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancellaButton)
                        .addGap(18, 18, 18)
                        .addComponent(modificaButton)
                        .addGap(18, 18, 18)
                        .addComponent(rimuoviAllButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        resultLabel.setText("Testo");

        jMenu1.setText("File");

        salvaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/UploadIcon.png"))); // NOI18N
        salvaButton.setText("Salva");
        salvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaButtonActionPerformed(evt);
            }
        });
        jMenu1.add(salvaButton);

        caricaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/DownloadIcon.png"))); // NOI18N
        caricaButton.setText("Carica");
        caricaButton.setToolTipText("");
        caricaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caricaButtonActionPerformed(evt);
            }
        });
        jMenu1.add(caricaButton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resultLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultLabel)
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
        int giorno, mese, anno, ora = 0, minuti = 0;
        Scanner sc = new Scanner(orarioText.getText());
        sc.useDelimiter(":");

        String descrizione = descrizioneText.getText();
        giorno = (int) giornoSpinner.getValue();
        mese = (int) meseSpinner.getValue();
        anno = (int) annoSpinner.getValue();

        try {
            ora = sc.nextInt();
            minuti = sc.nextInt();
            ep.inserisciPromemoria(descrizione, giorno, mese, anno, ora, minuti);

            resultLabel.setText("Promemoria aggiunto correttamente");
            inserisciFrame.setVisible(false);
            this.setEnabled(true);
            this.setVisible(true);
        } catch (DataNonValidaException | InputMismatchException ex) {
            campoOrario.setVisible(true);
            if (descrizioneText.getText().equals("")) {
                campoDescrizione.setVisible(true);
            }
        } catch (DescrizioneNonValidaException ex) {
            campoDescrizione.setVisible(true);
        } catch (PromemoriaPresenteException ex) {
            JOptionPane.showMessageDialog(this, "Già è presente un promemoria con questa data/orario", "Attenzione", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/icone/warning64.png")));
        }
    }//GEN-LAST:event_confermaButtonActionPerformed


    private void cancellaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellaButtonActionPerformed
        try {
            Promemoria p = (Promemoria) dm.getElementAt(lista.getSelectedIndex());
            if (JOptionPane.showConfirmDialog(this, p + "\nVuoi cancellare questo promemoria?", "Conferma cancellazione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/icone/questionIcon.png"))) == JOptionPane.YES_OPTION) {
                ep.rimuoviPromemoria(p);
                resultLabel.setText("Promemoria rimosso correttamente");
            }
        } catch (PromemoriaNonEsistenteException ex) {
        }
    }//GEN-LAST:event_cancellaButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
        this.setEnabled(false);
        initModificaFrame();
        modificaFrame.setVisible(true);
    }//GEN-LAST:event_modificaButtonActionPerformed

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if (!lista.isSelectionEmpty()) {
            cancellaButton.setEnabled(true);
            modificaButton.setEnabled(true);
        } else {
            cancellaButton.setEnabled(false);
            modificaButton.setEnabled(false);
        }
    }//GEN-LAST:event_listaValueChanged

    private void caricaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caricaButtonActionPerformed
        ElencoPromemoria epOld = ep;
        if ((ep = Salvataggio.caricaDaFile(nomeFile)) != null) {
            synchronized (ep) {
                int elementiRimossi = ep.rimuoviPromemoriaScaduti();
                if (elementiRimossi != 0) {
                    JOptionPane.showMessageDialog(this, "Numero di elementi scaduti: " + elementiRimossi, "Elementi scaduti", JOptionPane.INFORMATION_MESSAGE, setIcon("/icone/removeItemIcon.png"));
                }
                ep.notifyAll();
            }
            synchronized (epOld) {
                threadSalvataggio.setElenco(ep);
                epOld.notifyAll();
            }
            
            JOptionPane.showMessageDialog(this, "File caricato con successo","Caricamento completato",JOptionPane.INFORMATION_MESSAGE,setIcon("/icone/affermativeIcon.png"));
        } else {
            JOptionPane.showMessageDialog(this, "Errore nel caricamento del file", "Errore", JOptionPane.WARNING_MESSAGE, setIcon("/icone/errorFileIcon.png"));
            ep = epOld;
        }
    }//GEN-LAST:event_caricaButtonActionPerformed

    private void salvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaButtonActionPerformed
        if (Salvataggio.salvaSuFile(nomeFile, ep)) {
            JOptionPane.showMessageDialog(this, "Salvataggio completato con successo", "Salvataggio", JOptionPane.INFORMATION_MESSAGE, setIcon("/icone/affermativeIcon.png"));
        } else {
            JOptionPane.showMessageDialog(this, "Salvataggio non riuscito", "Attenzione", JOptionPane.INFORMATION_MESSAGE, setIcon("/icone/warning64.png"));
        }
    }//GEN-LAST:event_salvaButtonActionPerformed

    private void confermaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButton1ActionPerformed
        campoDescrizione1.setVisible(false);
        campoOrario1.setVisible(false);
        int giorno, mese, anno, ora = 0, minuti = 0;
        Scanner sc = new Scanner(orarioText1.getText());
        sc.useDelimiter(":");

        String descrizione = descrizioneText1.getText();
        giorno = (int) giornoSpinner1.getValue();
        mese = (int) meseSpinner1.getValue();
        anno = (int) annoSpinner1.getValue();

        try {
            ora = sc.nextInt();
            minuti = sc.nextInt();
            Promemoria p = (Promemoria) dm.getElementAt(lista.getSelectedIndex());
            ep.modificaPromemoria(p, descrizione, giorno, mese, anno, ora, minuti);
            resultLabel.setText("Promemoria modificato correttamente");
            modificaFrame.setVisible(false);
            this.setEnabled(true);
            this.setVisible(true);
        } catch (DataNonValidaException | InputMismatchException ex) {
            campoOrario1.setVisible(true);
            if (descrizioneText1.getText().equals("")) {
                campoDescrizione1.setVisible(true);
            }
        } catch (DescrizioneNonValidaException ex) {
            campoDescrizione1.setVisible(true);
        } catch (PromemoriaPresenteException ex) {
            JOptionPane.showMessageDialog(this, "Già è presente un promemoria con questa data/orario", "Attenzione", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/icone/warning64.png")));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Impossibile modificare il promemoria: è scaduto", "Promemoria scaduto", JOptionPane.INFORMATION_MESSAGE, setIcon("/icone/timeIcon.png"));
            modificaFrame.setVisible(false);
            this.setEnabled(true);
            this.setVisible(true);
        }
    }//GEN-LAST:event_confermaButton1ActionPerformed

    private void annullaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButton1ActionPerformed
        modificaFrame.setVisible(false);
        this.setVisible(true);
        this.setEnabled(true);
    }//GEN-LAST:event_annullaButton1ActionPerformed

    private void rimuoviAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rimuoviAllButtonActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Vuoi cancellare tutti i promemoria?", "Conferma cancellazione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, setIcon("/icone/questionIcon.png")) == JOptionPane.YES_OPTION) {
            ep.svuotaElenco();
            resultLabel.setText("Eliminati tutti i promemoria correttamente");
        }
    }//GEN-LAST:event_rimuoviAllButtonActionPerformed

    private void descrizioneTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descrizioneTextKeyPressed
        int keyPressed = evt.getKeyCode();
        if (keyPressed == evt.VK_ENTER) {
            confermaButtonActionPerformed(null);
        }
    }//GEN-LAST:event_descrizioneTextKeyPressed

    private void orarioTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orarioTextKeyPressed
        int keyPressed = evt.getKeyCode();
        if (keyPressed == evt.VK_ENTER) {
            confermaButtonActionPerformed(null);
        }
    }//GEN-LAST:event_orarioTextKeyPressed

    private void descrizioneText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descrizioneText1KeyPressed
        int keyPressed = evt.getKeyCode();
        if (keyPressed == evt.VK_ENTER) {
            confermaButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_descrizioneText1KeyPressed

    private void orarioText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orarioText1KeyPressed
        int keyPressed = evt.getKeyCode();
        if (keyPressed == evt.VK_ENTER) {
            confermaButtonActionPerformed(null);
        }
    }//GEN-LAST:event_orarioText1KeyPressed

    private void orarioTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orarioTextFocusGained
        orarioText.selectAll();
    }//GEN-LAST:event_orarioTextFocusGained

    private void descrizioneTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descrizioneTextFocusGained
        descrizioneText.selectAll();
    }//GEN-LAST:event_descrizioneTextFocusGained

    private void orarioText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orarioText1FocusGained
        orarioText1.selectAll();
    }//GEN-LAST:event_orarioText1FocusGained

    private void descrizioneText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descrizioneText1FocusGained
        descrizioneText1.selectAll();
    }//GEN-LAST:event_descrizioneText1FocusGained

    private void giornoSpinner1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_giornoSpinner1MouseWheelMoved
        int spinValue = evt.getWheelRotation();
        if (spinValue < 0) {
            giornoSpinner1.setValue(((Integer) giornoSpinner1.getValue()) % 31 + 1);
        } else if (spinValue > 0) {
            giornoSpinner1.setValue(((Integer) giornoSpinner1.getValue() - 1 + 30) % 31 + 1);
        }
    }//GEN-LAST:event_giornoSpinner1MouseWheelMoved

    private void meseSpinner1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_meseSpinner1MouseWheelMoved
        int spinValue = evt.getWheelRotation();
        if (spinValue < 0) {
            meseSpinner1.setValue(((Integer) meseSpinner1.getValue()) % 12 + 1);
        } else if (spinValue > 0) {
            meseSpinner1.setValue(((Integer) meseSpinner1.getValue() - 1 + 11) % 12 + 1);
        }
    }//GEN-LAST:event_meseSpinner1MouseWheelMoved

    private void annoSpinner1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_annoSpinner1MouseWheelMoved
        annoSpinner1.setValue((Integer) annoSpinner1.getValue() - evt.getWheelRotation());
    }//GEN-LAST:event_annoSpinner1MouseWheelMoved

    private void giornoSpinnerMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_giornoSpinnerMouseWheelMoved
        int spinValue = evt.getWheelRotation();
        if (spinValue < 0) {
            giornoSpinner.setValue(((Integer) giornoSpinner.getValue()) % 31 + 1);
        } else if (spinValue > 0) {
            giornoSpinner.setValue(((Integer) giornoSpinner.getValue() - 1 + 30) % 31 + 1);
        }
    }//GEN-LAST:event_giornoSpinnerMouseWheelMoved

    private void meseSpinnerMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_meseSpinnerMouseWheelMoved
        int spinValue = evt.getWheelRotation();
        if (spinValue < 0) {
            meseSpinner.setValue(((Integer) meseSpinner.getValue()) % 12 + 1);
        } else if (spinValue > 0) {
            meseSpinner.setValue(((Integer) meseSpinner.getValue() - 1 + 11) % 12 + 1);
        }
    }//GEN-LAST:event_meseSpinnerMouseWheelMoved

    private void annoSpinnerMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_annoSpinnerMouseWheelMoved
        annoSpinner.setValue((Integer) annoSpinner.getValue() - evt.getWheelRotation());
    }//GEN-LAST:event_annoSpinnerMouseWheelMoved

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
            @Override
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner annoSpinner;
    private javax.swing.JSpinner annoSpinner1;
    private javax.swing.JButton annullaButton;
    private javax.swing.JButton annullaButton1;
    private javax.swing.JLabel campoDescrizione;
    private javax.swing.JLabel campoDescrizione1;
    private javax.swing.JLabel campoOrario;
    private javax.swing.JLabel campoOrario1;
    private javax.swing.JButton cancellaButton;
    private javax.swing.JMenuItem caricaButton;
    private javax.swing.JButton confermaButton;
    private javax.swing.JButton confermaButton1;
    private javax.swing.JTextField descrizioneText;
    private javax.swing.JTextField descrizioneText1;
    private javax.swing.JSpinner giornoSpinner;
    private javax.swing.JSpinner giornoSpinner1;
    private javax.swing.JButton inserisciButton;
    private javax.swing.JFrame inserisciFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lista;
    private javax.swing.JSpinner meseSpinner;
    private javax.swing.JSpinner meseSpinner1;
    private javax.swing.JButton modificaButton;
    private javax.swing.JFrame modificaFrame;
    private javax.swing.JFormattedTextField orarioText;
    private javax.swing.JFormattedTextField orarioText1;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton rimuoviAllButton;
    private javax.swing.JMenuItem salvaButton;
    // End of variables declaration//GEN-END:variables
}
