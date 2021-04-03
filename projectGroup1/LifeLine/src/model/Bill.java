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
public class Bill {
    private int bill_no, patient_id, amount;
    private Date dayBuy;

    public Bill(int bill_no, int patient_id, int amount, Date dayBuy) {
        this.bill_no = bill_no;
        this.patient_id = patient_id;
        this.amount = amount;
        this.dayBuy = dayBuy;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(Date dayBuy) {
        this.dayBuy = dayBuy;
    }
    
    
}
