/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeLine.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    
}

