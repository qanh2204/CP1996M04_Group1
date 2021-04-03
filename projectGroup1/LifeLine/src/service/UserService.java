/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import dao.UserDao;
import model.User;

/**
 *
 * @author qanh2
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    public User getUserById(String id) {
        return userDao.getUsersById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public String getType(String user, String pass) {
        return userDao.getType(user, pass);
    }

    public List<String> getIdUserForStaff() {
        return userDao.getIdUsersForStaff();
    }

    public List<String> getIdUserForDoctor() {
        return userDao.getIdUsersForDoctor();
    }

    public void setPassword(String user, String oldpass, String newpass) {
        userDao.setPass(user, oldpass, newpass);
    }
}
