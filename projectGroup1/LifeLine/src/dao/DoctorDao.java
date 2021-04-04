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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doctor;

/**
 *
 * @author qanh2
 */
public class DoctorDao {

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        Connection conn = dao.JDBCConection.getConnection();
        String sql = "select * from Doctor";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("doctor_id"));
                doctor.setDname(rs.getString("D_name"));
                doctor.setAddr(rs.getString("address"));
                doctor.setPhone(rs.getString("P_no"));
                doctor.setSpe(rs.getString("specialization"));
                doctor.setAccountId(rs.getString("id"));
                
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public void updateDoctor(Doctor doctor) {
       
        Connection conn = dao.JDBCConection.getConnection();
        String sql = "update Doctor set D_name = ?, address = ?, P_no = ?, specialization = ?, id = ? where doctor_id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            
            pStatement.setString(1, doctor.getDname());
            pStatement.setString(2, doctor.getAddr());
            pStatement.setString(3, doctor.getPhone());
            pStatement.setString(4, doctor.getSpe());
            pStatement.setString(5, doctor.getAccountId());
            pStatement.setInt(6, doctor.getId());
            
            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public void deleteDoctor(int id) {
        Connection conn = JDBCConection.getConnection();
        String sql = "delete from Doctor where doctor_id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            int rs = pStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addDoctor(Doctor doctor) {
        Connection conn = JDBCConection.getConnection();
        String sql = "insert into Doctor(doctor_id, D_name , address , P_no , specialization, id) values(?,?,?,?,?,?)";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, doctor.getId());
            pStatement.setString(2, doctor.getDname());
            pStatement.setString(3, doctor.getAddr());
            pStatement.setString(4, doctor.getPhone());
            pStatement.setString(5, doctor.getSpe());
            pStatement.setString(6, doctor.getAccountId());

            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Doctor getDoctorsById(int id) {
        
        Connection conn = JDBCConection.getConnection();
        String sql = "select * from Doctor where doctor_id = ?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {                
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("doctor_id"));
                doctor.setDname(rs.getString("D_name"));
                doctor.setAddr(rs.getString("address"));
                doctor.setPhone(rs.getString("P_no"));
                doctor.setSpe(rs.getString("specialization"));
                doctor.setAccountId(rs.getString("id"));
                
                return doctor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> findName() {
        List<String> name = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDBCConection.getConnection();

            String sql = "select D_name from Doctor";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String n = resultSet.getString("D_name");
                name.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return name;
    }
    
    public int findID(String name) {
        int id = 0;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCConection.getConnection();

            String sql = "select doctor_id from Doctor where D_name = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("doctor_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoctorDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return id;
    }
}