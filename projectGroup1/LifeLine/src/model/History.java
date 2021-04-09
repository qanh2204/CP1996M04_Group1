/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;


public class History {
    private int STT;
    private String ID;
    private Date current_day;

    public History(int STT, String ID, Date current_day) {
        this.STT = STT;
        this.ID = ID;
        this.current_day = current_day;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getCurrent_day() {
        return current_day;
    }

    public void setCurrent_day(Date current_day) {
        this.current_day = current_day;
    }

    
    
}
