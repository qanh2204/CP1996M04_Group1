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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill_Detail;

/**
 *
 * @author Windows
 */
public class BillDetailDAO {

    public static List<Bill_Detail> findAll(int bill_no) {
        List<Bill_Detail> bill = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "select * from BillDetail where bill_no = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, bill_no);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Bill_Detail b;
                b = new Bill_Detail(resultSet.getInt("bill_no"), resultSet.getInt("test_id"),
                        resultSet.getInt("doctor_id"), resultSet.getInt("cost"), resultSet.getDate("DayAdd"));
                bill.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return bill;
    }

    public static void insert(Bill_Detail ct) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "insert into BillDetail values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, ct.getBill_no());
            statement.setInt(2, ct.getTest_id());
            statement.setInt(3, ct.getDoctor_id());
            statement.setInt(4, ct.getCost());
            statement.setDate(5, ct.getDay());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(Bill_Detail ct) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "update BillDetail set test_id=?, doctor_id=?, cost=?, DayAdd=? where bill_no=? and test_id=?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, ct.getTest_id());
            statement.setInt(2, ct.getDoctor_id());
            statement.setInt(3, ct.getCost());
            statement.setInt(4, ct.getBill_no());
            statement.setDate(5, ct.getDay());
            statement.setInt(6, ct.getTest_id());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void deleteAll(int bill_no) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "delete from BillDetail where bill_no = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, bill_no);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void deleteBy(int bill_no, int test_id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "delete from BillDetail where bill_no = ? and test_id=?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, bill_no);
            statement.setInt(2, test_id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static int getTong(int bill_no) {
        Connection connection = null;
        PreparedStatement statement = null;
        int total = 0;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "select sum(cost) as Total from BillDetail group by bill_no having bill_no=?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, bill_no);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                total = resultSet.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return total;
    }

}
