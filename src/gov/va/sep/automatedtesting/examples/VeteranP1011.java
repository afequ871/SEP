package gov.va.sep.automatedtesting.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.awt.event.KeyEvent;

import gov.va.sep.automatedtesting.suites.AutomatedTestingSuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;

/**
 * @author cgattu99
 * This test case covers 3.1.1 to 3.1.2.
 * This holds the positive scenario for veteran.
 */
public class VeteranP1011 extends AutomatedTestingSuite {
	

	
	@Test
	public void testForFileOpening() throws Exception {

		
		logger.info(":: In Start of testForNotePadOpening() method");
		//r.delay(5000);
		logger.info("**********Start open application************");
		driver.get(getProperties().getProperty("URL"));
		logger.info("::getting the URL from the properties file :: The URL is ::"+getProperties().getProperty("URL"));
		r.delay(5000);
		//Signing in login page
		driver.findElement(By.name("loginId")).clear();
		driver.findElement(By.name("loginId")).sendKeys(getProperties().getProperty("userID"));
		logger.info("::The UserID ::"+getProperties().getProperty("userID"));
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("::The login button was clicked::");
		r.delay(5000);
		driver.findElement(By.cssSelector("strong > a")).click();
		r.delay(5000);
		logger.info("::validating the messages ::If you have an upgraded My HealtheVet Premium account you may also download your VA Continuity of Care Document (VA CCD).Start::");
		assertEquals("If you have an upgraded My HealtheVet Premium account you may also download your VA Continuity of Care Document (VA CCD). This is a standard electronic exchange document. It is used for sharing patient information. This is a summary and not intended to be a copy of your complete VA health record. To learn more about this feature, visit VA CCD.", driver.findElement(By.xpath("//div[@id='main']/section/div/div/p[7]")).getText());
		logger.info("::validating the messages ::If you have an upgraded My HealtheVet Premium account you may also download your VA Continuity of Care Document (VA CCD).End::");
		logger.info("::validating the messages ::Download my customized Blue Button data.Start::");
	    assertEquals("Download my customized Blue Button data", driver.findElement(By.cssSelector("label")).getText());
	    logger.info("::validating the messages ::Download my customized Blue Button data.End::");
	    logger.info("::validating the messages ::Download my VA Continuity of Care Document (VA CCD) data*.Start::");
	    assertEquals("Download my VA Continuity of Care Document (VA CCD) data*", driver.findElement(By.xpath("//div[@id='mhv-conditional-box']/div/div[2]/label")).getText());
	    logger.info("::validating the messages ::Download my VA Continuity of Care Document (VA CCD) data*.End::");
	    logger.info("::validating the messages ::Protect your information and your identity. Send your information to a safe site or device that you or someone you trust controls.*.Start::");
	    assertEquals("Protect your information and your identity. Send your information to a safe site or device that you or someone you trust controls. Remember, once you have downloaded your information from My HealtheVet, it is your responsibility to keep it safe and private. Learn more about protecting your personal health information .", driver.findElement(By.cssSelector("span.introText")).getText());
	    logger.info("::validating the messages ::Protect your information and your identity. Send your information to a safe site or device that you or someone you trust controls.*.End::");
	    logger.info("::validating the messages End::");
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
		
		logger.info("Click on the  Preview link");
		driver.findElement(By.xpath("//div[@id='main']/section/div/section/table/tbody/tr[2]/td[4]/a/span")).click();
		r.delay(7000);
		//Click on the Image.
		logger.info("Click on the scanned images");
		driver.findElement(By.xpath("(//img[@alt='Radiology image thumbnail'])[6]")).click();
		r.delay(5000);
		logger.info("Click on the  close image to close the  scanned image");
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-closethick")).click();
		r.delay(5000);
		//Back to the reports list.
		logger.info("Back to the Reports List Start");
		driver.findElement(By.linkText("Return to List")).click();
		logger.info("Back to the Reports List End");
		r.delay(5000);
		//for()
		logger.info(":: Click on the Text icon to open the NotePad::");
		fileDownload(driver.findElement(By.xpath("(//a[contains(text(),'Text')])[2]")));
//		driver.findElement(By.linkText("Text")).click();		
		
		 logger.info(":: Click on the PDF icon to open the PDF::");
		
		// PDF click open and close
		fileDownload(driver.findElement(By.xpath("(//a[contains(text(),'PDF')])[3]")));//.click();
	   	

		//To Check Sort on Date/Time
		logger.info("Verify  Sorting  on Date/Time Start");
		driver.findElement(By.linkText("Date/Time Exam Performed")).click();
		r.delay(5000);
		logger.info("Verify  Sorting  on Date/Time End");
		r.delay(5000);
		//To Check Sort on Procedure/Test Name
		logger.info("Verify  Sorting  on Procedure/Test Start");
        driver.findElement(By.linkText("Procedure/Test Name")).click();
        r.delay(5000);
        logger.info("Verify  Sorting  on Procedure/Test End");
        r.delay(5000);
      //To Check Sort on Images
		logger.info("Verify  Sorting  on images");
        driver.findElement(By.linkText("# Images")).click();
        r.delay(5000);
        logger.info("Verify  Sorting  on images End");
      //To Check Sort on PDF File Size
		logger.info("Verify  Sorting  on PDF File Size");
		 r.delay(5000);
		 logger.info("Verify  Sorting  on PDF File Size End");
		 driver.findElement(By.linkText("Est PDF Size")).click();
		 r.delay(5000);
       
		logger.info("Click on the SendReport Image");
		driver.findElement(By.xpath("//div[@id='main']/section/div/section/table/tbody/tr[4]/td[7]/a/img")).click();
//   		
   		r.delay(5000);
   		
   		
   		logger.info("Viewing the Report Text Preview");
		driver.findElement(By.id("textHead")).click();
		r.delay(5000);
		logger.info("Minimising the Report Text Preview");
		driver.findElement(By.id("textHead")).click();
		r.delay(5000);
		logger.info("Selecting the Provider");
		new Select(driver.findElement(By.id("provider"))).selectByValue(getProperties().getProperty("provider"));
		r.delay(5000);
		logger.info("Click on the ack box");
		driver.findElement(By.id("verify")).click();
		r.delay(5000);
		logger.info("Click on the SendMyReport button");
		
		
		driver.findElement(By.cssSelector("input.bbmi_button")).click();
		r.delay(5000); 
		logger.info("Verify Member Logout is present or not");
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Member Logout[\\s\\S]*$"));
		logger.info("Click on the Logout button");
		r.delay(5000);
		driver.findElement(By.cssSelector("input.mhv_button")).click();
		logger.info("logout button was clicked");
   		
        logger.info(":: End of testForFileOpening::");
	}
	
