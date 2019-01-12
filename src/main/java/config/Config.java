package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class Config {
	
	public static String PLATFORM = "";
	
	static{
		try {
			initializeEnvDetails();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static void initializeEnvDetails() throws Exception {
		Properties envConfig = new Properties();
		InputStream input1 = new FileInputStream("config.properties");
		envConfig.load(input1);
		PLATFORM = envConfig.getProperty("platform");
	}
}