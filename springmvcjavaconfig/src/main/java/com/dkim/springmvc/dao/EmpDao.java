package com.dkim.springmvc.dao;

import java.util.List;

import com.dkim.springmvc.model.Emp;
import com.dkim.springmvc.model.EmpDetail;

public interface EmpDao {
	void addEmp( Emp emp );
	void addEmpDetail(EmpDetail empDetail);
	List<Emp> getEmp();
}
