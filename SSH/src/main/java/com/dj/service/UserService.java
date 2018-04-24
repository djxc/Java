package com.dj.service;

import java.util.List;

import com.dj.dao.UsersDAO;
import com.dj.entity.Users;

public class UserService {
private UsersDAO userDao;
    
    public int userCount(){
    	List<Users> list = userDao.getAllUser();    	
        return list.size();
    }
    
    public void addUser(Users user)
    {
    	userDao.AddUser(user);
    }
    
    public List<Users> getAllUser()
    {
    	List<Users> list = userDao.getAllUser();
    	return list;
    }
    
    public UsersDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UsersDAO userDao) {
        this.userDao = userDao;
    }
}
