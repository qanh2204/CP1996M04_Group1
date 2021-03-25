/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeLine.DAO;

import LifeLine.model.Report;
import LifeLine.model.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class PatientDAO {

    public static String findName(int patient_id) {
        String name = "";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = lifeLine.DAO.JDBCConection.getConnection();

            String sql = "select F_name +' '+ L_name hoten from Patient where patient_id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, patient_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                name = resultSet.getString("hoten");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return name;
    }
    
    public static List<String> findAll() {
        List<String> list = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = lifeLine.DAO.JDBCConection.getConnection();

            String sql = "select patient_id, F_name +' '+ L_name hoten from Patient ";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String ct;
                ct = new String(resultSet.getString("patient_id")+"-"+resultSet.getString("hoten"));
                list.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return list;
    }
    
    
//    public static void main(String[] args) {
//        String a = new String("1-Quang");
//        System.out.println(a.substring(0, a.indexOf("-")));
//    }
    
}

