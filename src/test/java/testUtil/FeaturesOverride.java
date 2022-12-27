package testUtil;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class FeaturesOverride {
	
	public void overrideAllFiles(String featureFilePath, String excelBasePath) {
		FeaturesOverride feat = new FeaturesOverride();
		
		File folder = new File(featureFilePath);

		String[] files = folder.list();
 
        for (String file : files) {
        	feat.featureFileOverride(featureFilePath + file, excelBasePath);
        }
	}
	
	public void featureFileOverride(String featFileName, String excelBasePath){
		String line = "";
		String ll;
		String scenName = "";
		String featFile = featFileName;

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(featFile)), "UTF-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
				
		try {
			while((ll = br.readLine()) != null) {
				
				//get scenario name from .feature file
				if(ll.contains("Scenario Outline")) {
					scenName = ll.split(":")[1].trim();
				}
				//get excel sheet and sheet name			
				if(ll.contains("##")) {
					String wbPath = excelBasePath+"/";
					wbPath += ll.split("##")[1].split("@")[0].trim();
					String sheetName = ll.split("@")[1].trim();
					line += ExcelUtil.readExcel(scenName, wbPath, sheetName);
				}
				else {
					line += ll + "\n";				
				}
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(featFile, false), "UTF-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			bw.write(line);
			br.close();
			bw.close();
		} catch (IOException e) {
 			e.printStackTrace();
		}
	}

}
