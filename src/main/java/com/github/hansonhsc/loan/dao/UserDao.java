package com.github.hansonhsc.loan.dao;


import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.github.hansonhsc.loan.model.User;




public class UserDao implements IUserDao{

	private SessionFactory sessionFactory;

	final static Logger logger = Logger.getLogger(UserDao.class);

	final static  Integer OK = 0;
	final static  Integer GIA_PRESENTE = 101;
	final static  Integer GENERIC_ERROR = 102;

	
	@Transactional
	@Override
	public List<User> getUsers() {
		List<User> ritorno = new ArrayList<User>();
		List list = null;
		try {
		list = getSessionFactory().getCurrentSession().createQuery("Select n from User as n").list();
		if (list.size()>0) {
			ritorno.addAll(list);
		}
	
		}catch (Exception e) {
			// TODO: handle exception
		}
				return ritorno;
		
	}
	
	@Transactional
	@Override
	public User getUserByUsername(String username) {
		
		List<User> ritorno = new ArrayList<User>();
		
		List list = null;
		try {
			
		list = getSessionFactory().getCurrentSession().createQuery("Select n from User as n where username =:param").setParameter("param", username).list();
		if (list.size()>0) {
			
			ritorno.addAll(list);
		}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
				return ritorno.get(0);
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
