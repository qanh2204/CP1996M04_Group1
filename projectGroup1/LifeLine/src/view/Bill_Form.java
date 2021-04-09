/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.BillDAO;
import dao.BillDetailDAO;
import dao.HistoryDAO;
import dao.JDBCConection;
import dao.PatientDAO;
import dao.StaffDao;
import dao.TestDAO;
import dao.UserDao;
import model.Bill;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.Bill_Detail;
import service.DoctorService;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import service.StaffService;

/**
 *
 * @author qanh2
 */
public class Bill_Form extends javax.swing.JPanel {

    DefaultTableModel tableModel, tableModel1;
    List<Bill> rp = new ArrayList<>();
    List<Bill_Detail> bd = new ArrayList<>();
    DoctorService doctor;

    public Bill_Form() {
        initComponents();
        tblBill.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tableModel = (DefaultTableModel) tblBill.getModel();
        tblBillDetail.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tableModel1 = (DefaultTableModel) tblBillDetail.getModel();
        showBill();
        showPatient();
        showData();
        showDataDoctor();
    }

    public void showPatient() {
        List<String> data = PatientDAO.findAll();
        cmbPatient.addItem("");
        data.forEach((s) -> {
            cmbPatient.addItem(s);
        });
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

    public void showDataDoctor() {
        doctor = new DoctorService();
        List<String> data = doctor.getAllDoctor();
        cmbDoctor.addItem("");
        for (String s : data) {
            cmbDoctor.addItem(s);
        }
    }

    public void clear() {
        cmbPatient.setSelectedItem("");
        cmbTest.setSelectedItem("");
        cmbDoctor.setSelectedItem("");

    }

    private void showBill() {
        rp = BillDAO.findAll();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        tableModel.setRowCount(0);

        rp.forEach((r) -> {
            tableModel.addRow(new Object[]{r.getBill_no(), r.getPatient_id(), r.getAmount(), format.format(r.getDayBuy())});
        });
    }

    private void showBillDetail(int bill_no) {
        bd = BillDetailDAO.findAll(bill_no);

        tableModel1.setRowCount(0);
        bd.forEach((Bill_Detail b) -> {
            String t_name = TestDAO.findName(b.getTest_id());

            tableModel1.addRow(new Object[]{b.getTest_id(), t_name, b.getCost()});
        });
    }

    private void updateCost(int bill_no) {
        int total = BillDetailDAO.getTong(bill_no);
        BillDAO.updateAmount(bill_no, total);
        showBillDetail(bill_no);
    }

    public void PrintBill(int bill_no, String date) {
        StaffService staff = new StaffService();
        String id = HistoryDAO.findID();
        String name = staff.getName(id);
        try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/view/BillText.jrxml");

            map.put("bill_no", bill_no);
            map.put("Date", date);
            map.put("Staff", name);

            JasperPrint p = JasperFillManager.fillReport(report, map, JDBCConection.getConnection());
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        txtFind = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbPatient = new javax.swing.JComboBox<>();
        cmbTest = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbDoctor = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBillDetail = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();

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
                "Bill No", "Patient ID", "Amount", "Day "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        if (tblBill.getColumnModel().getColumnCount() > 0) {
            tblBill.getColumnModel().getColumn(0).setResizable(false);
            tblBill.getColumnModel().getColumn(1).setResizable(false);
            tblBill.getColumnModel().getColumn(2).setResizable(false);
        }

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
        btnEdit.setText("Print");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDeleteAll.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeleteAll.setText("Delete All");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Patient");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Test name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Doctor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cmbDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBillDetail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Test Name", "Cost"
            }
        ));
        tblBillDetail.setRowHeight(30);
        jScrollPane2.setViewportView(tblBillDetail);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnDeleteAll)
                        .addGap(48, 48, 48)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        doctor = new DoctorService();
        int selectedIndex = tblBill.getSelectedRow();

        if (selectedIndex != -1) {
            //Neu chon bang thi cap nhat
            Bill bill = rp.get(selectedIndex);
            //Get test id
            int ts = TestDAO.findID((String) cmbTest.getSelectedItem());
            //Get cost
            int am = TestDAO.getCost(ts);
            //Get doctor id
            int doc = doctor.getID((String) cmbDoctor.getSelectedItem());
            //Get current day
            long millis = System.currentTimeMillis();
            Date day = new Date(millis);

            Bill_Detail billdetail = new Bill_Detail(bill.getBill_no(), ts, doc, am, day);
            BillDetailDAO.insert(billdetail);
            updateCost(bill.getBill_no());

        } else {
            //Create bill_no
            int bno = BillDAO.findMaxID() + 1;
            //Get patient id
            String kq = (String) cmbPatient.getSelectedItem();
            int pt = Integer.parseInt(kq.substring(0, kq.indexOf("-")).trim());
            //Get test id
            int ts = TestDAO.findID((String) cmbTest.getSelectedItem());
            //Get cost
            int am = TestDAO.getCost(ts);
            //Get doctor id
            int doc = doctor.getID((String) cmbDoctor.getSelectedItem());
            //Get current day
            long millis = System.currentTimeMillis();
            Date day = new Date(millis);
            //neu khong chon bang thi tao bill moi        
            Bill bill = new Bill(bno, pt, am, day);
            Bill_Detail billdetail = new Bill_Detail(bno, ts, doc, am, day);

            BillDAO.insert(bill);
            BillDetailDAO.insert(billdetail);
        }
        showBill();
        clear();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked
        int selectedIndex = tblBill.getSelectedRow();
        Bill bill = rp.get(selectedIndex);

        showBillDetail(bill.getBill_no());
