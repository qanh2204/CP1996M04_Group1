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
public class ReportDAO {
    public static List<Report> findAll() {
        List<Report> test = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = lifeLine.DAO.JDBCConection.getConnection();

            String sql = "select * from report ";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Report ct;
                ct = new Report(resultSet.getInt("patient_id"), resultSet.getInt("test_id"), resultSet.getString("report"));
                test.add(ct);
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

        return test;
    }

    public static List<String> findName() {
        List<String> name = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = lifeLine.DAO.JDBCConection.getConnection();

            String sql = "select t_name from test";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String n = resultSet.getString("t_name");
                name.add(n);
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

        return name;
    }

    public static int findID(String name) {
        int id = 0;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = lifeLine.DAO.JDBCConection.getConnection();

            String sql = "select test_id from test where t_name = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("test_id");
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

        return id;
    }
    

    public static void update(Report ct) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = lifeLine.DAO.JDBCConection.getConnection();

            //query
            String sql = "update report set patient_id=?, report=?, test_id=?  where patient_id=? and test_id=?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, ct.getPatient_id());
            statement.setString(2, ct.getReport());
            statement.setInt(3, ct.getTest_id());
            statement.setInt(4, ct.getPatient_id());
            statement.setInt(5, ct.getTest_id());

            statement.execute();
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
    }

    
    
}
