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
import model.Staff;

/**
 *
 * @author qanh2
 */
public class StaffDao {

    public List<Staff> getAllStaffs() {
        List<Staff> staffs = new ArrayList<Staff>();
        Connection conn = dao.JDBCConection.getConnection();
        String sql = "select * from Staff";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getInt("staff_id"));
                staff.setFname(rs.getString("F_name"));
                staff.setLname(rs.getString("L_name"));
                staff.setDoj(rs.getString("Doj"));
                staff.setDept(rs.getString("Dept"));
                staff.setAddr(rs.getString("addr"));
                staff.setPhone(rs.getString("P_no"));
                staff.setSex(rs.getString("gender"));
                staff.setDob(rs.getString("Dob"));
                staff.setEdu(rs.getString("Edu_qual"));
                staff.setSkill(rs.getString("Tech_skills"));
                staff.setAccountId(rs.getString("id"));
                
                staffs.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffs;
    }

    public void updateStaff(Staff staff) {
        //Connection conn = JDBCConection.getConnection();
        Connection conn = dao.JDBCConection.getConnection();
        String sql = "update Staff set F_name = ?, L_name = ?, Doj = ?, Dept = ?, addr = ?, P_no = ?, gender = ?, Dob = ?, Edu_qual = ?, Tech_skills = ?, id = ? where staff_id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            
            pStatement.setString(1, staff.getFname());
            pStatement.setString(2, staff.getLname());
            pStatement.setString(3, staff.getDoj());
            pStatement.setString(4, staff.getDept());
            pStatement.setString(5, staff.getAddr());
            pStatement.setString(6, staff.getPhone());
            pStatement.setString(7, staff.getSex());
            pStatement.setString(8, staff.getDob());
            pStatement.setString(9, staff.getEdu());
            pStatement.setString(10, staff.getSkill());
            pStatement.setString(11, staff.getAccountId());
            pStatement.setInt(12, staff.getId());
            
            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
        }
    }
    
    public void deleteStaff(int id) {
        Connection conn = JDBCConection.getConnection();
        String sql = "delete from Staff where staff_id = ?";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            int rs = pStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
    
    public void addStaff(Staff staff) {
        Connection conn = JDBCConection.getConnection();
        String sql = "insert into Staff(staff_id ,F_name ,L_name,Doj ,Dept ,addr ,P_no ,gender ,Dob ,Edu_qual ,Tech_skills,id) values(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, staff.getId());
            pStatement.setString(2, staff.getFname());
            pStatement.setString(3, staff.getLname());
            pStatement.setString(4, staff.getDoj());
            pStatement.setString(5, staff.getDept());
            pStatement.setString(6, staff.getAddr());
            pStatement.setString(7, staff.getPhone());
            pStatement.setString(8, staff.getSex());
            pStatement.setString(9, staff.getDob());
            pStatement.setString(10, staff.getEdu());
            pStatement.setString(11, staff.getSkill());
            pStatement.setString(12, staff.getAccountId());

            int rs = pStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
        }
    }
    
    public Staff getStaffsById(int id) {
        
        Connection conn = JDBCConection.getConnection();
        String sql = "select * from Staff where staff_id = ?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                
                staff.setId(rs.getInt("staff_id"));
                staff.setFname(rs.getString("F_name"));
                staff.setLname(rs.getString("L_name"));
                staff.setDoj(rs.getString("Doj"));
                staff.setDept(rs.getString("Dept"));
                staff.setAddr(rs.getString("addr"));
                staff.setPhone(rs.getString("P_no"));
                staff.setSex(rs.getString("gender"));
                staff.setDob(rs.getString("Dob"));
                staff.setEdu(rs.getString("Edu_qual"));                
                staff.setSkill(rs.getString("Tech_skills"));
                staff.setAccountId(rs.getString("id"));
                
                return staff;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    
}