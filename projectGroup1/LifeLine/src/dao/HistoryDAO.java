/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.History;

/**
 *
 * @author Windows
 */
public class HistoryDAO {

    public static void insert(History his) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "insert into History values(?,?, ?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, his.getSTT());
            statement.setString(2, his.getID());
            statement.setDate(3, his.getCurrent_day());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static int findMaxSTT() {
        int STT_max = 0;

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDBCConection.getConnection();

            String sql = "select STT from History where STT=(select max(STT) from History)";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                STT_max = resultSet.getInt("STT");
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

        return STT_max;
    }
    
    public static String findID() {
        String id_max = "";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDBCConection.getConnection();

            String sql = "select id from History where STT=(select max(STT) from History)";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                id_max = resultSet.getString("id");
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

        return id_max;
    }
}
