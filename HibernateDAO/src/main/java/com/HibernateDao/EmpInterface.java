package com.HibernateDao;

import java.util.List;

import com.Entity.Employee;

public interface EmpInterface {
	public void InsertData(Employee employe);
	List<Employee> getEmployes();
	public Employee getEmployee(int id);
	public void updateData(Employee employe);
	public void deleteData(int id);
}
