package testcases;

import io.appium.java_client.AppiumDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import config.AppiumSetup;

public class AppLaunchTest extends BaseTest {

	private AppiumDriver driver = null;
	
	@BeforeMethod
	public void intialize()
	{
		try {
			driver = setup.createAppiumDriverInstance(PLATFORM);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Test to verify presence of landing page
	 */
	@Test
	public void verifyAppLaunch(){
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.verifyRandomPageTilePresences());
		Assert.assertTrue(landingPage.verifyGenerateNumberTextPresences());
	}
	
	@AfterMethod
	public void close()
	{
		setup.closeDriver();
	}
	
}
