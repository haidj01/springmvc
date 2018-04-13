package com.dkim.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dkim.springmvc.dao.EmpDao;
import com.dkim.springmvc.model.Emp;

@Repository
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Emp> getEmp() {
		
		return empDao.getEmp();
	}

}
