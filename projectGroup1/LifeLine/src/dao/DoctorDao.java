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
import model.Doctor;
import dao.JDBCConection;

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
                
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public void updateDoctor(Doctor doctor) {
        //Connection conn = JDBCConection.getConnection();
        Connection conn = dao.JDBCConection.getConnection();
        String sql = "update Doctor set D_name = ?, addr = ?, P_no = ?, specialization = ? where doctor_id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            
            pStatement.setString(1, doctor.getDname());
            pStatement.setString(2, doctor.getAddr());
            pStatement.setString(3, doctor.getPhone());
            pStatement.setString(4, doctor.getSpe());
            pStatement.setInt(5, doctor.getId());
            
            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
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
        }
    }
    
    public void addDoctor(Doctor doctor) {
        Connection conn = JDBCConection.getConnection();
        String sql = "insert into Doctor(doctor_id ,D_name ,addr ,P_no ,specialization) values(?,?,?,?,?)";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, doctor.getId());
            pStatement.setString(2, doctor.getDname());
            pStatement.setString(3, doctor.getAddr());
            pStatement.setString(4, doctor.getPhone());
            pStatement.setString(5, doctor.getSpe());

            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
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
                doctor.setAddr(rs.getString("addr"));
                doctor.setPhone(rs.getString("P_no"));
                doctor.setSpe(rs.getString("specialization"));
                
                return doctor;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}