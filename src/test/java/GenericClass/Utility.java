package GenericClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

	public static String getValue(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
