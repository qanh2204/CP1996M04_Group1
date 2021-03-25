/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeLine.model;

/**
 *
 * @author Windows
 */
public class Bill {
    private int bill_no, patient_id, test_id, amount;

    public Bill(int bill_no, int patient_id, int test_id, int amount) {
        this.bill_no = bill_no;
        this.patient_id = patient_id;
        this.test_id = test_id;
        this.amount = amount;
    }

    public int getBill_no() {
        return bill_no;
    }

    public void setBill_no(int bill_no) {
        this.bill_no = bill_no;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
