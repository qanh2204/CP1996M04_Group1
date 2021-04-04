/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author qanh2
 */
public class User {

    private String id;
    private String user;
    private String pass;
    private String type;
    private String fakePass = "********";
    

    public User(String id, String user, String pass, String type) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.type = type;
    }

    public User() {
    }

    public String getFakePass() {
        return fakePass;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
