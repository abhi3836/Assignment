package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

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
	
	public void closeDriver()
	{
		driver.close();
	}

	public AppiumDriver createAppiumDriverInstance(String platform) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//Configuration for Android
		if(platform.equalsIgnoreCase("android"))
		{
			//driver = new AndroidDriver(service.getUrl(), setAndroidCapabilities(capabilities));
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), setAndroidCapabilities(capabilities));
		}
		//Configuration for IOS
		else if(platform.equalsIgnoreCase("ios"))
		{
			driver = new IOSDriver(service, setIOSCapabilities(capabilities));
		}
		else{
			System.out.println("No Device Type provided in config property file");
			System.exit(0);
		}
		return driver;
	}

	private DesiredCapabilities setAndroidCapabilities(DesiredCapabilities capabilities )
	{
		try{
			Properties envConfig = new Properties();
			InputStream input1 = new FileInputStream("config_android.properties");
			envConfig.load(input1);
			String path = System.getProperty("user.dir")+"/"+envConfig.getProperty("apk_path");
			capabilities.setCapability("noReset", envConfig.getProperty("noReset"));
			capabilities.setCapability("fullReset", envConfig.getProperty("fullReset"));
			capabilities.setCapability("deviceName", envConfig.getProperty("deviceName"));
			capabilities.setCapability("platformVersion", envConfig.getProperty("platformVersion"));
			capabilities.setCapability("platformName", envConfig.getProperty("platformName"));
			capabilities.setCapability("app", path);
			capabilities.setCapability("appPackage", envConfig.getProperty("appPackage"));
			capabilities.setCapability("appActivity", envConfig.getProperty("appActivity"));
			return capabilities;
		}catch(Exception e)
		{
			System.out.println("Error Log :: Problem in setting capability "+e.getMessage());
		}
		return capabilities;
	}
	
	private DesiredCapabilities setIOSCapabilities(DesiredCapabilities capabilities )
	{
		try{
			Properties envConfig = new Properties();
			InputStream input1 = new FileInputStream("config_ios.properties");
			envConfig.load(input1);
			String path = System.getProperty("user.dir")+"/"+envConfig.getProperty("app_path");
			capabilities.setCapability("platformName", envConfig.getProperty("platformName"));
			capabilities.setCapability("platformVersion", envConfig.getProperty("platformVersion")); 
			capabilities.setCapability("deviceName", envConfig.getProperty("deviceName")); 
			//capabilities.setCapability("bundleid", envConfig.getProperty("bundleid"));
			capabilities.setCapability("app", path);
			return capabilities;
		}catch(Exception e)
		{
			System.out.println("Error Log :: Problem in setting capability "+e.getMessage());
		}
		return capabilities;
	}
}
