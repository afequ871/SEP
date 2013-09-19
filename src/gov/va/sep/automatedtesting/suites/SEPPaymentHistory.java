package gov.va.sep.automatedtesting.suites;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import gov.va.sep.automatedtesting.template.*;
import gov.va.sep.automatedtesting.utils.LogbackFileUtils;

public class SEPPaymentHistory extends AutomatedTestingSuite {
	//private static StringBuffer verificationErrors = new StringBuffer();
	//public Properties propertyFile = getTestProperties("vet1");
	LoginTemplate loginTemp = new LoginTemplate(propertyFile);
	SearchVetTemplate searchTemp = new SearchVetTemplate(propertyFile);
	PaymentHistTemplate paymentTemp = new PaymentHistTemplate(propertyFile);
	
	@Test
	public HashMap PaymentHistory() {
		try{
			strTime = System.currentTimeMillis();
			LogbackFileUtils.start(this.getClass());			
			logger.info(":: In Start of PaymentHistory() method");
			//r.delay(5000);
			logger.info("**********Start open application************");
			driver.get(getProperties().getProperty("URL"));
			logger.info("::getting the URL from the properties file :: The URL is ::"+getProperties().getProperty("URL"));
			r.delay(5000);
			
			//Login SEP
			SEPLoginLogout.login(loginTemp);
			r.delay(5000);

			//Perform Search by SSN
			SEPSearchVerification.searchBySSN(searchTemp);
			r.delay(5000);

			//Search Results verification and select Payment History
			SEPSearchVerification.searchResults(searchTemp, 2);
			r.delay(5000);
			
			//Payment History Verification
			driver.switchTo().frame(0);
			viewPaymentHistory(paymentTemp);
			r.delay(5000);
			//Payment History Details Verification
			viewPaymentHistoryDetails(paymentTemp);
		    r.delay(5000);
		    
		    // Go back to dashboard
		    driver.switchTo().defaultContent();
		    //driver.findElement(By.id("dashboard")).click();	    
		    //r.delay(5000);
		    
		    //Logout
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
	}
	
	public static void viewPaymentHistory(PaymentHistTemplate paymentTemp){
		//Payment History Verification
		verify("Test -- Verify the Payment History header label text",By.xpath("//div[@id='main_content']/h1"), paymentTemp.getHstPaymentHistLbl());
		verify("Test -- Verify the Payment History Table Column 1 Row 1 text",By.xpath("//table[@id='payment_table']/tbody/tr[1]/td[1]/a"), paymentTemp.getHstPaymentSumTblCol1());		
		verify("Test -- Verify the Payment History Table Column 2 Row 1 text",By.xpath("//table[@id='payment_table']/tbody/tr[1]/td[2]"), paymentTemp.getHstPaymentSumTblCol2());		
		verify("Test -- Verify the Payment History Table Column 3 Row 1 text",By.xpath("//table[@id='payment_table']/tbody/tr[1]/td[3]"), paymentTemp.getHstPaymentSumTblCol3());		
		verify("Test -- Verify the Payment History Table Column 4 Row 1 text",By.xpath("//table[@id='payment_table']/tbody/tr[1]/td[4]"), paymentTemp.getHstPaymentSumTblCol4());		
		verify("Test -- Verify the Payment History No Returned Payment detail text",By.xpath("//div[@class='row_returns']/div/div"), paymentTemp.getHstNoPaymentDetail());	
	}
	
	public static void viewPaymentHistoryDetails(PaymentHistTemplate paymentTemp){
		// Click on one of the displayed "Payment Date(s)".
	    // Todo: add actions and validation for selecting and displaying Payment Details
	    driver.findElement(By.xpath("//table[@id='payment_table']/tbody/tr/td[1]/a")).click(); //By.id("myeb_paymentHistoryGrp0")
	    r.delay(5000);
	    //Payment detail verification
	    verify("Test -- Verify the Payment History Detail header label text",By.xpath("//div[@id='main_content']/h1"), paymentTemp.getHstPaymentDetailLbl());		
		verify("Test -- Verify the Payment History Detail Amount text",By.xpath("//table[@id='payment_modifications']/tbody/tr[1]/td"), paymentTemp.getHstDetailPaymentAmount());		
		verify("Test -- Verify the Payment History Detail Date text",By.xpath("//table[@id='payment_modifications']/tbody/tr[2]/td"), paymentTemp.getHstDetailPaymentDate());		
		verify("Test -- Verify the Payment History Detail Type text",By.xpath("//table[@id='payment_modifications']/tbody/tr[3]/td"), paymentTemp.getHstDetailPaymentType());		
		verify("Test -- Verify the Payment History Detail Method text",By.xpath("//table[@id='payment_modifications']/tbody/tr[4]/td"), paymentTemp.getHstDetailPaymentMethod());	
		verify("Test -- Verify the Payment History Check Recipient text",By.xpath("//table[@id='payment_modifications']/tbody/tr[5]/td"), paymentTemp.getHstDetailCheckRecipient());
		verify("Test -- Verify the Payment History Address Line 1 text",By.xpath("//table[@id='payment_modifications']/tbody/tr[6]/td"), paymentTemp.getHstDetailAddressLine1());
		verify("Test -- Verify the Payment History Address Line 2 text",By.xpath("//table[@id='payment_modifications']/tbody/tr[7]/td"), paymentTemp.getHstDetailAddressLine2());
		verify("Test -- Verify the Payment History Zip Code text",By.xpath("//table[@id='payment_modifications']/tbody/tr[8]/td"), paymentTemp.getHstDetailZipCode());
	}
	
}//end of class.
