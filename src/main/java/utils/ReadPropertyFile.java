package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	
	public static String readFile(String key) throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();
		
		prop.load(new FileInputStream("./staticdatas.properties"));
		return prop.getProperty(key);
		
	}

}
