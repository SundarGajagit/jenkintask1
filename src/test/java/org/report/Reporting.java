package org.report;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void genReport(String jsonFile) {
		File file=new File("C:\\Users\\Dell\\eclipse-workspace\\"
				+ "CucumberProj\\src\\test\\resources\\Reports");
		
	Configuration config=new Configuration(file, "Instalogin");
	
	config.addClassifications("OS", "Windows 10");
	config.addClassifications("Browser", "Chrome");
	config.addClassifications("Version", "101.0.4951.54");
	config.addClassifications("Sprint", "22");
	config.addClassifications("Test", "Insta Login Test");
	
	ArrayList<String> jsonFiles= new ArrayList<String>();
	jsonFiles.add(jsonFile);
	
	ReportBuilder builder= new ReportBuilder(jsonFiles, config);
	
	builder.generateReports();
	
	
	
		
	}
}
