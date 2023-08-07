package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entites.Student;

public class SaveData {
public static void main(String[] args) {
	SessionFactory f=new Configuration().configure().buildSessionFactory();
	
	Student s=new Student();
	s.setId(117);
	s.setName("AJ Kushwaha");
	s.setCourse("B.Tech");
	
	Session s1=f.openSession();
	Transaction tx=s1.beginTransaction();
	s1.save(s);
	tx.commit();
	System.out.println("Summited");
	s1.close();
	f.close();
	
}
}
