/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeLine.service;

import java.util.List;
import LifeLine.DAO.StaffDao;
import LifeLine.model.Staff;

/**
 *
 * @author qanh2
 */
public class StaffService {
    private StaffDao staffDao;
    
    public StaffService(){
        staffDao = new StaffDao();
    }
    
    public List<Staff> getAllStaffs(){
        return staffDao.getAllStaffs();
    }
    
    public void addStaff(Staff staff){
        staffDao.addStaff(staff);
    }
    
    public void deleteStaff(int id){
        staffDao.deleteStaff(id);
    }
    
    public Staff getStaffById(int id){
        return staffDao.getStaffsById(id);
    }
    
    public void updateStaff(Staff staff){
        staffDao.updateStaff(staff);
    }
}