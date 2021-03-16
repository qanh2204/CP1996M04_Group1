/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifeLine.service;

import java.util.List;
import lifeLine.DAO.UserDao;
import lifeLine.model.User;

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
}
