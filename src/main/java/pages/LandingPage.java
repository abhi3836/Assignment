package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class LandingPage {

	private AppiumDriver driver = null;

	public LandingPage(AppiumDriver driver)
	{
		this.driver = driver;
	}

	public static final String RANDOM_PAGE_TITLE = "com.vasilchenko.randomfree:id/title_app";
	public static final String GENERATE_NUMBER_TEXT = "com.vasilchenko.randomfree:id/number";

	public boolean verifyRandomPageTilePresences()
	{
		boolean flag = false;
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElementById(RANDOM_PAGE_TITLE)));
			flag = true;
		}catch(ElementNotVisibleException e)
		{
			flag = false;
		}catch (TimeoutException te) {
			flag = false;
		}
		return flag;
	}

	public boolean verifyGenerateNumberTextPresences()
	{
		boolean flag = false;
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);	
			wait.until(ExpectedConditions.visibilityOf(driver.findElementById(GENERATE_NUMBER_TEXT)));
			flag = true;
		}catch(ElementNotVisibleException e)
		{
			flag = false;
		}catch (TimeoutException te) {
			flag = false;
		}
		return flag;
	}

}
