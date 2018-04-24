package com.dj;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StoreData {
	public static void main(String[] args) {
        Session session = HibernateUtils.getCurrentSession();
        
		addEmployee(session);	
//		select(session);
//		queryCuseromeFromIdToHQL(102, session);
//        queryPageHql(session);
	}
	
	//查询所有数据
    public static void select(Session session){
    	Transaction tx = session.beginTransaction();
        /**
         * 使用session对象的createQuery方法创建Query对象。
         * 参数为hql语句
         * 使用QUERY对象的list方法获取数据集合
         */
        Query query =session.createQuery("from Employee");
        List<Employee> list = query.list();
        //使用forEach遍历集合
        for (Employee userEntity : list) {
            System.out.println(userEntity.getFirstName()+":"+userEntity.getLastName());
        }
        tx.commit();      
        session.close();
    }
    
    //插入一条数据
    private static void addEmployee(Session session)
    {    	        
         Transaction t=session.beginTransaction();  
         
         Employee e1=new Employee();
         e1.setFirstName("晓翠");
         e1.setLastName("度");

         session.persist(e1);//persisting the object  

         t.commit();//transaction is committed  
         session.close();  

         System.out.println("successfully saved");  
    }
   
    //通过 id 来查询单个数据
    public static void queryCuseromeFromIdToHQL(int id, Session session) {       
        Transaction tx = session.beginTransaction();
        //创建 hql
        Employee customer =(Employee) session.createQuery("from Employee c where c.id = "+ id).uniqueResult();
        System.out.println(customer.getFirstName());
        tx.commit();
        session.close();
    }
    
  //通过 HQL 分页查询 
    public static void queryPageHql(Session session) {       
    	Transaction tx = session.beginTransaction();

        //1 hql , 不能手动设置limit
        List<Employee> allCustomer = session.createQuery("from Employee")
            .setFirstResult(2)//查询的页数
            .setMaxResults(3)//每页查询的个数
            .list();
        for(Employee e:allCustomer)
        {
        	System.out.println(e.getFirstName()+":"+e.getLastName());
        }
        tx.commit();
        session.close();
    }
    
}
