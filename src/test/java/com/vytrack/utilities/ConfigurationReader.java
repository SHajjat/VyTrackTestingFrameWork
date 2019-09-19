package com.vytrack.utilities;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Properties;

public class ConfigurationReader {
	
	//using Properties class from Util
	private static Properties configfile;
	static{
		try {
			String path ="configuration.properties";
			FileInputStream fileInputStream = new FileInputStream(path);
			configfile = new Properties();
			configfile.load(fileInputStream);
			fileInputStream.close();
		}catch (IOException  e){
			throw  new RuntimeException("no file found in directory"+ e.getMessage());
		}
	}
	
	public static String get(String keyname){
		return configfile.getProperty(keyname);
	}
	
	public static String getProperty(String keyname){
		return configfile.getProperty(keyname);
	}
	
}
