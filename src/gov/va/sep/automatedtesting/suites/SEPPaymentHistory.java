package gov.va.sep.automatedtesting.suites;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import gov.va.sep.automatedtesting.objects.template.*;

public class SEPPaymentHistory extends AutomatedTestingSuite {
	private static StringBuffer verificationErrors = new StringBuffer();
	public Properties propertyFile = getTestProperties("vet1");
	LoginTemplate loginTemp = new LoginTemplate(propertyFile);
	SearchVetTemplate searchTemp = new SearchVetTemplate(propertyFile);
	PaymentHistTemplate paymentTemp = new PaymentHistTemplate(propertyFile);
	
	@Test
	public void PaymentHistory() throws Throwable {
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

		//Search Results verification and no action
		SEPSearchVerification.searchResults(searchTemp, 2);
		r.delay(5000);
		
		//Payment History Verification
		viewPaymentHistory(paymentTemp);
		r.delay(5000);
		//Payment History Details Verification
		viewPaymentHistoryDetails(paymentTemp);
	    r.delay(5000);
	    
	    // Go back to dashboard
	    driver.findElement(By.id("dashboard")).click();	    
	    r.delay(5000);
	    
	    //Logout
	    driver.findElement(By.id("userLogout")).click();
	    logger.info("::The Logout button was clicked::");
	    
	    
	}
	
	public static void viewPaymentHistory(PaymentHistTemplate paymentTemp) throws Throwable{
		//Payment History Verification
		verify("Test -- Verify the Payment History header label text",By.xpath("//div[@id='main_content']/h1"), paymentTemp.getHstPaymentHistLbl());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Table Column 1 label text",By.xpath("//table[@id='payment_table']/thead/tr/th[1]"), paymentTemp.getHstPaymentSumTblCol1());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Table Column 2 label text",By.xpath("//table[@id='payment_table']/thead/tr/th[2]"), paymentTemp.getHstPaymentSumTblCol2());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Table Column 3 label text",By.xpath("//table[@id='payment_table']/thead/tr/th[3]"), paymentTemp.getHstPaymentSumTblCol3());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Table Column 4 label text",By.xpath("//table[@id='payment_table']/thead/tr/th[4]"), paymentTemp.getHstPaymentSumTblCol4());		
		r.delay(3000);
		verify("Test -- Verify the Payment History No Returned Payment detail text",By.xpath("//div[@class='row_returns']/div/div"), paymentTemp.getHstNoPaymentDetail());		
		r.delay(3000);
	}
	
	public static void viewPaymentHistoryDetails(PaymentHistTemplate paymentTemp) throws Throwable{
		// Click on one of the displayed "Payment Date(s)".
	    // Todo: add actions and validation for selecting and displaying Payment Details
	    driver.findElement(By.xpath("//table[@id='payment_table']/tbody/tr/td[1]/a")).click(); //By.id("myeb_paymentHistoryGrp0")
	    
	    //Payment detail verification
	    verify("Test -- Verify the Payment History Detail header label text",By.xpath("//div[@id='main_content']/h1"), paymentTemp.getHstPaymentDetailLbl());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Detail Amount text",By.xpath("//table[@id='payment_modifications']/tbody/tr[1]/td"), paymentTemp.getHstDetailPaymentAmount());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Detail Date text",By.xpath("//table[@id='payment_modifications']/tbody/tr[2]/td"), paymentTemp.getHstDetailPaymentDate());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Detail Type text",By.xpath("//table[@id='payment_modifications']/tbody/tr[3]/td"), paymentTemp.getHstDetailPaymentType());		
		r.delay(3000);
		verify("Test -- Verify the Payment History Detail Method text",By.xpath("//table[@id='payment_modifications']/tbody/tr[4]/td"), paymentTemp.getHstDetailPaymentMethod());		
		r.delay(3000);	
	}
	
}//end of class.
