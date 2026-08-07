package HibernateHQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class Hibernatehql {
	 public static void main( String[] args )
	    { 	
	    	Configuration cfg =new Configuration();
	    	cfg.configure("hibernate.cfg.xml");
	    	SessionFactory factory=cfg.buildSessionFactory();
	    	Session session= factory.openSession();
	    	Transaction tx= session.beginTransaction();
	    	
	    	StudentHQL s1=new StudentHQL();
	    	s1.setName("Ram");
	    	s1.setCity("Pune");
	    	s1.setAge(30);
	    	
	    	StudentHQL s2=new StudentHQL();
	    	s2.setName("Sham");
	    	s2.setCity("Nashik");
	    	s2.setAge(25);
	    	
	    	StudentHQL s3=new StudentHQL();
	    	s3.setName("Sita");
	    	s3.setCity("Mumbai");
	    	s3.setAge(30);
	    	
	    	StudentHQL s4=new StudentHQL();
	    	s4.setName("Gita");
	    	s4.setCity("Delhi");
	    	s4.setAge(32);
	    	
	    	StudentHQL s5=new StudentHQL();
	    	s5.setName("Atherva");
	    	s5.setCity("Nagpur");
	    	s5.setAge(30);
	    	
	    	session.persist(s1);
	    	session.persist(s2);
	    	session.persist(s3);
	    	session.persist(s4);
	    	session.persist(s5);
	    	
	    	//HQL
	    	String query ="from StudentHQL where id=1";
	    	Query r=session.createQuery(query);
	    	StudentHQL stu=(StudentHQL) r.uniqueResult();
	    	System.out.println(stu.getId()+"  "+stu.getName()+"  "+stu.getAge()+"  "+stu.getCity());
	    	
	    	String query1 ="from StudentHQL where city='Mumbai'";
	    	Query r1=session.createQuery(query1);
	    	StudentHQL stu1=(StudentHQL) r1.uniqueResult();
	    	System.out.println(stu1.getId()+"  "+stu1.getName()+"  "+stu1.getAge()+"  "+stu1.getCity());
	    	
	    	String query2 ="from StudentHQL where city =:c";
	    	Query r2=session.createQuery(query2);
	    	r2.setParameter("c", "Nashik");
	    	StudentHQL stu2=(StudentHQL) r2.uniqueResult();
	    	System.out.println(stu2.getId()+"  "+stu2.getName()+"  "+stu2.getAge()+"  "+stu2.getCity());
	    	
	    	
	    	//Update
	    	String query3="Update StudentHQL set name =: n where id =: i";
	    	Query r3 = session.createQuery(query3);
	    	r3.setParameter("n", "Atharva");
	    	r3.setParameter("i", "1");
	    	r3.executeUpdate();
	    	System.out.println("Updated Successfull....");
	    	
	    	
	    	//Delete
	    	String query4="Delete from StudentHQL where name =: n and id =: i";
	    	Query r4 = session.createQuery(query4);
	    	r3.setParameter("n", "Atharva");
	    	r3.setParameter("i", "1");
	    	r3.executeUpdate();
	    	System.out.println("Deleted Successfull....");
	    	
	    	
	    	session.clear(); // For Peramanent Changes in Database
	    	// Selecting 
	    	String query5 ="from StudentHQL where name like 'G%'";
	    	Query r5=session.createQuery(query5);
	    	StudentHQL stu5=(StudentHQL) r5.uniqueResult();
	    	System.out.println(stu5.getId()+"  "+stu5.getName()+"  "+stu5.getAge()+"  "+stu5.getCity());
	    	
	    	String query6 ="from StudentHQL where name like :c";
	    	Query r6=session.createQuery(query6);
	    	r6.setParameter("c", "A%");
	    	//r6.executeUpdate();
	    	List<StudentHQL> stu6=  r6.getResultList();
	    	for (StudentHQL s :stu6) {
	    	System.out.println(s.getId()+"  "+s.getName()+"  "+s.getAge()+"  "+s.getCity());
	    	}
	    	
	    	//Pagination (limits and offset)
	    	String spagenation="from StudentHQL";
	    	Query<StudentHQL> sh=session.createQuery(spagenation, StudentHQL.class);
	    	sh.setFirstResult(2);
	    	List<StudentHQL> slist=sh.list();
	    	for(StudentHQL ss: slist) {
	    		System.out.println(ss.getId()+"  "+ss.getName()+"  "+ss.getAge()+"  "+ss.getCity());
	    	}
	    	
	    	String spagenation1="from StudentHQL";
	    	Query<StudentHQL> sh1=session.createQuery(spagenation1, StudentHQL.class);
	    	sh1.setFirstResult(2);
	    	sh1.setMaxResults(2);
	    	List<StudentHQL> slist1=sh1.list();
	    	for(StudentHQL ss1: slist1) {
	    		System.out.println(ss1.getId()+"  "+ss1.getName()+"  "+ss1.getAge()+"  "+ss1.getCity());
	    	}
	    	
	    	//Native SQL
	    	NativeQuery<StudentHQL> nq=session.createNativeQuery("Select * from StudentHQL", StudentHQL.class );
	    	List<StudentHQL> l=nq.list();
	    	for(StudentHQL h: l) {
	    		System.out.println(h.getId()+"  "+h.getName()+"  "+h.getAge()+"  "+h.getCity());
	    	}
	    	
	    	NativeQuery<StudentHQL> nq1=session.createNativeQuery("Select * from StudentHQl where name like 'a%'", StudentHQL.class);
	    	List<StudentHQL> l1=nq1.list();
	    	for(StudentHQL h1: l1) {
	    		System.out.println(h1.getId()+"  "+h1.getName()+"  "+h1.getAge()+"  "+h1.getCity());
	    	}
	    	
	    	tx.commit();
	    	session.close();
	    }
}
