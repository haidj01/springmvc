package com.dkim.springmvc.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class ReportDaoImpl implements ReportDao {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public byte[] getReport(String jrxmlFileName, String xmlFileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
