package com.Galaxy.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.Galaxy.dto.AccountDTO;

public class AccountService {
	
	
	public static void add(AccountDTO dto){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);
		tx.commit();

		session.close();
		System.out.println("Account is added");
	}
	
	public static void update(AccountDTO dto){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.update(dto);
		tx.commit();

		session.close();
		System.out.println("Account is updated");
	}

	public static void delete(AccountDTO dto){
		System.out.println("Account is Deleted");
	}

	public static AccountDTO get(int id){
		/*SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		AccountDTO dto=(AccountDTO)session.get(AccountDTO.class, id);*/
		System.out.println("Account is got");
		return new AccountDTO();
	}

}
