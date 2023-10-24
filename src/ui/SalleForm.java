/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.IDao;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Config;

/**
 *
 * @author Lachgar
 */
public class SalleForm extends javax.swing.JInternalFrame {

    private static int id;
    IDao<Salle> daoS;
    DefaultTableModel model;


    /**
     * Creates new form MachineForm
     */
    public SalleForm() {
        try {
            initComponents();
        

            daoS = (IDao<Salle>) Naming.lookup("rmi://localhost:1090/daosalle");         
            model = (DefaultTableModel) salleList.getModel();
            load();
        } catch (NotBoundException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void load() {
        try {
            model.setRowCount(0);
            for (Salle m : daoS.findAll()) {
                model.addRow(new Object[]{
                  m.getId(),
                    m.getcode()
                });
            }
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        bnAdd3 = new javax.swing.JButton();
        bnUpdate3 = new javax.swing.JButton();
        bnDelete3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salleList = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("G Machine");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        bnAdd3.setText("Ajouter");
        bnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAdd3ActionPerformed(evt);
            }
        });

        bnUpdate3.setText("Modifier");
        bnUpdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnUpdate3ActionPerformed(evt);
            }
        });

        bnDelete3.setText("Supprimer");
        bnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDelete3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bnDelete3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnUpdate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnAdd3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(bnAdd3)
                .addGap(35, 35, 35)
                .addComponent(bnUpdate3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(bnDelete3)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations machine"));

        jLabel1.setText("Code");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des machines"));

        salleList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code"
            }
        ));
        salleList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salleListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salleList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Liste des salles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Informations salles");

        getAccessibleContext().setAccessibleName("G Salle");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAdd3ActionPerformed
                                         
        try {
            // TODO add your handling code here:
            String ref = txtRef.getText().toString();

            daoS.create(new Salle(ref));
            System.out.println(new Salle(ref).getId());
            load();
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                     
    private void ObjetMouseClicked(java.awt.event.MouseEvent evt) {
        id = Integer.parseInt(model.getValueAt(salleList.getSelectedRow(), 0).toString());
        txtRef.setText(model.getValueAt(salleList.getSelectedRow(), 1).toString());
        

        //jTextField2_code.setText(Tmodel.getValueAt(listeClient.getSelectedRow(),1).toString());
        // jTextField3_libelle.setText(Tmodel.getValueAt(listeClient.getSelectedRow(),2).toString());
    
    }//GEN-LAST:event_bnAdd3ActionPerformed

    private void bnUpdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnUpdate3ActionPerformed
 String ref = txtRef.getText();

        try {
            Salle s = daoS.findById(id);

            s.setcode(ref);

            if (daoS.update(s)) {
                JOptionPane.showMessageDialog(this, "votre ligne à été modofié");
            }

        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Categorie cat = Cats.findById(id);
        cat.setCode(code);cat.setLibelle(libelle);
        if(Cats.update(cat)){
            JOptionPane.showMessageDialog(this, "votre ligne à été modofié");
        }*/
        load();
    }//GEN-LAST:event_bnUpdate3ActionPerformed

    private void bnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDelete3ActionPerformed
    int reponse = JOptionPane.showConfirmDialog(this, "vous voulez vraiment supprimé cette ligne?");
        if (reponse == 0) {
            try {
                daoS.delete(daoS.findById(id));
                JOptionPane.showMessageDialog(this, "votre ligne a ete supprimée");
                load();
            } catch (RemoteException ex) {
                Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bnDelete3ActionPerformed

    private void salleListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salleListMouseClicked
        ObjetMouseClicked(evt);
    }//GEN-LAST:event_salleListMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAdd;
    private javax.swing.JButton bnAdd1;
    private javax.swing.JButton bnAdd2;
    private javax.swing.JButton bnAdd3;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnDelete1;
    private javax.swing.JButton bnDelete2;
    private javax.swing.JButton bnDelete3;
    private javax.swing.JButton bnUpdate;
    private javax.swing.JButton bnUpdate1;
    private javax.swing.JButton bnUpdate2;
    private javax.swing.JButton bnUpdate3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable salleList;
    private javax.swing.JTextField txtRef;
    // End of variables declaration//GEN-END:variables
}
