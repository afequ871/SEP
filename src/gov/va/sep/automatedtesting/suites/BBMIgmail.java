package gov.va.sep.automatedtesting.suites;


	import static org.junit.Assert.fail;
import gov.va.sep.automatedtesting.AutomatedTestingSuite;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;

	public class BBMIgmail  extends AutomatedTestingSuite{		
		private String baseUrl;
		private StringBuffer verificationErrors = new StringBuffer();		

		@Test
		public void testUntitled() throws Exception {
			baseUrl = "https://accounts.google.com/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl + "/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
			driver.findElement(By.id("Email")).sendKeys("bbmitestuser");
			driver.findElement(By.id("Passwd")).clear();
			driver.findElement(By.id("Passwd")).sendKeys("bbmi123");
			driver.findElement(By.id("signIn")).click();
			driver.findElement(By.id("Passwd")).clear();
			driver.findElement(By.id("Passwd")).sendKeys("bbmitest123");
			driver.findElement(By.id("signIn")).click();
			driver.manage().window().maximize();
			Screen s=null;
			Robot r	=	null;
			try {
				s = new Screen();
				r = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	r.delay(10000);
			r.delay(10000);
			
			//click on gmail subject 
			driver.findElement(By.xpath("//td//span[contains(text(),'Notification of new Direct email message')]/../../../../..")).click();//sendKeys(Keys.ENTER); ///span[contains(text(),'Notification of new Direct email message')]
			
			
			
			r.delay(15000);
			logger.info("::Sikuliopen the gmail subject::");
			
		}

		@After
		public void tearDown() throws Exception {
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
		}

		private boolean isElementPresent(By by) {
			try {
				driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}
		}
	}



