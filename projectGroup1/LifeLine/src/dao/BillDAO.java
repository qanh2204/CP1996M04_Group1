/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Bill;
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
public class BillDAO {
    
    public static List<Bill> findAll() {
        List<Bill> bill = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = JDBCConection.getConnection();
            
            String sql = "select * from billing ";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Bill ct;
                ct = new Bill(resultSet.getInt("bill_no"), resultSet.getInt("patient_id"),
                         resultSet.getInt("amount"), resultSet.getDate("DayBuy"));
                bill.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return bill;
    }
    
    public static String findName(int test_id) {
        String name = "";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = JDBCConection.getConnection();
            
            String sql = "select t_name from test where test_id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, test_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                name = resultSet.getString("t_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            connection = JDBCConection.getConnection();
            
            String sql = "select test_id from test where t_name = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, name);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                id = resultSet.getInt("test_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return id;
    }
    
    public static void insert(Bill s) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = dao.JDBCConection.getConnection();

            //query
            String sql = "insert into billing values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, s.getBill_no());
            statement.setInt(2, s.getPatient_id());
            statement.setInt(3, s.getAmount());
            statement.setDate(4, s.getDayBuy());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void update(Bill ct) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = dao.JDBCConection.getConnection();

            //query
            String sql = "update billing set bill_no=?, patient_id=?, amount=?, DayBuy=? where bill_no=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, ct.getBill_no());
            statement.setInt(2, ct.getPatient_id());
            statement.setInt(3, ct.getAmount());
            statement.setDate(4, ct.getDayBuy());
            statement.setInt(5, ct.getBill_no());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    //xóa hết sản phẩm có trong hóa đơn
    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = dao.JDBCConection.getConnection();

            //query
            String sql = "delete from billing where bill_no = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static int findMaxID() {
        int id_max = 0;
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = dao.JDBCConection.getConnection();
            
            String sql = "select bill_no from billing where bill_no=(select max(bill_no) from billing)";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                id_max = resultSet.getInt("bill_no");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return id_max;
    }
    
    public static void updateAmount(int bill_no, int total) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "update Billing set amount=? where bill_no=?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, total);
            statement.setInt(2, bill_no);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static int getPatient(int bill_no) {
        int id = 0;
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = JDBCConection.getConnection();
            
            String sql = "select patient_id from Billing where bill_no = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, bill_no);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                id = resultSet.getInt("patient_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return id;
    }
}
