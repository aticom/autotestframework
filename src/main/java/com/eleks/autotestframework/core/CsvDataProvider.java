package com.eleks.autotestframework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class CsvDataProvider {
	
	@DataProvider(name = "CsvDataProvider")
	public static Iterator<Object[]> provideData(Method method){
		
		List<Object[]> list = new ArrayList<Object[]>();
		String pathName = "test_data" + File.separator + method.getDeclaringClass().getSimpleName() + "." + method.getName() + ".csv";
		File file = new File(pathName);
		try {
			
			CSVReader reader = new CSVReader(new FileReader(file)); //windows
			//CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file), "UTF-16")); //ubuntu
			
			String[] keys = reader.readNext();
			if (keys != null){
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null){
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					list.add(new Object[]{testData});
				}
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathName + " was not found.\n" + e.getStackTrace().toString() );
		} catch (IOException e){
			throw new RuntimeException("couldn't read " + pathName + " file.\n" + e.getStackTrace().toString() );
		}
		
		return list.iterator();
	}

}
