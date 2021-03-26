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
    
    public UserService(){
        userDao = new UserDao();
    }
    
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    
    public void addUser(User user){
        userDao.addUser(user);
    }
    
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
    
    public User getUserById(int id){
        return userDao.getUsersById(id);
    }
    
    public void updateUser(User user){
        userDao.updateUser(user);
    }
    
    public String getType(String user, String pass){
        return userDao.getType(user, pass);
    }
}
