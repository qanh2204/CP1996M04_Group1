/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Windows
 */
public class Main {

    public static void main(String[] args) {
        Login_Form login = new Login_Form();
        login.setTitle("Sign in");
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

}
