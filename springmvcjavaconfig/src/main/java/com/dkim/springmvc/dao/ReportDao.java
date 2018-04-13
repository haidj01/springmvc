package com.dkim.springmvc.dao;

public interface ReportDao {
	 byte[] getReport(String jrxmlFileName, String xmlFileName);
}
