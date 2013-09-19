package gov.va.sep.automatedtesting.suites;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Properties;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import gov.va.sep.automatedtesting.template.*;
import gov.va.sep.automatedtesting.utils.LogbackFileUtils;

public class SEPSearchVerification extends AutomatedTestingSuite{
	private static StringBuffer verificationErrors = new StringBuffer();
	//public Properties propertyFile = getTestProperties("vet1");
	LoginTemplate loginTemp = new LoginTemplate(propertyFile);
	SearchVetTemplate searchTemp = new SearchVetTemplate(propertyFile);
	
	@Test
	public HashMap SEPSearchVet(){	
		try{
			strTime = System.currentTimeMillis();
			LogbackFileUtils.start(this.getClass());
			logger.info("::In start of SEPSearchVet() method::");
			logger.info("**********Start open application************");
			driver.get(getProperties().getProperty("URL"));
			
			logger.info("::getting the URL from the properties file :: The URL is ::"+getProperties().getProperty("URL"));
			r.delay(5000);
			//Login SEP
			SEPLoginLogout.login(loginTemp);
			r.delay(5000);
			
			//Perform Search by SSN
			searchBySSN(searchTemp);
			r.delay(5000);
			
			//Search Results verification and no action
			searchResults(searchTemp, -1);
			r.delay(5000);
			
			//Logout SEP
			logger.info("::End of SEPSearchVet() method ::");
			SEPLoginLogout.logout();			
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
		driver.findElement(By.name("loginId")).sendKeys(getProperties().getProperty("userID"));
		logger.info("::The UserID ::"+getProperties().getProperty("userID"));
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("::The login button was clicked::");
		r.delay(7000);
		driver.findElement(By.cssSelector("strong > a")).click();
		r.delay(5000);
		try{
			logger.info("Test -- Checking the CSS for the Continue button");
			assertTrue("Checking the CSS for the Continue button",driver.findElement(By.className("bbmi_button")).getText().matches("^[\\s\\S]*Continue[\\s\\S]*$"));
		}catch (Error e) {
			logger.info(e.toString());
		     fail();
		}
		driver.findElement(By.linkText("Continue")).click();
		logger.info("::The Continue button was clicked::");
		r.delay(5000);
		try {
			logger.info("Test -- BBMI - My HealtheVet Prototype - Download My Selected Data");
			assertEquals("Result: ","BBMI - My HealtheVet Prototype - Download My Selected Data", driver.getTitle());
		} catch (Error e) {
			logger.info(e.toString());
		     fail();
		}
		try{
			logger.info("Test -- Checking the va_banner is present or not");
			assertTrue("Checking the va_banner is present or not::",isElementPresent(By.id("va_banner")));
		}catch (Error e) {
			 logger.info(e.toString());
		     fail();
		}
		 
	    try {
	    	
	    	logger.info("Test -- Checking the va_banner text says 'United States Department of Veterans Affairs' ");
	      assertEquals("Result:","United States Department of Veterans Affairs", driver.findElement(By.xpath("//div[@id='va_banner']/h2")).getAttribute("innerHTML"));
	    } catch (Error e) {
		     logger.info(e.toString());
		     fail();
		    }
	  
	   
	    
	    
	    try {
	    	logger.info("Test -- Checking the VA Prototype Radiology Reports and Medical Imaging disclaimer ");
	    	assertTrue(isElementPresent(By.cssSelector("h2.disclaimer")));
	      assertEquals("Result:","VA Prototype Radiology Reports and Medical Imaging", driver.findElement(By.cssSelector("h2.disclaimer")).getText());
	    } catch (Error e) {
	    	logger.info(e.toString());
		     fail();
	    }
	    try {
	    	logger.info("Test -- Checking the My HealtheVet banner text ");
	    	assertTrue(isElementPresent(By.cssSelector("#mhv_banner > h2.ir")));
	    	assertEquals("Result:","My HealtheVet", driver.findElement(By.cssSelector("#mhv_banner > h2.ir")).getText());
	    }
	    catch (Error e) {
	    	logger.info(e.toString());
		     fail();
		}
	    
	    // Warning: assertTextPresent may require manual changes
	    try{
	    	logger.info("Test -- Checking VA Home is Present or not ");
	    	//
	    	assertTrue("Checking VA Home is Present or not",driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*VA Home[\\s\\S]*$"));
	    	assertEquals("VA Home", driver.findElement(By.linkText("VA Home")).getText());
	    }catch (Error e) {
	    	logger.info(e.toString());
		     fail();
		}
	    r.delay(5000);
	    driver.findElement(By.id("date_custom")).click();
		logger.info(":: Custom Date Range Selected::");;
		r.delay(5000);
		new Select(driver.findElement(By.id("startMonth")))
				.selectByVisibleText(getProperties().getProperty("StartMonth"));
		
		r.delay(5000);
		new Select(driver.findElement(By.id("startDay")))
				.selectByVisibleText(getProperties().getProperty("BbmiLookandfeelStartDate"));
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
		r.delay(7000);
		
		//To Check Sort on Date/Time
		logger.info("Verify  Sorting  on Date/Time Start");
		driver.findElement(By.linkText("Date/Time Exam Performed")).click();
		r.delay(7000);
		logger.info("Verify  Sorting  on Date/Time End");
		
		logger.info("Start of Verifying the next button");
		r.delay(5000);
		driver.findElement(By.linkText("Next »")).click();
		logger.info("End of Verifythe next button");
		r.delay(5000);
		logger.info("Start of Verifying the previous button");
		driver.findElement(By.linkText("« Prev")).click();
		logger.info("End of Verifying the previous button");
		r.delay(5000);
		logger.info("Start of Verifying the last button");
		driver.findElement(By.linkText("Last »»")).click();
		logger.info("End of Verifying the last button");
		r.delay(5000);
		logger.info("Start of Verifying the First button");
	    driver.findElement(By.linkText("«« First")).click();
	    logger.info("End of Verifying the First button");
	    r.delay(5000);
	    logger.info("Start of Verifying 25 records per page");
	    driver.findElement(By.linkText("25")).click();
	    logger.info("End of Verifying 25 records per page");
	    r.delay(5000);
	    logger.info("Start of Verifying 50 records per page");
	    driver.findElement(By.linkText("50")).click();
	    logger.info("End of Verifying 50 records per page");
	    r.delay(5000);
	    logger.info("Start of Verifying 100 records per page");
	    driver.findElement(By.linkText("100")).click();
	    logger.info("End of Verifying 100 records per page");
	    r.delay(5000);
	    logger.info("Start of Verifying 10 records per page");
	    driver.findElement(By.linkText("10")).click();
	    logger.info("End of Verifying 10 records per page");
	    r.delay(5000);
		logger.info("Verify Member Logout is present or not");
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Member Logout[\\s\\S]*$"));
		logger.info("Click on the Logout button");
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("::End of verifyForLoginTable(");*/
	}
	
	public static void searchBySSN(SearchVetTemplate searchTemp){
		//Search for Veteran by SSN
		/*verify("Test -- Verify the Search header label text",By.xpath("//div[@id='vso_search_container']/h2"),searchTemp.getSearchHeaderLbl());		
		r.delay(3000);
		verify("Test -- Verify the SSN label text",By.xpath("//label[@for='ssn']"),searchTemp.getSearchSSNLbl());		
		r.delay(3000);
		verify("Test -- Verify the Search for Veteran button text is correct",By.xpath("//a[@id='vet_search_submit']/div"),searchTemp.getSearchForVetLbl());		
		r.delay(3000);*/
		
		//Check supplied fields and submit
		String ssn = searchTemp.getSearchSSN();
		boolean isSSN = (ssn != null ? true : false);
		if(isSSN){
			driver.findElement(By.id("ssn")).clear();
		    driver.findElement(By.id("ssn")).sendKeys(searchTemp.getSearchSSN());
		    r.delay(5000);
		}
		else{
			driver.findElement(By.id("first_name")).clear();
		    driver.findElement(By.id("first_name")).sendKeys(searchTemp.getSearchFirstName());
		    r.delay(5000);
		    driver.findElement(By.id("last_name")).clear();
		    driver.findElement(By.id("last_name")).sendKeys(searchTemp.getSearchLastName());
		    r.delay(5000);
		    
		    driver.findElement(By.id("birth_month")).clear();
		    driver.findElement(By.id("birth_month")).sendKeys(getDOB_By(searchTemp.getSearchDOB(),"m"));
		    r.delay(5000);
		    driver.findElement(By.id("birth_day")).clear();
		    driver.findElement(By.id("birth_day")).sendKeys(getDOB_By(searchTemp.getSearchDOB(),"d"));
		    r.delay(5000);
		    driver.findElement(By.id("birth_year")).clear();
		    driver.findElement(By.id("birth_year")).sendKeys(getDOB_By(searchTemp.getSearchDOB(),"y"));
		    r.delay(5000);
		}
		
	    driver.findElement(By.xpath("//a[@id='vet_search_submit']/div")).click();	 
	}
	
	public static String getDOB_By(String dob, String elementNeeded){
		String value = null;
		String[] elements = dob.split("//");
		
		if(elementNeeded.equals("m") || elementNeeded.equals("M"))
			value = elements[0];
		else if(elementNeeded.equals("d") || elementNeeded.equals("D"))
			value = elements[1];
		else if(elementNeeded.equals("y") || elementNeeded.equals("Y"))
			value = elements[2];
		return value;
	}
	
	
	/**
	 * Validates Search Veteran Results page and as well as selects an action in the dropdown based on
	 * the actionIndex
	 * @param searchTemp
	 * @param actionIndex : -1-None, 0-Access Online Forms, 1-View Claim Status, 2-View Payment History
	 * @throws Throwable
	 */
	public static void searchResults(SearchVetTemplate searchTemp, int actionIndex){
		//Validate Search results screen
		verify("Test -- Verify the Search Results header label text",By.xpath("//div[@id='vso_search_results']/h2"),searchTemp.getSearchResultsHeaderLbl());		
		verify("Test -- Verify the Search Results Veteran name text",By.xpath("//table[@id='vetSearchResults']/tbody/tr/td[1]"),searchTemp.getSearchResultVetName());		
		verify("Test -- Verify the Search Results Veteran DOB text",By.xpath("//table[@id='vetSearchResults']/tbody/tr/td[2]"),searchTemp.getSearchResultVetDOB());		
		verify("Test -- Verify the Search Results Veteran SSN text",By.xpath("//table[@id='vetSearchResults']/tbody/tr/td[3]"),searchTemp.getSearchResultVetSSN());		
		verify("Test -- Verify the Search Results Veteran Location text",By.xpath("//table[@id='vetSearchResults']/tbody/tr/td[4]"),searchTemp.getSearchResultVetLocation());		
		verify("Test -- Verify the Search Results Veteran Representative Through text",By.xpath("//table[@id='vetSearchResults']/tbody/tr/td[5]"),searchTemp.getSearchResultVetRepThrough());		
		
		//Click Action dropdown and select appropriate option
		driver.findElement(By.xpath("//table[@id='vetSearchResults']/tbody/tr/td[6]/div/a/div")).click();
		
		if(actionIndex == 0)
			driver.findElement(By.cssSelector("a[title=\"VDC\"] > span")).click();
		else if(actionIndex ==1)
			driver.findElement(By.cssSelector("a[title=\"View Claim Status\"] > span")).click();
		else if(actionIndex == 2)
			driver.findElement(By.cssSelector("a[title=\"View Payment History\"] > span")).click();
	}
}//end of class.
