package utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Property {

	static FileReader fr;
	static Properties propertiesFile;
	public static String get(String key)
	{
		File file = new File("./src/main/java/config/config.properties");
		String value = null;
		try
		{
			fr = new FileReader(file);
			propertiesFile = new Properties();
			propertiesFile.load(fr);
			value = propertiesFile.getProperty(key);
		}catch(Exception e)
		{
			System.out.println("Got an error while fetching the data from property file");
		}
		return value;
	}
}
