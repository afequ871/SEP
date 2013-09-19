package gov.va.sep.automatedtesting.utils;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.util.StatusPrinter;

public final class ResultsLogWatchMan extends TestWatchman {
	
	//Singleton (JUnit will go crazy and try to instantiate multiple of these
    private static class SingletonLoader {
        private static final ResultsLogWatchMan INSTANCE = new ResultsLogWatchMan();
    }
	
	private static Logger resultsLogger;
	
    public static ResultsLogWatchMan getInstance() {
        return SingletonLoader.INSTANCE;
    }
    
	private ResultsLogWatchMan() {
        if (SingletonLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
		
		String fileName = "TestResults-" +new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss").format(new Date())+".txt";
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
	    FileAppender fileAppender = new FileAppender();
	    fileAppender.setContext(loggerContext);
	    fileAppender.setName("resultsFile");
	    // set the file name
	    fileAppender.setFile("logs/" + fileName);
		
	    PatternLayoutEncoder encoder = new PatternLayoutEncoder();
	    encoder.setContext(loggerContext);
	    encoder.setPattern("%date{dd-MM-yyyy HH:mm:ss} ; %-40(%X{testSuiteName} - %X{testName}) -- %msg%n"); //TODO: add MDC values for expected and actual.
	    encoder.start();

	    fileAppender.setEncoder(encoder);
	    fileAppender.start();

	    // attach the rolling file appender to the logger of your choice
	    resultsLogger = loggerContext.getLogger("bbmi.testing.results"); //note: bbmi.testing.results is defined in logback.xml
	    resultsLogger.addAppender(fileAppender);

	    // OPTIONAL: print logback internal status messages
	    //StatusPrinter.print(loggerContext); //TODO: maybe turn off?
	}
	
	@Override
	public void succeeded(FrameworkMethod method) {
		setupMDC(method);
		resultsLogger.info("Pass");
	}

	@Override
	public void failed(Throwable t, FrameworkMethod method) {
		setupMDC(method);
		resultsLogger.info("Fail");
//		 resultsLogger.info( method.getName() + " -- Fail", t);
		// //log with stacktrace
	}

	private void setupMDC(FrameworkMethod method) {
		MDC.put("testName", method.getName());
		MDC.put("testSuiteName", getTestSuiteName(method));
	}

	private String getTestSuiteName(FrameworkMethod method) {
		String className = method.getMethod().getDeclaringClass().getName();
		className = className.substring(className.lastIndexOf('.') + 1,
				className.length());
		return className;
	}
}