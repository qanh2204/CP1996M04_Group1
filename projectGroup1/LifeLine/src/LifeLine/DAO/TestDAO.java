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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import LifeLine.model.Test;
import java.sql.Statement;
import lifeLine.DAO.JDBCConection;

/**
 *
 * @author Windows
 */
public class TestDAO {

    public static List<Test> findAll() {
        List<Test> test = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDBCConection.getConnection();

            String sql = "select * from test ";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Test ct;
                ct = new Test(resultSet.getInt("test_id"), resultSet.getString("t_name"), resultSet.getInt("cost"));
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
            connection = JDBCConection.getConnection();

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
    
    public static void insert(Test s) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = JDBCConection.getConnection();

            //query
            String sql = "insert into test values(?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, s.getTest_id());
            statement.setNString(2, s.getT_name());
            statement.setInt(3, s.getCost());

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

    public static void update(Test ct) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            //query
            String sql = "update test set test_id=?, t_name=?, cost=? where test_id=?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, ct.getTest_id());
            statement.setString(2, ct.getT_name());
            statement.setInt(3, (int) ct.getCost());
            statement.setInt(4, (int) ct.getTest_id());

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

    //xóa hết sản phẩm có trong hóa đơn
    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = JDBCConection.getConnection();

            //query
            String sql = "delete from test where test_id = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, id);

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
    
    public static int findMaxID() {
        int id_max = 0;

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDBCConection.getConnection();

            String sql = "select test_id from test where test_id=(select max(test_id) from test)";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                id_max = resultSet.getInt("test_id");
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
