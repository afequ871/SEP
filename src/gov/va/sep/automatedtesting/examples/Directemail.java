package gov.va.sep.automatedtesting.examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import gov.va.sep.automatedtesting.suites.AutomatedTestingSuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

public class Directemail extends AutomatedTestingSuite {
	
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
		/*s.wait("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/ZlarllnlnnvF.png");
		s.click("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/ZlarllnlnnvF.png"); //TODO: will need to refer to this on the class path and not the actual path
		logger.info("::Sikuli Click on Subject RadiologyReport::");*/
		/*WebElement availableSubject = null;
		//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
*/		List<WebElement> subjectList = driver.findElements(By.xpath("//tr[@class='messageRow']/td[5]/span/a"));
		if(subjectList.isEmpty())
			driver.quit();
		else
			subjectList.get(0).sendKeys(Keys.ENTER);//click();
		logger.info("::Click on Subject RadiologyReport::");
		r.delay(10000);
		
		
		//open pdf in email
		driver.findElement(By.cssSelector("a.rowLink")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//a[contains(text(),'BBDownloadServer')]")).sendKeys(Keys.ENTER);
		//driver.findElement(By.cssSelector("a.rowLink > span")).sendKeys(Keys.ENTER);//click();
		r.delay(10000);
		
		//Firefox Ok button for downlaod
		if(!AutomatedTestingSuite.fireFoxDriverSelected)
			s.click("C:/Direct mail sikuli images IE.sikuli/Open.png");
		else
			s.click("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/OK.png"); //TODO: will need to refer to this on the class path and not the actual path
		logger.info("::Sikuli Click on OK/open Image::");
		r.delay(15000);
		
		//close pdf
		s.click("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/E.png");
	   	logger.info("::Sikuli Click on CLOSE Image::");
	   	r.delay(8000);
		
		
		//Clickon download link on email
		/*s.wait("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/hccp15814721.png");
		r.delay(5000);
		//s.hover("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/hccp15814721.png"); //TODO: will need to refer to this on the class path and not the actual path
		//r.delay(5000);
   		s.click("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/hccp15814721.png"); //TODO: will need to refer to this on the class path and not the actual path
   		r.delay(2000);*/
	   	driver.switchTo().frame(1);
	   	driver.findElement(By.xpath("//a[contains(text(),'BBDownloadServer')]")).sendKeys(Keys.ENTER);
		logger.info("::Sikuli Click on Download link::");
		
		// Click on Download File zip
		System.out.println("Current url is "+driver.getCurrentUrl());
		// driver.findElement(By.cssSelector("a.rowLink > span")).click();		
		String mainTab = driver.getWindowHandles().toArray()[0].toString();
		String otherTab = driver.getWindowHandles().toArray()[1].toString();
		logger.info(driver.getWindowHandles().toString());
		if(!AutomatedTestingSuite.fireFoxDriverSelected){
			s.click("C:/Sikuli direct mail sign out.sikuli/DownloadHle.png");
		}
		else{
			driver.switchTo().window(otherTab);
			driver.findElement(By.xpath("//a[@class='regular']")).sendKeys(Keys.ENTER);//click();
			logger.info("::Cick on Download File zip ::"); //By.linkText("Download File")).click();
			r.delay(10000);
		}
		
		logger.info("Current window handle: " + driver.getWindowHandle().toString());
		//driver.switchTo().window(arg0);
		logger.info(driver.getTitle());
		

		//Firefox Ok button for downlaod
		if(!AutomatedTestingSuite.fireFoxDriverSelected)
			s.click("C:/Direct mail sikuli images IE.sikuli/Open.png");
		else
			s.click("C:/workspace/BBMI Automated Testing/main/src/Img1/OK.png"); 		
		logger.info("::Sikuli Click on OK Image::");
		r.delay(10000);
		
		//Sikuli Click on mhv prototype folder
		s.wait("C:/Direct mail sikuli images.sikuli/IHEES2FXEEEE.png");
		logger.info(":; Sikuli  Wait for mhv prototype folder loaded::");
		r.delay(5000);
		s.doubleClick("C:/Direct mail sikuli images.sikuli/IHEES2FXEEEE.png");
		logger.info("::Sikuli Click on mhv prototype folder Image::");
		r.delay(5000);
		
		
		s.wait("C:/Direct mail sikuli images.sikuli/mhv_protctyp.png");
		logger.info("::Sikuli wait for mhv prototype notepad Image::");
		r.delay(10000);
		s.doubleClick("C:/Direct mail sikuli images.sikuli/mhv_protctyp.png");
		logger.info("::Sikuli Click on mhv prototype notepad Image::");
		r.delay(10000);
		
		s.wait("C:/Direct mail sikuli images.sikuli/E.png");
		logger.info("::Sikuli wait for CLOSE Image::");
		r.delay(2000);
		s.click("C:/Direct mail sikuli images.sikuli/E.png");
		logger.info("::Sikuli Click on CLOSE Image::");
		r.delay(2000);
		
		s.wait("C:/Direct mail sikuli images.sikuli/IITIBQES.png");
		logger.info("::Sikuli wait on images folder Image::");
		r.delay(5000);
		s.doubleClick("C:/Direct mail sikuli images.sikuli/IITIBQES.png");
		logger.info("::Sikuli Click on images folder Image::");
		r.delay(5000);
		
		s.wait("C:/Direct mail sikuli images.sikuli/ljseries1.png");
		logger.info("::Sikuli wait on series1 folder Image::");
		r.delay(5000);
		s.doubleClick("C:/Direct mail sikuli images.sikuli/ljseries1.png");
		logger.info("::Sikuli Click on series1 folder Image::");
		r.delay(5000);
		
		s.wait("C:/Direct mail sikuli images.sikuli/Lurmvaimage6.png");
		logger.info("::Sikuli wait for dicom image Image::");
		r.delay(10000);
		s.doubleClick("C:/Direct mail sikuli images.sikuli/Lurmvaimage6.png");
		logger.info("::Sikuli Click on dicom Image::");
		r.delay(10000);
		
		s.wait("C:/Direct mail sikuli images.sikuli/1360855464111.png");
		logger.info("::Sikuli wait on dicom CLOSE Image::");
		r.delay(5000);
		s.click("C:/Direct mail sikuli images.sikuli/1360855464111.png");
		logger.info("::Sikuli Click on dicom CLOSE Image::");
		r.delay(5000);
		
		s.wait("C:/Direct mail sikuli images.sikuli/1360854843903.png");
		logger.info("::Sikuli Click on zip CLOSE Image::");
		r.delay(5000);
		s.click("C:/Direct mail sikuli images.sikuli/1360854843903.png");
		logger.info("::Sikuli Click on zip CLOSE Image::");
		r.delay(5000);
		
		
		if(!AutomatedTestingSuite.fireFoxDriverSelected){			
			logger.info("::close download tab::");
			s.click("C:/Direct mail sikuli images.sikuli/1360854843903.png");
			logger.info("::Click on download file window close button::");
			r.delay(3000);
		}
		else{
			// switch to main tab and logout		
			driver.switchTo().window(mainTab);
			logger.info("::switch to main tab::");
			driver.switchTo().frame(1);
			logger.info("::switch to email message frame::");
		}	
		
		r.delay(3000);
		driver.findElement(By.xpath("//a[@class='signoutButton']")).sendKeys(Keys.ENTER);//click();
		logger.info("::Click on signout button::");
		r.delay(5000);
		
		
	
	}
	
}


	
	