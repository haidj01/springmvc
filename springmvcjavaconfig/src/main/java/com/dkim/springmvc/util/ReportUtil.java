package com.dkim.springmvc.util;

import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportUtil {
	
	
		 public byte[] generatePdf (String jrxmlFileName, String xmlFileName,Connection conn) {
			// First, load JasperDesign from XML and compile it into JasperReport
			
			 
			 
			 // Third, get a database connection
			 
			 // Fourth, create JasperPrint using fillReport() method
			 JasperPrint jasperPrint;
			try {
				
				JasperDesign jasperDesign = JRXmlLoader.load("jrxml file path");
				JRDesignQuery query = new JRDesignQuery();
				//query replace logic
				query.setLanguage(" SELECT * FROM information_schema.columns; ");
				jasperDesign.setQuery(query);
				 
				
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				 // Second, create a map of parameters to pass to the report.
				Map parameters = new HashMap();
				parameters.put("ReportTitle", "Basic JasperReport");
				 parameters.put("MaxSalary", new Double(25000.00));
				 
				
				jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
				byte[] resut =JasperExportManager.exportReportToPdf(jasperPrint);
				return resut;
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			 // You can use JasperPrint to create PDF
			 
		 }
}
