
package gov.va.sep.automatedtesting.suites;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import gov.va.sep.automatedtesting.template.*;
import gov.va.sep.automatedtesting.utils.LogbackFileUtils;

public class SEPClaimHistory extends AutomatedTestingSuite {
	//private static StringBuffer verificationErrors = new StringBuffer();
	//public Properties propertyFile = getTestProperties("vet1");
	LoginTemplate loginTemp = new LoginTemplate(propertyFile);
	SearchVetTemplate searchTemp = new SearchVetTemplate(propertyFile);
	ClaimHistTemplate claimTemp = new ClaimHistTemplate(propertyFile);
	
	@Test
	public HashMap ClaimHistory() {
		try{
			strTime = System.currentTimeMillis();
			LogbackFileUtils.start(this.getClass());			
			logger.info(":: In Start of ClaimHistory() method");
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

			//Search Results verification and select Claims History
			SEPSearchVerification.searchResults(searchTemp, 1);
			r.delay(5000);
			
			//Claims Open Verification
			driver.switchTo().frame(0);
			viewOpenClaims(claimTemp);
			r.delay(5000);
			//Claims Open Details Verification
			viewOpenClaimsDetail(claimTemp);
		    r.delay(5000);
		    
		    //Return to Claim Summary Screen
		    
		    //Claims History Verification
			driver.switchTo().frame(0);
			viewHistoryClaims(claimTemp);
			r.delay(5000);
			//Claims History Details Verification
			viewHistoricalClaimsDetail(claimTemp);
		    r.delay(5000);
		    
		    // Go back to dashboard
		    driver.switchTo().defaultContent();
		    //driver.findElement(By.id("dashboard")).click();	    
		    //r.delay(5000);
		    
		    //Logout
		    SEPLoginLogout.logout();		    
		    LogbackFileUtils.stop();
		    
		    return returnObj;
		}catch(Throwable e){
			logger.error("Test Failure: " + e.toString());
			closeDriver();
			endTime = System.currentTimeMillis();
			buildTestStatusObj(true);
			LogbackFileUtils.stop();
			return returnObj;
		}	    
	}
	
	public static void viewOpenClaims(ClaimHistTemplate claimTemp){
		//Claims Open Verification
		verify("Test -- Verify the Claims Open header label text",By.xpath("//h2[contains(text(),'Open Claims')]"), claimTemp.getOpenClaimsLbl());
		verify("Test -- Verify the Claims Open Date of claim text",By.xpath("//table[@id='open_claims_table']/tbody/tr[1]/td[1]/a"), claimTemp.getOpenDateOfClaim());		
		verify("Test -- Verify the Claims Open Estimate Claim Completion Date text",By.xpath("//table[@id='open_claims_table']/tbody/tr[1]/td[2]"), claimTemp.getOpenEstClaimCompDate());		
		verify("Test -- Verify the Claims Open Status text",By.xpath("//table[@id='open_claims_table']/tbody/tr[1]/td[3]"), claimTemp.getOpenClaimStatus());		
		verify("Test -- Verify the Claims Open Type text",By.xpath("//table[@id='open_claims_table']/tbody/tr[1]/td[4]"), claimTemp.getOpenClaimType());		
		verify("Test -- Verify the Claims Open Updates text",By.xpath("//table[@id='open_claims_table']/tbody/tr[1]/td[5]/p"), claimTemp.getOpenClaimUpdates());	
		verify("Test -- Verify the Claims Open Actions text",By.xpath("//table[@id='open_claims_table']/tbody/tr[1]/td[6]/p/a"), claimTemp.getOpenClaimActions());
	}
	
	public static void viewHistoryClaims(ClaimHistTemplate claimTemp){
		//Claims History Verification
		verify("Test -- Verify the Claims Historical header label text",By.xpath("//h2[contains(text(),'Historical Claims')]"), claimTemp.getHstClaimsLbl());
		verify("Test -- Verify the Claims Historical Date of claim text",By.xpath("//table[@id='historical_claims_table']/tbody/tr[1]/td[1]/a"), claimTemp.getHstDateOfClaim());		
		verify("Test -- Verify the Claims Historical Type text",By.xpath("//table[@id='historical_claims_table']/tbody/tr[1]/td[2]"), claimTemp.getHstClaimType());		
		verify("Test -- Verify the Claims Historical Date closed text",By.xpath("//table[@id='historical_claims_table']/tbody/tr[1]/td[3]"), claimTemp.getHstClaimDateClosed());			
		verify("Test -- Verify the Claims Historical Updates text",By.xpath("//table[@id='historical_claims_table']/tbody/tr[1]/td[4]"), claimTemp.getHstClaimUpdates());	
	}
	
