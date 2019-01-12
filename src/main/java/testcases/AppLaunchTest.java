package testcases;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import config.AppiumSetup;
import config.Config;

public class AppLaunchTest extends Config {

	private AppiumDriver driver = null;
	private AppiumSetup setup;
	
	@BeforeMethod
	public void intialize()
	{
		setup = new AppiumSetup();
		try {
			driver = setup.createAppiumDriverInstance(PLATFORM);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyAppLaunch(){
		
	}
	
	@AfterMethod
	public void close()
	{
		setup.closeDriver();
		setup.stopAppiumServer();
	}
	
}
