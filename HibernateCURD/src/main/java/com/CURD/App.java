package com.CURD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    { 	
    	Configuration cfg =new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	Session session= factory.openSession();
    	Transaction tx= session.beginTransaction();
    	
    	Student s1=new Student();
    	s1.setName("Ram");
    	s1.setCity("Pune");
    	s1.setAge(30);
    	
    	Student s2=new Student();
    	s2.setName("Sham");
    	s2.setCity("Nashik");
    	s2.setAge(25);
    	
    	Student s3=new Student();
    	s3.setName("Sita");
    	s3.setCity("Mumbai");
    	s3.setAge(30);
    	
    	session.persist(s1);
    	session.persist(s2);
    	session.persist(s3);
    	
    	//Retrive data
    	Student sRead1= session.get(Student.class, 1);
    	System.out.println("Name is: "+sRead1.getName());
    	System.out.println("Age is: "+sRead1.getAge());
    	System.out.println("City is: "+sRead1.getCity());
    	
    	System.out.println("============================");
    	
    	Student sRead2= session.get(Student.class, 2);
    	System.out.println("Name is: "+sRead2.getName());
    	System.out.println("Age is: "+sRead2.getAge());
    	System.out.println("City is: "+sRead2.getCity());
    	
    	System.out.println("============================");
    	
    	// Update data
    	Student sUpdate1= session.get(Student.class, 1);
    	sUpdate1.setName("gita");
    	sUpdate1.setCity("Delhi");
    	sUpdate1.setAge(30);
    	System.out.println("Update Successful.......");
    	
    	System.out.println("============================");
    	
    			
    	//Delete data
    	Student sDelete1= session.get(Student.class, 1);
    	session.remove(sDelete1);
    	System.out.println("Deleted Successfully......");
    	
    	System.out.println("============================");

    	
    	tx.commit();
    	session.close();
    	
    }
}
