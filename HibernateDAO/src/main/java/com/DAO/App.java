package com.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Entity.Employee;
import com.HibernateDao.EmpDAO;
import com.HibernateDao.EmpInterface;

public class App 
{
    public static void main( String[] args )
    {
    	EmpInterface dao= new EmpDAO();
    	
    	Employee e1= new Employee();
    	e1.setName("John");
    	e1.setCity("Pune");
    	e1.setAge(35);
    	
    	Employee e2= new Employee();
    	e2.setName("Ram");
    	e2.setCity("Pune");
    	e2.setAge(30);
    	
    	Employee e3= new Employee();
    	e3.setName("Sham");
    	e3.setCity("Mumbai");
    	e3.setAge(40);
    	
    	dao.InsertData(e1);
    	dao.InsertData(e2);
    	dao.InsertData(e3);

    	
    	// Retrive Data
    	Employee eRead= new Employee();
    	List<Employee> list= dao.getEmployes();
    	for(Employee elist: list) {
    		System.out.println("ID is: "+ elist.getId());
    		System.out.println("Name is: "+ elist.getName());
    		System.out.println("Age is: "+ elist.getAge());
    		System.out.println("City is: "+ elist.getCity());
    		System.out.println("=============================");
    	}
    	
    	
    	// Retrive Single Data
    	Employee eRead1= dao.getEmployee(1);
    	System.out.println("Id is : "+eRead1.getId());
    	System.out.println("Name is : "+eRead1.getName());
    	System.out.println("Age is : "+eRead1.getAge());
    	System.out.println("City is : "+eRead1.getCity());
    	System.out.println("==============================");
    	
    	// Update Data
    	Employee eUpdate =new Employee();
    	eUpdate.setName("Atherva");
    	eUpdate.setAge(23);
    	eUpdate.setCity("Baramati");
    	eUpdate.setId(3);
    	dao.updateData(eUpdate);
    	System.out.println("Update Successfully....");
    	System.out.println("==============================");
    	
    	// Delete Data
    	Employee eDelete =new Employee();
    	dao.deleteData(2);
    	System.out.println("Deleted Successfully....");
    	System.out.println("==============================");
    }
}
