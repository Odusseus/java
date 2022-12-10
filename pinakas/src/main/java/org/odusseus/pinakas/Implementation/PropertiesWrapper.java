package org.odusseus.pinakas.Implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.odusseus.pinakas.Interface.PropertiesWrapperInterface;

public class PropertiesWrapper implements PropertiesWrapperInterface {
	
	@Override
	public String getProperty(String key) 
	{
		Properties properties = new Properties();
		String fileName = "config.properties";
		try (FileInputStream fis = new FileInputStream(fileName)) {
			properties.load(fis);
		    return properties.getProperty(key);
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("IOException " + ex.getMessage());
		}
		return null;		
	}
}
