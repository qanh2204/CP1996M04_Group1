/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Control_Staff;
import control.DanhMucBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class MainStaffFrame extends javax.swing.JFrame {

    /**
     * Creates new form Don_hang
     */
    public MainStaffFrame() {
        initComponents();
        
        setTitle("Staff Form");
        setLocationRelativeTo(null);
        
        Control_Staff control = new Control_Staff(View);
        control.setView(jpnPatient, jlbPatient);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("Patient", jpnPatient, jlbPatient));
        listItem.add(new DanhMucBean("Stock", jpnStock, jlbStock));
        listItem.add(new DanhMucBean("Bill", jpnBill, jlbBill));
        listItem.add(new DanhMucBean("ChangePassword", jpnChange, jlbChange));
        
        control.setEvent(listItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        jpnPatient = new javax.swing.JPanel();
        jlbPatient = new javax.swing.JLabel();
        jpnStock = new javax.swing.JPanel();
        jlbStock = new javax.swing.JLabel();
        jpnBill = new javax.swing.JPanel();
        jlbBill = new javax.swing.JLabel();
        btnLogout3 = new javax.swing.JButton();
        jpnChange = new javax.swing.JPanel();
        jlbChange = new javax.swing.JLabel();
        View = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(27, 52, 9));

        jpnPatient.setBackground(new java.awt.Color(27, 52, 9));

        jlbPatient.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbPatient.setForeground(new java.awt.Color(255, 255, 255));
        jlbPatient.setText("Patient");

        javax.swing.GroupLayout jpnPatientLayout = new javax.swing.GroupLayout(jpnPatient);
        jpnPatient.setLayout(jpnPatientLayout);
        jpnPatientLayout.setHorizontalGroup(
            jpnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnPatientLayout.setVerticalGroup(
            jpnPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPatientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnStock.setBackground(new java.awt.Color(27, 52, 9));

        jlbStock.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbStock.setForeground(new java.awt.Color(255, 255, 255));
        jlbStock.setText("Stock");

        javax.swing.GroupLayout jpnStockLayout = new javax.swing.GroupLayout(jpnStock);
        jpnStock.setLayout(jpnStockLayout);
        jpnStockLayout.setHorizontalGroup(
            jpnStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnStockLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jpnStockLayout.setVerticalGroup(
            jpnStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnStockLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jlbStock, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        jpnBill.setBackground(new java.awt.Color(27, 52, 9));

        jlbBill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbBill.setForeground(new java.awt.Color(255, 255, 255));
        jlbBill.setText("Bill");

        javax.swing.GroupLayout jpnBillLayout = new javax.swing.GroupLayout(jpnBill);
        jpnBill.setLayout(jpnBillLayout);
        jpnBillLayout.setHorizontalGroup(
            jpnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBillLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbBill, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jpnBillLayout.setVerticalGroup(
            jpnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBillLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbBill, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnLogout3.setBackground(new java.awt.Color(27, 52, 9));
        btnLogout3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogout3.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout3.setText("Log out");
        btnLogout3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnLogout3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout3ActionPerformed(evt);
            }
        });

        jpnChange.setBackground(new java.awt.Color(27, 52, 9));

        jlbChange.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlbChange.setForeground(new java.awt.Color(255, 255, 255));
        jlbChange.setText("Change Password");

        javax.swing.GroupLayout jpnChangeLayout = new javax.swing.GroupLayout(jpnChange);
        jpnChange.setLayout(jpnChangeLayout);
        jpnChangeLayout.setHorizontalGroup(
            jpnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnChangeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbChange, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jpnChangeLayout.setVerticalGroup(
            jpnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChangeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbChange, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLogout3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jpnPatient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(jpnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 217, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jpnStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jpnBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jpnChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnLogout3, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );

        View.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout ViewLayout = new javax.swing.GroupLayout(View);
        View.setLayout(ViewLayout);
        ViewLayout.setHorizontalGroup(
            ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        ViewLayout.setVerticalGroup(
            ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 176, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIFE LINE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(View, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(View, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogout3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout3ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you really want to logout?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            Login_Form login = new Login_Form();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnLogout3ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel View;
    private javax.swing.JButton btnLogout3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlbBill;
    private javax.swing.JLabel jlbChange;
    private javax.swing.JLabel jlbPatient;
    private javax.swing.JLabel jlbStock;
    private javax.swing.JPanel jpnBill;
    private javax.swing.JPanel jpnChange;
    private javax.swing.JPanel jpnPatient;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnStock;
    // End of variables declaration//GEN-END:variables
}
