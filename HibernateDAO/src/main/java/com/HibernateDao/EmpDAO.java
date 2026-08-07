package com.HibernateDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Employee;
import com.Utility.HIbernateUtiles;

public class EmpDAO implements EmpInterface {

	
	public void InsertData(Employee employe) {
		Session session =HIbernateUtiles.factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.persist(employe);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Employee> getEmployes() {
		Session session =HIbernateUtiles.factory.openSession();
		Transaction tx=session.beginTransaction();
		
		List<Employee> list = session.createQuery(" From Employee").list();
		
		return list;
	}

	@Override
	public Employee getEmployee(int id) {
		Session session =HIbernateUtiles.factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee employe= session.get(Employee.class, id);
		
		tx.commit();
		session.close();
		return employe;
		
	}

	@Override
	public void updateData(Employee employe) {
		Session session =HIbernateUtiles.factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.merge(employe);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public void deleteData(int id) {
		Session session =HIbernateUtiles.factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee employe= session.get(Employee.class, id);
		if(employe != null) {
			session.remove(employe);
		}
		tx.commit();
		session.close();
		
	}
}