	public static void viewOpenClaimsDetail(ClaimHistTemplate claimTemp){
		// Click on one of the displayed "Payment Date(s)".
	    // Todo: add actions and validation for selecting and displaying Payment Details
	    driver.findElement(By.xpath("//table[@id='open_claims_table']/tbody/tr[1]/td[1]/a")).click(); //By.id("myeb_paymentHistoryGrp0")
	    r.delay(5000);
	    //Claims detail verification
	    verify("Test -- Verify the Claims Open Detail header label text",By.xpath("//div[@class='cp_header']/h2"), claimTemp.getClaimsDetailLbl());		
		verify("Test -- Verify the Claims Open Detail Received Date text",By.xpath("//div[@class='key-details']/p[@class='p column-1']"), claimTemp.getOpenDetailClaimReceivedDate());		
		verify("Test -- Verify the Claims Open Detail Type text",By.xpath("//div[@class='key-details']/p[@class='p column-1']"), claimTemp.getOpenDetailClaimType());
		//verify("Test -- Verify the Claims Open Detail Completed Date text",By.xpath("//div[@class='key-details']/p[@class='p column-1']"), claimTemp.getOpenDetailClaimCompletedDate());		
		verify("Test -- Verify the Claims Open Detail Estimate Completion Date text",By.xpath("//div[@class='key-details']/p[@class='p column-1']"), claimTemp.getOpenDetailEstClaimCompDate());		
		verify("Test -- Verify the Claims Open Detail Contentions text",By.xpath("//div[@class='key-details']/p[@class='p column-2']"), claimTemp.getOpenDetailClaimContentions());	
		verify("Test -- Verify the Claims Open Detail Temp Regional Office Jurisdiction text",By.xpath("//div[@class='more_information_inner full_height fixed_height']/ul/li/strong[contains(text(),'Temporary')]/../p"), claimTemp.getOpenDetailTmpRegOffJurisdiction());
		verify("Test -- Verify the Claims Open Detail Regional Office Jurisdiction text",By.xpath("//div[@class='more_information_inner full_height fixed_height']/ul/li/strong[contains(text(),'Regional')]/../p"), claimTemp.getOpenDetailRegOffJurisdiction());
		verify("Test -- Verify the Claims Open Detail Regional Office Jurisdiction MailAddress text",By.xpath("//div[@class='more_information_inner full_height fixed_height']/ul/li/strong[contains(text(),'Send Documentation')]/../p"), claimTemp.getOpenDetailRegOffJurisMailAdd());
		verify("Test -- Verify the Claims Open Detail Power Of Attorney text",By.xpath("//div[@class='more_information_inner full_height fixed_height']/ul/li/strong[contains(text(),'Attorney')]/../p"), claimTemp.getOpenDetailPowerOfAttorney());	
	}
	
	public static void viewHistoricalClaimsDetail(ClaimHistTemplate claimTemp){
		// Click on one of the displayed "Payment Date(s)".
	    // Todo: add actions and validation for selecting and displaying Payment Details
	    driver.findElement(By.xpath("//table[@id='historical_claims_table']/tbody/tr[1]/td[1]/a")).click(); //By.id("myeb_paymentHistoryGrp0")
	    r.delay(5000);
	    //Claims detail verification
	    verify("Test -- Verify the Claims Historical Detail Received Date text",By.xpath("//table[@id='payment_modifications']/tbody/tr[1]/td"), claimTemp.getHstDetailClaimReceivedDate());		
	    verify("Test -- Verify the Claims Historical Detail Type text",By.xpath("//table[@id='payment_modifications']/tbody/tr[8]/td"), claimTemp.getHstDetailClaimType());
	    verify("Test -- Verify the Claims Historical Detail Completed Date text",By.xpath("//table[@id='payment_modifications']/tbody/tr[2]/td"), claimTemp.getHstDetailClaimCompletedDate());		
		//verify("Test -- Verify the Claims Historical Detail Estimate Completion Date text",By.xpath("//table[@id='payment_modifications']/tbody/tr[3]/td"), claimTemp.getHstDetailEstClaimCompDate());		
		verify("Test -- Verify the Claims Historical Detail Contentions text",By.xpath("//table[@id='payment_modifications']/tbody/tr[4]/td"), claimTemp.getHstDetailClaimContentions());	
		//verify("Test -- Verify the Claims Historical Detail Temp Regional Office Jurisdiction text",By.xpath("//table[@id='payment_modifications']/tbody/tr[5]/td"), claimTemp.getHstDetailTmpRegOffJurisdiction());
		verify("Test -- Verify the Claims Historical Detail Regional Office Jurisdiction text",By.xpath("//div[@class='more_information_inner full_height fixed_height']/ul/li/strong[contains(text(),'Regional')]/../p"), claimTemp.getHstDetailRegOffJurisdiction());
		verify("Test -- Verify the Claims Historical Detail Regional Office Jurisdiction MailAddress text",By.xpath("//div[@class='more_information_inner full_height fixed_height']/ul/li/strong[contains(text(),'Send Documentation')]/../p"), claimTemp.getHstDetailRegOffJurisMailAdd());
		verify("Test -- Verify the Claims Historical Detail Power Of Attorney text",By.xpath("//div[@class='more_information_inner full_height fixed_height']/ul/li/strong[contains(text(),'Attorney')]/../p"), claimTemp.getHstDetailPowerOfAttorney());		
	}
}//end of class.