//        if (selectedIndex >= 0) {
//            Bill t = rp.get(selectedIndex);
////            for (int i = 0; i < cmbTest.getItemCount(); i++) {
////                if (cmbTest.getItemAt(i).equalsIgnoreCase(TestDAO.findName(t.getTest_id()))) {
////                    cmbTest.setSelectedIndex(i);
////                }
////            }
//            for (int i = 0; i < cmbPatient.getItemCount(); i++) {
//                if (cmbPatient.getItemAt(i).equalsIgnoreCase(t.getPatient_id() + "-" + PatientDAO.findName(t.getPatient_id()))) {
//                    cmbPatient.setSelectedIndex(i);
//                }
//            }
//        }

    }//GEN-LAST:event_tblBillMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedIndex = tblBill.getSelectedRow();
        long millis = System.currentTimeMillis();
        Date day = new Date(millis);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String d = format.format(day);
        Bill bill = rp.get(selectedIndex);
        if (selectedIndex != -1) {
            PrintBill(bill.getBill_no(), d);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        int selectedIndex = tblBill.getSelectedRow();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select patient first", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Bill b = rp.get(selectedIndex);
            int Bno = b.getBill_no();
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete");
            if (option == 0) {
                BillDetailDAO.deleteAll(Bno);
                BillDAO.delete(Bno);
                showBillDetail(Bno);
                showBill();
                clear();
            }
        }
    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void tblBillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMousePressed

    }//GEN-LAST:event_tblBillMousePressed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        String query = txtFind.getText();
        filter(query);
    }//GEN-LAST:event_txtFindKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int Index2 = tblBillDetail.getSelectedRow();
        if (Index2 == -1) {
            JOptionPane.showMessageDialog(this, "Please select patient first", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Bill_Detail b = bd.get(Index2);
            int Bno = b.getBill_no();
            int test_id = b.getTest_id();
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete");
            if (option == 0) {
                BillDetailDAO.deleteBy(Bno, test_id);
                updateCost(Bno);
                showBillDetail(Bno);
                showBill();
                clear();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tableModel);
        tblBill.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cmbDoctor;
    private javax.swing.JComboBox<String> cmbPatient;
    private javax.swing.JComboBox<String> cmbTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblBillDetail;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
