/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import dao.DoctorDao;
import model.Doctor;

/**
 *
 * @author qanh2
 */
public class DoctorService {
    private DoctorDao doctorDao;
    
    public DoctorService(){
        doctorDao = new DoctorDao();
    }
    
    public List<Doctor> getAllDoctors(){
        return doctorDao.getAllDoctors();
    }
    
    public void addDoctor(Doctor doctor){
        doctorDao.addDoctor(doctor);
    }
    
    public void deleteDoctor(int id){
        doctorDao.deleteDoctor(id);
    }
    
    public Doctor getDoctorById(int id){
        return doctorDao.getDoctorsById(id);
    }
    
    public void updateDoctor(Doctor doctor){
        doctorDao.updateDoctor(doctor);
    }
    
    public List<String> getAllDoctor(){
        return doctorDao.findName();
    }
    
    public int getID(String name){
        return doctorDao.findID(name);
    }
}
