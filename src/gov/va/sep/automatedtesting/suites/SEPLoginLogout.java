package gov.va.sep.automatedtesting.suites;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import gov.va.sep.automatedtesting.template.*;
import gov.va.sep.automatedtesting.utils.LogbackFileUtils;

public class SEPLoginLogout extends AutomatedTestingSuite {
	//private static StringBuffer verificationErrors = new StringBuffer();
	//public Properties propertyFile = getTestProperties("vet1");
	LoginTemplate loginTemp = new LoginTemplate(propertyFile);
	
	@Test
	public HashMap LoginLogout() {
		
		try{
			strTime = System.currentTimeMillis();
			LogbackFileUtils.start(this.getClass());
			logger.info(":: In Start of LoginLogout() method");
			//r.delay(5000);
			logger.info("**********Start open application************");
			driver.get(getProperties().getProperty("URL"));
			logger.info("::getting the URL from the properties file :: The URL is ::"+getProperties().getProperty("URL"));
			r.delay(5000);
			//Login
			login(loginTemp);
			logger.info("::Logged in successful::");
			r.delay(10000); 
			
			//Logout
			logger.info("::End of LoginLogout() method ::");
		    logout();		    
			LogbackFileUtils.stop();
			
		    return returnObj;
		}catch(Exception e){
			logger.error("Test Failure: " + e.toString());
			closeDriver();
			endTime = System.currentTimeMillis();
			buildTestStatusObj(true);
			LogbackFileUtils.stop();
			return returnObj;	
		}
		
	      
	    
	    
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
	
	public static void login(LoginTemplate loginTemp){
		//Verification for login page
		//logger.debug("Login test debug statement");
		//r.delay(5000);
		verify("Test -- Verify the Login Stakeholder label text",By.xpath("//h1"),loginTemp.getLoginHeaderLbl());
		verify("Test -- Verify the Norton Login label text",By.xpath("//a[@id='login_pass']/div"),loginTemp.getLoginNortonBtnLbl());
		
		driver.findElement(By.cssSelector("#login_pass > div")).click();
		r.delay(1000);
		
		verify("Test -- Verify the Login Continue header label text",By.xpath("//div[@id='mm_body']/div/h3"),loginTemp.getLoginContinueHeaderLbl());
		verify("Test -- Verify the Login Continue Button label text",By.xpath("//a[@id='modalAction']/div"),loginTemp.getLoginContinueBtnLbl());		
		driver.findElement(By.cssSelector("#modalAction > div")).click();
		r.delay(1000);

		//Please sign in page verification and automation
		verify("Test -- Verify the Login Please SignIn header label text",By.xpath("//h1[@id='theHeading']"),loginTemp.getLoginPleaseSignInHeaderLbl());
		verify("Test -- Verify the Login SignIn label text",By.xpath("//input[@class='yellow_submit_button']"),loginTemp.getLoginSignInBtnLbl());
		
		//assertTrue(driver.findElement(By.xpath("//h1[@id='theHeading']")).getText().matches("^[\\s\\S]*" + loginTemp.getLoginPleaseSignInHeaderLbl()+ "[\\s\\S]*$"));
		//assertTrue(driver.findElement(By.xpath("//input[@class='yellow_submit_button']")).getAttribute("value").matches("^[\\s\\S]*" + loginTemp.getLoginSignInBtnLbl()+ "[\\s\\S]*$"));
		String username = loginTemp.getLoginEmailAddress();
		String password = loginTemp.getLoginPassword();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		logger.info("::The username is " + username + "::");
		r.delay(1000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		logger.info("::The password is " + password + "::");
		r.delay(1000);
		driver.findElement(By.cssSelector("input.yellow_submit_button")).click();
		logger.info("::The sign in button was clicked::");
		r.delay(1000);

		//Send SMS Security-code to SMS device
		verify("Test -- Verify the Login Security code label text",By.xpath("//h1"),loginTemp.getLoginSecurityCodeHeaderLbl());
		verify("Test -- Verify the cell phone number text",By.xpath("//div[@class='main-content']/strong"),loginTemp.getLoginSecurityCodeCellNumber());
		
		driver.findElement(By.id("btn-submit")).click();
		logger.info("::The Send button for SMS Security-code was clicked::");
		r.delay(1000);

		//Retrieve SMS Security-code and submit for login
		//driver.findElement(By.cssSelector("div.TN.GLujEb")).click();
		verify("Test -- Verify the Enter Security Code header text",By.xpath("//h1"),loginTemp.getLoginEnterSecurityCodeHeaderLbl());
		
		String retrievedSMSCode = getSecureCodeFromGmail();
		logger.info("::The Security code is " + retrievedSMSCode + "::");
		driver.findElement(By.id("smsCode")).clear();
		driver.findElement(By.id("smsCode")).sendKeys(retrievedSMSCode);
		r.delay(1000);
		driver.findElement(By.id("btn-submit")).click();
		logger.info("::The continue button was clicked::");			    
	}
	
	public static void logout(){
		//Logout and verify if test pass or failed
		driver.switchTo().defaultContent();
		driver.findElement(By.id("userLogout")).click();
		logger.info("::The Logout button was clicked::");	    
		closeDriver();
		
		//Build returnObject for Test
		endTime = System.currentTimeMillis();
		buildTestStatusObj(false);
	}
	
	public static WebElement findLogout(){
		return driver.findElement(By.id("userLogout"));
		
	}
	
}//end of class.
