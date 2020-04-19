package com.github.hansonhsc.loan.dao;


import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.github.hansonhsc.loan.model.Lender;




public class LenderDao implements ILenderDao{

	private SessionFactory sessionFactory;

	final static Logger logger = Logger.getLogger(LenderDao.class);


	
	@Transactional
	@Override
	public List<Lender> getLenders() {
		List<Lender> ritorno = new ArrayList<Lender>();
		List list = null;
		try {
		list = getSessionFactory().getCurrentSession().createQuery("Select n from Lender as n").list();
		if (list.size()>0) {
			ritorno.addAll(list);
		}
	
		}catch (Exception e) {
			// TODO: handle exception
		}
				return ritorno;
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
