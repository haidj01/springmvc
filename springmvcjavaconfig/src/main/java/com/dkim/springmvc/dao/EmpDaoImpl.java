package com.dkim.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.dkim.springmvc.model.Emp;
import com.dkim.springmvc.model.EmpDetail;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmpDetail(EmpDetail empDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Emp> getEmp() {
		Session session =sessionFactory.openSession();
		List<Emp> resultList = session.createQuery("From Emp").list();
		session.flush();
 		return resultList;
		
	}

}
