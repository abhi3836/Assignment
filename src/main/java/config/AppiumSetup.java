package config;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumSetup {
	
	private  AppiumDriverLocalService service;
	private  AppiumDriver driver;
	
	public void startAppiumServer()
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	public void stopAppiumServer()
	{
		service.stop();
	}
	
	public AppiumDriver createAppiumDriverInstance(String deviceType,String appPath)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//Configuration for Android
		if(deviceType.equalsIgnoreCase("android"))
		{
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			capabilities.setCapability(MobileCapabilityType.APP, appPath);
			driver = new AndroidDriver(service.getUrl(), capabilities);
		}
		//Configuration for IOS
		else if(deviceType.equalsIgnoreCase("ios"))
		{
			
		}
		else{
			System.out.println("No Device Type provided in config property file");
			System.exit(0);
		}
		return driver;
	}
	
	
	public static void main(String ars[])
	{
		
	}

}
