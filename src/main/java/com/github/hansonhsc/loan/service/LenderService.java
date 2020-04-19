package com.github.hansonhsc.loan.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.hansonhsc.loan.dao.ILenderDao;
import com.github.hansonhsc.loan.model.Lender;



@Transactional
public class LenderService implements LenderServiceInterface {


	ILenderDao LenderDao;



	@Transactional
	public List<Lender> getLenders(){
		return getLenderDao().getLenders();
	}


	public ILenderDao getLenderDao() {
		return LenderDao;
	}


	public void setLenderDao(ILenderDao lenderDao) {
		LenderDao = lenderDao;
	}

}



