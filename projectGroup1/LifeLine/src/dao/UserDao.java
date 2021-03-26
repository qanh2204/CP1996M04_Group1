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
import model.User;
import service.UserService;

/**
 *
 * @author qanh2
 */
public class UserDao {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Connection conn = JDBCConection.getConnection();
        String sql = "select * from Account";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUser(rs.getString("username"));
                user.setPass(rs.getString("pass"));
                user.setType(rs.getString("type"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(User user) {
        Connection conn = JDBCConection.getConnection();
        String sql = "update Account set username = ?, pass = ?, type = ? where id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);

            pStatement.setString(1, user.getUser());
            pStatement.setString(2, user.getPass());
            pStatement.setString(3, user.getType());
            pStatement.setInt(4, user.getId());
            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        Connection conn = JDBCConection.getConnection();
        String sql = "delete from Account where id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            int rs = pStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        Connection conn = JDBCConection.getConnection();
        String sql = "insert into Account(id, username, pass, type) values(?,?,?,?)";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, user.getId());
            pStatement.setString(2, user.getUser());
            pStatement.setString(3, user.getPass());
            pStatement.setString(4, user.getType());

            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUsersById(int id) {

        Connection conn = JDBCConection.getConnection();
        String sql = "select * from Account where id = ?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUser(rs.getString("username"));
                user.setPass(rs.getString("pass"));
                user.setType(rs.getString("type"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public String getType(String user, String pass) {
        String type = "";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            String sql = "select type from Account where username=? and pass=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                type = resultSet.getString("type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return type;
    }
    
//    public static void main(String[] args) {
//        UserService a= new UserService();
//        System.out.println(a.getType("anh", "124"));
//    }
}
