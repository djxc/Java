package com.dj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	 //提供一个工厂 (链式操作)
    private static SessionFactory factory = 
        new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();

    /**
     * 获得线程绑定的session
     * @return
     */
    public static Session getCurrentSession(){
    	return factory.openSession();
    }		
}
