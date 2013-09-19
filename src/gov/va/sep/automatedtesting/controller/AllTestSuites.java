package gov.va.sep.automatedtesting.controller;

import java.util.HashMap;
//import java.util.logging.Level;
import java.util.logging.LogManager;


import gov.va.sep.automatedtesting.suites.*;
import gov.va.sep.automatedtesting.utils.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import ch.qos.logback.classic.Level;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	/*VeteranP1211.class ,
	VeteranP1011.class,
	BBMIgmail.class,
	Directemail.class,	
	BBMILookAndFeel.class,
	VeteranNegative.class,
	DirectemailErrorMsg.class*/})
public final class AllTestSuites {
	private static Logger logger ;
	
	public static void main(String[] args) throws InterruptedException {
		AllTestSuites mainClass = new AllTestSuites();	
		// Optionally remove existing handlers attached to j.u.l root logger
		SLF4JBridgeHandler.removeHandlersForRootLogger();  // (since SLF4J 1.6.5)
		SLF4JBridgeHandler.install();
		LogManager.getLogManager().getLogger("").setLevel(java.util.logging.Level.FINEST);		
		
		logger = LoggerFactory.getLogger(mainClass.getClass());
		LogbackFileUtils.start(mainClass.getClass());
		
		logger.info("--------- SEP Test Suites ----------");
		printResults(new SEPLoginLogout().LoginLogout());
		Thread.sleep(5000);
		printResults(new SEPSearchVerification().SEPSearchVet());
		Thread.sleep(5000);
		printResults(new SEPPaymentHistory().PaymentHistory());
		printResults(new SEPClaimHistory().ClaimHistory());
		printResults(new SEPVDCForms().RunAllForms());
		LogbackFileUtils.stop();
	}
	
	public static void printResults(HashMap result){
		logger.info(result.get("testName") + "\t" + result.get("totalTime")  + "\t" + result.get("result"));
	}
}
