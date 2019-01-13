package testcases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.BeforeSuite;
import config.AppiumSetup;

public class BaseTest {
	
	public static String PLATFORM = "";
	protected AppiumSetup setup;
	
	@BeforeSuite
	public void setConfiguration()
	{
		try {
			setup = new AppiumSetup();
			setup.startAppiumServer();
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
	
	@BeforeSuite
	public void endConfiguration()
	{
		setup.stopAppiumServer();
	} 
	
	
}