/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import javax.swing.JOptionPane;
import podesavanja.PodesavanjaKonekcije;

/**
 *
 * @author Jovana Mitrovic
 */
public class FrmKonfigKonekcije extends javax.swing.JDialog {

    /**
     * Creates new form FrmKonfigKonekcije
     */
    public FrmKonfigKonekcije(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnPotrvrdi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Konfiguracija konekcije"));

        jLabel1.setText("Adresa:");

        jLabel2.setText("Port:");

        btnPotrvrdi.setText("Potvrdi");
        btnPotrvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotrvrdiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPotrvrdi, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(txtPort)
                    .addComponent(txtAdresa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPotrvrdi)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPotrvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotrvrdiActionPerformed
        String adresa = txtAdresa.getText().trim();
        String port = txtPort.getText().trim();
        
        if(!adresa.isEmpty() && !port.isEmpty()) {
            PodesavanjaKonekcije.getInstanca().setAdresa(adresa);
            PodesavanjaKonekcije.getInstanca().setPort(port);
            JOptionPane.showMessageDialog(this, "Uspesno promenjeni parametri konekcije");
            dispose();
        }
    }//GEN-LAST:event_btnPotrvrdiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPotrvrdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        txtAdresa.setText(PodesavanjaKonekcije.getInstanca().getProperty("adresa"));
        txtPort.setText(PodesavanjaKonekcije.getInstanca().getProperty("port"));
    }
}
