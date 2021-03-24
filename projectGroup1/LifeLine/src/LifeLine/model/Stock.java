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
public class Stock {

    private int id, icost,dnum,inum ;
    private String iname;

    public Stock(int id, int icost, int dnum, int inum, String iname) {
        this.id = id;
        this.icost = icost;
        this.dnum = dnum;
        this.inum = inum;
        this.iname = iname;
    }

    public Stock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcost() {
        return icost;
    }

    public void setIcost(int icost) {
        this.icost = icost;
    }

    public int getDnum() {
        return dnum;
    }

    public void setDnum(int dnum) {
        this.dnum = dnum;
    }

    public int getInum() {
        return inum;
    }

    public void setInum(int inum) {
        this.inum = inum;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    
}
