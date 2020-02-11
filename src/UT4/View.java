package UT4;

import javax.swing.*;

public class View extends JFrame {

    private javax.swing.JButton btnSubir;
    private javax.swing.JButton btnBajar;
    private javax.swing.JPanel jPanel1;


    /**
     * Creates new form view
     */
    public View(FTP app) {
        initComponents(app);
    }


    private void initComponents(FTP app) {

        jPanel1 = new javax.swing.JPanel();
        btnBajar = new javax.swing.JButton();
        btnSubir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBajar.setText("Descargar Fichero");
        btnSubir.setText("Subir Fichero");

        btnBajar.setActionCommand("bajar");
        btnSubir.setActionCommand("subir");

        btnSubir.addActionListener(app);
        btnBajar.addActionListener(app);
        chargeLayout();
    }

    private void chargeLayout() {

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBajar)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnSubir)))
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnBajar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSubir)
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        btnSubir.getAccessibleContext().setAccessibleName("Subir Fichero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        this.setVisible(true);

    }

}
