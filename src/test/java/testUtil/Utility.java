package testUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import bsh.util.Util;

public class Utility {
		
	private String username="john", password="test123";
	
	private final int WAIT_TIME = 20;
	private final int POLL_TIME = 5;
	private Properties properties = null;
	private final String PropFilePath = System.getProperty("user.dir")+"/configuration/config.properties";
	private final String ExcelBasePath = System.getProperty("user.dir") + this.propertiesFile(this.getPropFilePath()).getProperty("excelBasePath");
	private final String FeatureFilePath = System.getProperty("user.dir") + this.propertiesFile(this.getPropFilePath()).getProperty("featureFilePath");

	public String getFeatureFilePath() {
		return FeatureFilePath;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public int getWAIT_TIME() {
		return WAIT_TIME;
	}
	public int getPOLL_TIME() {
		return POLL_TIME;
	}
	public String getPropFilePath() {
		return PropFilePath;
	}
	public String getExcelBasePath() {
		return ExcelBasePath;
	}
	
	public Properties propertiesFile(String propFilePath) {
		properties = new Properties();
		FileInputStream file;
			
		try {
			file = new FileInputStream(propFilePath);
			properties.load(file);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		return properties;
	}
	



}
