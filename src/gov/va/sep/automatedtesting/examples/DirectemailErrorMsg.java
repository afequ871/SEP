package gov.va.sep.automatedtesting.examples;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import gov.va.sep.automatedtesting.AutomatedTestingSuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Region;

public class DirectemailErrorMsg extends AutomatedTestingSuite {
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	@Test
	public void testSecureProviderEmail() throws Exception {
		try{
			logger.info("Directemail::In Start of testing SecureProvider Email::");
			String providerURL	=	getSecureEmailLinkFromGmail();
			logger.info("Directemail::Getting the ProviderURL from  unsecure(gmail)::  Provider URL is::"+providerURL.trim());
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			driver.get(providerURL);
			//driver.findElement(By.linkText("Go to the login page")).click();
			driver.findElement(By.name("login_username")).clear();
			driver.findElement(By.name("login_username")).sendKeys(getProperties().getProperty("loginusername"));
			logger.info("Directemail::Getting the login_username from the Properties File :: login_username is::"+getProperties().getProperty("loginusername"));
			driver.findElement(By.name("secretkey")).clear();
			driver.findElement(By.name("secretkey")).sendKeys(getProperties().getProperty("secretkey"));
			logger.info("Directemail::Getting the secretkey from the Properties File :: secretkey is::"+getProperties().getProperty("secretkey"));
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			driver.manage().window().maximize();
			logger.info("Directemail::SubmitButton was clicked");
			r.delay(5000);
			
			//switch to email list frame
			driver.switchTo().frame(1);
			
			//Click on subject 		
			//s.wait("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/RadiologyRep.png");
			//s.click("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/RadiologyRep.png"); //TODO: will need to refer to this on the class path and not the actual path
			logger.info("::Sikuli Click on Subject RadiologyReport::");
			List<WebElement> subjectList = driver.findElements(By.xpath("//tr[@class='messageRow']/td[5]/a"));
			if(subjectList.isEmpty())
				driver.quit();
			else
				subjectList.get(0).sendKeys(Keys.ENTER);//click();
			logger.info("::Click on Subject RadiologyReport::");		
			r.delay(10000);
			
			// click on download link in email
			System.out.println("pagesource is --->"+driver.getPageSource());
			//Region region 	=	
				//s.wait("C:/workspace/BBMI Automated Testing/main/src/Img1/httphcbbmLU2-1.png");
			//driver.switchTo().frame(1);
		   	driver.findElement(By.xpath("//a[contains(text(),'BBDownloadServer')]")).sendKeys(Keys.ENTER);
			logger.info("::Sikuli Click on Download link::");
			
			//r.delay(10000);
			//s.click("C:/workspace/BBMI Automated Testing/main/src/Img1/httphcbbmLU2-1.png"); //TODO: will need to refer to this on the class path and not the actual path
			logger.info("::Sikuli Click on the link to open the erro screen::");		
			r.delay(10000);	
		
			//Test error message
			logger.info(":silkuli testchecking Error message");
			boolean imageDetected = false;
			int countMax=5;
			int count =0;
			while(count < countMax){
				if(imageDetected)
					break;				
				else{
					try{
						//s.wait("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/ErrorTherewa.png");
						//r.delay(5000);
						s.exists("C:/Direct mail sikuli images.sikuli/ErrorTherewa-1.png");
						imageDetected = true;
					}catch(Exception e){
						count++;
						logger.info("Sikuli image detection attempt " + count + " of " + countMax);
						if(count == countMax)
							logger.info("Error - Sikuli image detection - " + e.getMessage());
					}
				}
			}
	   		
			logger.info("::Sikuli Checking ErrorMsg complete::");
			
			// signout
			if(!AutomatedTestingSuite.fireFoxDriverSelected){			
				logger.info("::close download tab::");
				r.delay(3000);
				s.click("C:/Direct mail sikuli images.sikuli/1360854843903.png");
				logger.info("::Click on download file window close button::");
				r.delay(3000);
			}
			else{
				// switch to main tab and logout			
				driver.switchTo().frame(1);
				logger.info("::switch to email message frame::");
			}			
			r.delay(3000);
			driver.findElement(By.xpath("//a[@class='signoutButton']")).sendKeys(Keys.ENTER);//click();
			logger.info("::Click on signout button::");
			r.delay(5000);
			
		}catch(Error e){
			logger.info(e.toString());
		     fail();
		}		
	}	
}


	
	