	public void fileDownload(WebElement downloadElement){
		try{
			// simulate click function
			downloadElement.sendKeys(Keys.ENTER);
			
			if(!AutomatedTestingSuite.fireFoxDriverSelected){
				r.delay(7000);
				logger.info("clicked!");
					
				r.keyPress(KeyEvent.VK_ALT);
		        r.keyPress(KeyEvent.VK_N);
		        r.keyRelease(KeyEvent.VK_ALT);
		        r.keyRelease(KeyEvent.VK_N);
		        logger.info("Notification Bar Selected...");
		        
		        r.delay(5000);
		        
		        //Select Save button
		        r.keyPress(KeyEvent.VK_O);
		        r.keyRelease(KeyEvent.VK_O);
		        logger.info("File open...");

		        r.delay(7000);
		        
		      //close notepad..
		        r.keyPress(KeyEvent.VK_ALT);
		        r.keyPress(KeyEvent.VK_F4);
		        r.keyRelease(KeyEvent.VK_ALT);
		        r.keyRelease(KeyEvent.VK_F4);
		        logger.info("closed pdf...");
		        
		        r.delay(5000);
		        
		        //Close notification Bar
		        r.keyPress(KeyEvent.VK_ESCAPE);
		        r.keyRelease(KeyEvent.VK_ESCAPE);
		        logger.info("Notification Bar Closed...");
		        
		        r.delay(5000);
			}
			else{
				r.delay(5000);
			   	s.click("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/OK.png"); //TODO: will need to refer to this on the class path and not the actual path
			   	logger.info("::Sikuli Click on OK Image::");
			   	r.delay(10000);
			   	s.wait("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/E.png");
			   	logger.info(":; Sikuli  Wait for Close image loaded::");
			   	r.delay(10000);
			   	s.click("C:/BBMI-Automation-testing-framework-master/BBMI-Automation-testing-framework-master/main/src/Img1/E.png");
			   	logger.info("::Sikuli Click on CLOSE Image::");
			   	r.delay(10000);			
			}		
		}catch(Exception e){
			logger.info(e.getLocalizedMessage());
		}
		
	}
}
