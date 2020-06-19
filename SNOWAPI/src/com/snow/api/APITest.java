package com.snow.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class APITest {

	public static void main(String[] args) throws IOException {

		Properties prop = readPropertiesFile("resources/snow.properties");
		System.out.println("endpint.url.dev: " + prop.getProperty("endpint.url.dev"));
		System.out.println("endpint.url.prod: " + prop.getProperty("endpint.url.prod"));

		String envDev = System.getProperty("env.dev");
		String envProd = System.getProperty("env.prod");

		System.out.println(envDev);
		System.out.println(envProd);
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

}
