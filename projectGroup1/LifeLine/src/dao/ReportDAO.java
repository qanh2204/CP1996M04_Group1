/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Report;
import model.Test;
import java.sql.Connection;
import java.sql.Date;
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
            connection = dao.JDBCConection.getConnection();

            String sql = "select * from report ";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Report ct;
                ct = new Report(resultSet.getInt("patient_id"), resultSet.getInt("test_id")
                        , resultSet.getString("report"), resultSet.getDate("DayAdd"));
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


    public static int findID(String name) {
        int id = 0;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dao.JDBCConection.getConnection();

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
            connection = dao.JDBCConection.getConnection();

            //query
            String sql = "update report set report=? where patient_id=? and test_id=? and DayAdd=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, ct.getReport());
            statement.setInt(2, ct.getPatient_id());
            statement.setInt(3, ct.getTest_id());
            statement.setDate(4, ct.getDayAdd());

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

    public static void insert(Report s) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = dao.JDBCConection.getConnection();

            //query
            String sql = "insert into report values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, s.getPatient_id());
            statement.setNString(2, s.getReport());
            statement.setInt(3, s.getTest_id());
            statement.setDate(4, s.getDayAdd());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(int id_patient, int id_test, Date day) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = dao.JDBCConection.getConnection();

            //query
            String sql = "delete from report where patient_id=? and test_id = ? and DayAdd=?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, id_patient);
            statement.setInt(2, id_patient);
            statement.setDate(3, day);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
}
