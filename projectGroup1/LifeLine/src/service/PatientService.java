/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import dao.PatDao;
import model.Patient;

/**
 *
 * @author qanh2
 */
public class PatientService {
    private PatDao patientDao;
    
    public PatientService(){
        patientDao = new PatDao();
    }
    
    public List<Patient> getAllPatients(){
        return patientDao.getAllPatients();
    }
    
    public void addPatient(Patient patient){
        patientDao.addPatient(patient);
    }
    
    public void deletePatient(int id){
        patientDao.deletePatient(id);
    }
    
    public Patient getPatientById(int id){
        return patientDao.getPatientsById(id);
    }
    
    public void updatePatient(Patient patient){
        patientDao.updatePatient(patient);
    }
}
