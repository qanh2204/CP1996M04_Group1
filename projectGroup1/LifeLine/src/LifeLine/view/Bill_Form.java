/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeLine.view;

import LifeLine.DAO.BillDAO;
import LifeLine.DAO.PatientDAO;
import LifeLine.DAO.ReportDAO;
import LifeLine.DAO.TestDAO;
import LifeLine.model.Bill;
import java.awt.Font;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author qanh2
 */
public class Bill_Form extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    List<Bill> rp = new ArrayList<>();

    public Bill_Form() {
        initComponents();
        tblBill.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tableModel = (DefaultTableModel) tblBill.getModel();
        showBill();
        showPatient();
        showData();
    }

    public void showPatient() {
        List<String> data = PatientDAO.findAll();
        cmbPatient.addItem("");
        for (String s : data) {
            cmbPatient.addItem(s);
        }
    }

    public void showPatientID() {
        List<String> data = PatientDAO.findAll();
        cmbPatient.addItem("");
        for (String s : data) {
            cmbPatient.addItem(s);
        }
    }

    public void showData() {
        List<String> data = TestDAO.findName();
        cmbTest.addItem("");
        for (String s : data) {
            cmbTest.addItem(s);
        }
    }

    public void clear() {
        cmbPatient.setSelectedItem("");
        cmbTest.setSelectedItem("");
    }

    private void showBill() {
        rp = BillDAO.findAll();

        tableModel.setRowCount(0);

        rp.forEach((r) -> {
            tableModel.addRow(new Object[]{r.getBill_no(), r.getPatient_id(), r.getTest_id(), r.getAmount()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        txtFind = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbPatient = new javax.swing.JComboBox<>();
        cmbTest = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInformation = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        tblBill.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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
                "Bill No", "Patient ID", "Test ID", "Amount"
            }
        ));
        tblBill.setRowHeight(30);
        tblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBillMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblBill);

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Patient");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Test name");

        cmbPatient.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cmbTest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtInformation.setColumns(20);
        txtInformation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtInformation.setRows(5);
        jScrollPane2.setViewportView(txtInformation);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BILL INFORMATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int bno = BillDAO.findMaxID() + 1;
        String kq = (String) cmbPatient.getSelectedItem();
        int pt = Integer.parseInt(kq.substring(0, kq.indexOf("-")).trim());
        int ts = TestDAO.findID((String) cmbTest.getSelectedItem());
        int am = TestDAO.getCost(ts);

        Bill bill = new Bill(bno, pt, ts, am);
        BillDAO.insert(bill);
        showBill();
        clear();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked
        int selectedIndex = tblBill.getSelectedRow();

        if (selectedIndex >= 0) {
            Bill t = rp.get(selectedIndex);
            for (int i = 0; i < cmbTest.getItemCount(); i++) {
                if (cmbTest.getItemAt(i).equalsIgnoreCase(TestDAO.findName(t.getTest_id()))) {
                    cmbTest.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < cmbPatient.getItemCount(); i++) {
                if (cmbPatient.getItemAt(i).equalsIgnoreCase(t.getPatient_id() + "-" + PatientDAO.findName(t.getPatient_id()))) {
                    cmbPatient.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tblBillMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedIndex = tblBill.getSelectedRow();
        Bill b = rp.get(selectedIndex);
        int Bno = b.getBill_no();
        String kq = (String) cmbPatient.getSelectedItem();
        int pt = Integer.parseInt(kq.substring(0, kq.indexOf("-")).trim());

        String select = (String) cmbTest.getSelectedItem();
        int t_id = TestDAO.findID(select);
        int am = TestDAO.getCost(t_id);

        Bill bill = new Bill(Bno, pt, t_id, am);
        BillDAO.update(bill);
        showBill();
        clear();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedIndex = tblBill.getSelectedRow();
        Bill b = rp.get(selectedIndex);
        int Bno = b.getBill_no();

        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete");
        if (option == 0) {
            BillDAO.delete(Bno);
            showBill();
            clear();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblBillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMousePressed
        int selectedIndex = tblBill.getSelectedRow();
        Bill b = rp.get(selectedIndex);
        String a= "\tBILL INFORMATION";
        txtInformation.setText(a);
        txtInformation.setText(a+ " \nName\t:" + PatientDAO.findName(b.getPatient_id())+"\n"
                               + " \nTest name\t: " + TestDAO.findName(b.getTest_id())+"\n"
                               + " \nAmount\t: " + b.getAmount()
        );
    }//GEN-LAST:event_tblBillMousePressed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        String query = txtFind.getText();
        filter(query);
    }//GEN-LAST:event_txtFindKeyReleased
    
    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tableModel);
        tblBill.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cmbPatient;
    private javax.swing.JComboBox<String> cmbTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBill;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextArea txtInformation;
    // End of variables declaration//GEN-END:variables
}
