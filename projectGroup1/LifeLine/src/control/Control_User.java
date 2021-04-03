/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.Bill_Form;
import view.ListUserJPanel;
import view.ListPatientJPanel;
import view.ListStockJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.ChangePassword;
import view.ListDoctorJPanel;
import view.ListStaffJPanel;

public class Control_User {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;

    public Control_User(JPanel jpnroot) {
        this.root = jpnroot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "User";
        jpnItem.setBackground(new Color(155, 215, 112));
        jlbItem.setBackground(new Color(155, 215, 112));
        jlbItem.setForeground(Color.BLACK);

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ListUserJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Staff":
                    node =  new ListStaffJPanel();
                    break;
                case "User":
                    node =  new ListUserJPanel();
                    break;
                case "Doctor":
                    node =  new ListDoctorJPanel();
                    break;
                case "ChangePassword":
                    node = new ChangePassword();
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(155, 215, 112));
            jlbItem.setBackground(new Color(155, 215, 112));
            jlbItem.setForeground(Color.BLACK);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(155, 215, 112));
            jlbItem.setBackground(new Color(155, 215, 112));
            jlbItem.setForeground(Color.BLACK);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(27, 52, 9));
                jlbItem.setBackground(new Color(27, 52, 9));
                jlbItem.setForeground(Color.WHITE);
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(155, 215, 112));
                item.getJlb().setBackground(new Color(155, 215, 112));
                item.getJlb().setForeground(Color.BLACK);
            } else {
                item.getJpn().setBackground(new Color(27, 52, 9));
                item.getJlb().setBackground(new Color(27, 52, 9));
                item.getJlb().setForeground(Color.WHITE);
            }
        }
    }
}
