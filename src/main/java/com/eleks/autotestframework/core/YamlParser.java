package com.eleks.autotestframework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageInputStream;

import org.yaml.snakeyaml.Yaml;

public class YamlParser {
	
	private static final String CONFIG_ROOT_HOME_PATH = "config/";
	private final String fileName;
	public YamlParser(String fileName) {
		this.fileName = fileName;
	}
	
	public <T> T parseAs(Class<T> type) {
		T object;
		try{
		InputStream input = new  FileInputStream(new File(CONFIG_ROOT_HOME_PATH + fileName));
		Yaml yaml = new Yaml();
		object = yaml.loadAs(input, type);
		input.close();
		}catch (IOException e){
			throw new RuntimeException("could not load" + CONFIG_ROOT_HOME_PATH + fileName + " file.");
		}
		return object;
	}

}
