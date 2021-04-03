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
import model.Patient;
import dao.JDBCConection;

/**
 *
 * @author qanh2
 */
public class PatDao {

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<Patient>();
        Connection conn = dao.JDBCConection.getConnection();
        String sql = "select * from Patient";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("patient_id"));
                patient.setFname(rs.getString("F_name"));
                patient.setLname(rs.getString("L_name"));
                patient.setDoj(rs.getString("Doj"));
                patient.setDept(rs.getString("Dept"));
                patient.setAddr(rs.getString("addr"));
                patient.setPhone(rs.getString("P_no"));
                patient.setSex(rs.getString("gender"));
                patient.setDob(rs.getString("Dob"));
                
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public void updatePatient(Patient patient) {
        //Connection conn = JDBCConection.getConnection();
        Connection conn = dao.JDBCConection.getConnection();
        String sql = "update Patient set F_name = ?, L_name = ?, Doj = ?, Dept = ?, addr = ?, P_no = ?, gender = ?, Dob = ?, = ? where patient_id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            
            pStatement.setString(1, patient.getFname());
            pStatement.setString(2, patient.getLname());
            pStatement.setString(3, patient.getDoj());
            pStatement.setString(4, patient.getDept());
            pStatement.setString(5, patient.getAddr());
            pStatement.setString(6, patient.getPhone());
            pStatement.setString(7, patient.getSex());
            pStatement.setString(8, patient.getDob());
            pStatement.setInt(10, patient.getId());
            
            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
        }
    }
    
    public void deletePatient(int id) {
        Connection conn = JDBCConection.getConnection();
        String sql = "delete from Patient where patient_id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            int rs = pStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
    
    public void addPatient(Patient patient) {
        Connection conn = JDBCConection.getConnection();
        String sql = "insert into Patient(patient_id ,F_name ,L_name,Doj ,Dept ,addr ,P_no ,gender ,Dob ) values(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, patient.getId());
            pStatement.setString(2, patient.getFname());
            pStatement.setString(3, patient.getLname());
            pStatement.setString(4, patient.getDoj());
            pStatement.setString(5, patient.getDept());
            pStatement.setString(6, patient.getAddr());
            pStatement.setString(7, patient.getPhone());
            pStatement.setString(8, patient.getSex());
            pStatement.setString(9, patient.getDob());

            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
        }
    }
    
    public Patient getPatientsById(int id) {
        
        Connection conn = JDBCConection.getConnection();
        String sql = "select * from Patient where patient_id = ?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                
                patient.setId(rs.getInt("patient_id"));
                patient.setFname(rs.getString("F_name"));
                patient.setLname(rs.getString("L_name"));
                patient.setDoj(rs.getString("Doj"));
                patient.setDept(rs.getString("Dept"));
                patient.setAddr(rs.getString("addr"));
                patient.setPhone(rs.getString("P_no"));
                patient.setSex(rs.getString("gender"));
                patient.setDob(rs.getString("Dob"));
                
                return patient;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}