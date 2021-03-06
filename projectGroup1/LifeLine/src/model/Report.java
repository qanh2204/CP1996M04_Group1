/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Windows
 */
public class Report {

    private int patient_id, test_id;
    private String report;
    private Date dayAdd;

    public Report() {
    }

    public Report(int patient_id, int test_id, String report, Date dayAdd) {
        this.patient_id = patient_id;
        this.test_id = test_id;
        this.report = report;
        this.dayAdd = dayAdd;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Date getDayAdd() {
        return dayAdd;
    }

    public void setDayAdd(Date dayAdd) {
        this.dayAdd = dayAdd;
    }

}
