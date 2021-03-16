/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeLine.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lifeLine.model.User;

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
        String sql = "update Account set id = ?, username = ?, pass = ?, type = ?";

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
}