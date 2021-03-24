/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LifeLine.model;

/**
 *
 * @author qanh2
 */
public class Patient {

    private int id, bill ;
    private String fname, lname, addr, test, dept, sex, doj, dob, phone;

    public Patient(int id, int bill, String fname, String lname, String addr, String test, String dept, String sex, String doj, String dob, String phone) {
        this.id = id;
        this.bill = bill;
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.test = test;
        this.dept = dept;
        this.sex = sex;
        this.doj = doj;
        this.dob = dob;
        this.phone = phone;
    }

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
    

   
}
