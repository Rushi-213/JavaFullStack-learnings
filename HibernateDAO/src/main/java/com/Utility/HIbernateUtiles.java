package com.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernateUtiles {
	
	public static SessionFactory factory;
	static {
		factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	

}
