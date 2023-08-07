package com.practice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entites.Student;

public class HQLExample {
public static void main(String[] args) {
	SessionFactory f=new Configuration().configure().buildSessionFactory();
	//creating query
	//String query="from Student";
	//String query="from Student where name='Sandeep Kumar'";
	//now for the dynamic valuee based query
	String query="from Student as s where s.name=:x and s.course=:y";


	
	//for firring query have to creating session object
	Session s=f.openSession();
	
	Query q=s.createQuery(query);
	q.setParameter("x", "Sandeep Kumar");
	q.setParameter("y", "B.Tech");
	
	
	//single object return use unique method
	//multiple object return use list method
	List<Student>list=q.list();
	
	for(Student student:list) {
		System.out.println(student);
		
	}
	System.out.println("---------------------------------------------------");
	Transaction tx=s.beginTransaction();
//	this is delete query
//		String query1="delete from Student as s where s.name=:x";
//		Query q2=s.createQuery(query1);
//		q2.setParameter("x","Sandeep Kumar");
//		int r=q2.executeUpdate();

//		System.out.println("deleted");
//		System.out.println(r);
		
		//updation query
		
		String query1="update Student set course=:x where name=:y";
		
		Query q1=s.createQuery(query1);
		q1.setParameter("x","M.Tech");
		q1.setParameter("y", "Shiva Savita");
		int r=q1.executeUpdate();
		tx.commit();
		System.out.println("done..!");
		System.out.println(r);
		s.close();
		f.close();
		
		
}
}
