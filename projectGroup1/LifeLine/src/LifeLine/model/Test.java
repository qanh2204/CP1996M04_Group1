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
public class Test {
    private String  t_name;
    private int test_id,cost;

    public Test() {
    }

    public Test(int test_id, String t_name, int cost) {
        this.test_id = test_id;
        this.t_name = t_name;
        this.cost = cost;
    }
    
    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
}

