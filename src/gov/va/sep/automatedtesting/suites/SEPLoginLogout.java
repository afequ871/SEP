package gov.va.sep.automatedtesting.suites;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gov.va.sep.automatedtesting.AutomatedTestingSuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SEPLoginLogout extends AutomatedTestingSuite {
	private static StringBuffer verificationErrors = new StringBuffer();
	@Test
	public void LoginLogout() throws Throwable {
		
		logger.info(":: In Start of LoginLogout() method");
		//r.delay(5000);
		logger.info("**********Start open application************");
		driver.get(getProperties().getProperty("URL"));
		logger.info("::getting the URL from the properties file :: The URL is ::"+getProperties().getProperty("URL"));
		r.delay(5000);
		
		driver.findElement(By.cssSelector("#login_pass > div")).click();
	    driver.findElement(By.cssSelector("#modalAction > div")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
	    String username = "sep.pwc@gmail.com";
	    String password = "septest123";
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    logger.info("::The username is " + username + "::");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    logger.info("::The password is " + password + "::");
	    driver.findElement(By.cssSelector("input.yellow_submit_button")).click();
	    logger.info("::The sign in button was clicked::");
	    r.delay(5000);
	    
	    //Send SMS Security-code to SMS device
	    driver.findElement(By.id("btn-submit")).click();
	    logger.info("::The Send button for SMS Security-code was clicked::");
	    r.delay(5000);
	    
	    //Retrieve SMS Security-code and submit for login
	    //driver.findElement(By.cssSelector("div.TN.GLujEb")).click();
	    String retrievedSMSCode = getSecureCodeFromGmail();
	    logger.info("::The Security code is " + retrievedSMSCode + "::");
	    driver.findElement(By.id("smsCode")).clear();
	    driver.findElement(By.id("smsCode")).sendKeys(retrievedSMSCode);
	    driver.findElement(By.id("btn-submit")).click();
	    logger.info("::The continue button was clicked::");
	    r.delay(10000);
	    //Logout
	    driver.findElement(By.id("userLogout")).click();
	    logger.info("::The Logout button was clicked::");
	    
	    
	    
	    
	    
	    
		/*driver.findElement(By.name("loginId")).clear();
		logger.info("::Start of Verifying the Invalid UserName::");
		driver.findElement(By.name("loginId")).sendKeys(getProperties().getProperty("Invaliduserid"));
		logger.info("::The UserID ::"+getProperties().getProperty("Invaliduserid"));
		driver.manage().window().maximize();
		//r.delay(5000);
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("::The login button was clicked::");
		try{
			String s	=	driver.findElement(By.cssSelector("BODY")).getText();
			s	=	s.substring(s.indexOf("'Spy1'"), s.indexOf("again.")+6);
			assertEquals("Result: ","'Spy1' is not a valid Login ID. Please try again.",s);
		} catch (Error e) {
			logger.info(e.toString());
			fail();
		}
		r.delay(5000);
		logger.info("::End of Verifying the Invalid UserName::");
		driver.findElement(By.name("loginId")).clear();
		driver.findElement(By.name("loginId")).sendKeys(getProperties().getProperty("userID"));
		logger.info("::The UserID ::"+getProperties().getProperty("userID"));
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("::The login button was clicked::");
		r.delay(5000);
		driver.findElement(By.cssSelector("strong > a")).click();
		r.delay(5000);
		driver.findElement(By.linkText("Continue")).click();
		logger.info("::The Continue button was clicked::");
		r.delay(5000);
		logger.info("::Testing on Invalid date range selection::");
		driver.findElement(By.id("date_custom")).click();
		logger.info(":: Custom Date Range Selected::");;
		logger.info("::Start of Verifying the Invalid date range::");
		new Select(driver.findElement(By.id("startMonth")))
				.selectByVisibleText(getProperties().getProperty("InvaliStartMonth"));
		
		new Select(driver.findElement(By.id("startDay")))
				.selectByVisibleText(getProperties().getProperty("InvalidStratDate"));
		new Select(driver.findElement(By.id("startYear")))
				.selectByVisibleText(getProperties().getProperty("InvalidStartYear"));
		logger.info("::Strat Date  is ::"+getProperties().getProperty("InvaliStartMonth")+getProperties().getProperty("InvalidStratDate")+getProperties().getProperty("InvalidStartYear"));
		new Select(driver.findElement(By.id("endYear")))
		.selectByVisibleText(getProperties().getProperty("InvalidEndYear"));
		new Select(driver.findElement(By.id("endMonth")))
				.selectByVisibleText(getProperties().getProperty("InvalidEndMonth"));
		new Select(driver.findElement(By.id("endDay")))
				.selectByVisibleText(getProperties().getProperty("InvalidEndday"));
		logger.info("::End Date  is ::"+getProperties().getProperty("InvalidEndMonth")+getProperties().getProperty("InvalidEndday"));
		driver.findElement(By.cssSelector("input.bbmi_button")).click();
		logger.info(":: The Submit Was Clicked");
		logger.info("::Check for the Found 0 reports Text on browser end::");
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Found 0 reports for the timeframe[\\s\\S]*$"));
		r.delay(5000);
		logger.info("::End of Verifying the Invalid date range::");
		driver.findElement(By.linkText("Cancel")).click();
		r.delay(5000);
		logger.info(":: The Cancel button was clicked::");
		r.delay(5000);
		driver.findElement(By.linkText("Continue")).click();
		logger.info("::The Continue button was clicked::");
		r.delay(5000);
		driver.findElement(By.id("date_custom")).click();
		logger.info(":: Custom Date Range Selected::");;
		new Select(driver.findElement(By.id("startMonth")))
				.selectByVisibleText(getProperties().getProperty("StartMonth"));
		
		new Select(driver.findElement(By.id("startDay")))
				.selectByVisibleText(getProperties().getProperty("StartDate"));
		r.delay(5000);
		new Select(driver.findElement(By.id("startYear")))
				.selectByVisibleText(getProperties().getProperty("StartYear"));
		logger.info("::Strat Date  is ::"+getProperties().getProperty("StartMonth")+getProperties().getProperty("StartDate")+getProperties().getProperty("StartYear"));
		r.delay(5000);
		new Select(driver.findElement(By.id("endMonth")))
				.selectByVisibleText(getProperties().getProperty("EndMonth"));
		new Select(driver.findElement(By.id("endDay")))
				.selectByVisibleText(getProperties().getProperty("Endday"));
		r.delay(5000);
		logger.info("::End Date  is ::"+getProperties().getProperty("EndMonth")+getProperties().getProperty("Endday"));
		driver.findElement(By.cssSelector("input.bbmi_button")).click();
		logger.info(":: The Submit Was Clicked");
		
		logger.info("Click on the SendReport Image");
		r.delay(5000);
   		driver.findElement(By.cssSelector("img")).click();
   		
   		
   		//Checking Error messages  without selecting the Provider and ack box.
		logger.info("Click on the SendMyReport button");
		r.delay(5000);
		driver.findElement(By.cssSelector("input.bbmi_button")).click();
		logger.info("Start of Verifying the error messages for provider aswell as ack box");
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please select a provider[\\s\\S]*$"));
		r.delay(5000);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You must authorize the release of your information[\\s\\S]*$"));
		logger.info("End of Verifying the error messages for provider aswell as ack box");
		
		//Checking error message for provider by only selecting the ack box
		logger.info("Start of Verifying the error messages for provider only");
		logger.info("Click on the ack box");
		r.delay(5000);
		driver.findElement(By.id("verify")).click();
		logger.info("Click on the SendMyReport button");
		r.delay(5000);
		driver.findElement(By.cssSelector("input.bbmi_button")).click();
		r.delay(5000);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please select a provider[\\s\\S]*$"));
		logger.info("End of Verifying the error messages for provider only");
		
		//Checking error message for ack by only selecting the valid provider
		logger.info("Start of Verifying the error messages for ack box only");
		r.delay(5000);
		driver.findElement(By.linkText("Return to List")).click();
		r.delay(5000);
		driver.findElement(By.cssSelector("img")).click();
		r.delay(5000);
		logger.info("Selecting the Provider");
		new Select(driver.findElement(By.id("provider"))).selectByValue(getProperties().getProperty("provider"));
		r.delay(5000);
		logger.info("Click on the SendMyReport button");
		driver.findElement(By.cssSelector("input.bbmi_button")).click();
		r.delay(5000);
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You must authorize the release of your information[\\s\\S]*$"));
		logger.info("End of Verifying the error messages for provider only");
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			logger.info(verificationErrorString);
		}
		logger.info("Verify Member Logout is present or not");
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Member Logout[\\s\\S]*$"));
		logger.info("Click on the Logout button");
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("logout button was clicked");*/
		
	}
	
	
}//end of class.
