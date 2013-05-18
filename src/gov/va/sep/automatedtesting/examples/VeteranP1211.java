package gov.va.sep.automatedtesting.examples;

import static org.junit.Assert.assertTrue;
import gov.va.sep.automatedtesting.AutomatedTestingSuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;

public class VeteranP1211 extends AutomatedTestingSuite {
	

	
	@Test
	public void testForP1211User() throws FindFailed {

		
		logger.info(":: In Start of testForP1211User() method");
		//r.delay(5000);
		logger.info("**********Start open application************");
		driver.get(getProperties().getProperty("URL"));
		logger.info("::getting the URL from the properties file :: The URL is ::"+getProperties().getProperty("URL"));
		r.delay(7000);
		driver.manage().window().maximize();
		driver.findElement(By.name("loginId")).clear();
		driver.findElement(By.name("loginId")).sendKeys(getProperties().getProperty("userID_1211"));
		logger.info("::The UserID ::"+getProperties().getProperty("userID_1211"));
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("::The login button was clicked::");
		r.delay(5000);
		driver.findElement(By.cssSelector("strong > a")).click();
		r.delay(5000);
		driver.findElement(By.linkText("Continue")).click();
		logger.info("::The Continue button was clicked::");
		r.delay(5000);
		
		driver.findElement(By.id("date_custom")).click();
		logger.info(":: Custom Date Range Selected::");;
		r.delay(5000);
		new Select(driver.findElement(By.id("startMonth")))
				.selectByVisibleText(getProperties().getProperty("StartMonth"));
		
		r.delay(5000);
		new Select(driver.findElement(By.id("startDay")))
				.selectByVisibleText(getProperties().getProperty("StartDate"));
		r.delay(5000);
		new Select(driver.findElement(By.id("startYear")))
				.selectByVisibleText(getProperties().getProperty("StartYear"));
		logger.info("::Strat Date  is ::"+getProperties().getProperty("StartMonth")+getProperties().getProperty("StartDate")+getProperties().getProperty("StartYear"));
		r.delay(5000);
		new Select(driver.findElement(By.id("endMonth")))
				.selectByVisibleText(getProperties().getProperty("EndMonth"));
		r.delay(5000);
		new Select(driver.findElement(By.id("endDay")))
				.selectByVisibleText(getProperties().getProperty("Endday"));
		logger.info("::End Date  is ::"+getProperties().getProperty("EndMonth")+getProperties().getProperty("Endday"));
		r.delay(5000);
		driver.findElement(By.cssSelector("input.bbmi_button")).click();
		logger.info(":: The Submit Was Clicked");
		r.delay(5000);
		logger.info("Verify Member Logout is present or not");
		//logger.info(driver.findElement(By.xpath("//h3")).getText());
		assertTrue(driver.findElement(By.xpath("//div[@id='logout']/h3[contains(text(),'Member Logout')]")).getText().matches("^[\\s\\S]*Member Logout[\\s\\S]*$"));
		  //assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Member Logout[\\s\\S]*$"));
		logger.info("Click on the Logout button");
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("logout button was clicked");
   		
        logger.info(":: End of testForP1211User::");
	}
}
