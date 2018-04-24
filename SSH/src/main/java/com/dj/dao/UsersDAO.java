package com.dj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dj.entity.Users;

public class UsersDAO {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<Users> getAllUser(){
        String hsql="from tb_employee";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);        
        return query.list();
    }
    
    public void AddUser(Users user)
    {
    	sessionFactory.getCurrentSession().save(user);              
    }
}
