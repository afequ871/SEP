package gov.va.sep.automatedtesting;


import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AutomatedTestingSuite {

	//should all be thread safe since there won't be multiple threads touching the same TestSuite class
	protected static Logger logger; //logger called by the tests manually
	protected static WebDriver driver; //TODO: do we want a new instance of this each time, or should this be singleton?
	protected static Screen s;
	protected static Robot r;
	protected static Properties props;
	protected static boolean fireFoxDriverSelected;
	@Rule
	public ResultsLogWatchMan resultLogWatchMan = ResultsLogWatchMan.getInstance();
	

	
	public AutomatedTestingSuite() {
		
		// Add to the desired logger
		logger = LoggerFactory.getLogger("sep.testing.results");
		
		fireFoxDriverSelected = Boolean.parseBoolean(getProperties().getProperty("FireFoxDriver"));
		if (fireFoxDriverSelected)
			setupFirefoxDriver();
		else
			setupIEDriver();
		

	}
	
	

	
	
	public static void setupFirefoxDriver() {
		
		
		
		DesiredCapabilities caps = DesiredCapabilities.firefox(); 
		LoggingPreferences logs = new LoggingPreferences(); 
		logs.enable(LogType.DRIVER, Level.ALL); 
		caps.setCapability(CapabilityType.LOGGING_PREFS, logs); 
		driver = new FirefoxDriver(caps);
		driver.manage().window().maximize();
		//driver = new FirefoxDriver();
		
		s = new Screen();
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public static void closeDriver() {
		driver.quit();
	}
	
	
	public static void setupIEDriver() {
		
		//TODO: see if we can get selenium to record all of its events (ie: click, wait, etc) by default
		
		File file = new File("C:/SeliniumDrivers/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		
		LoggingPreferences logs = new LoggingPreferences(); 
		logs.enable(LogType.DRIVER, Level.ALL); 
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer(); 
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
		
		caps.setCapability(CapabilityType.LOGGING_PREFS, logs); 
		
		
			driver	=	new InternetExplorerDriver(caps);
			
	
		try {
			s = new Screen();
			r = new Robot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//utility methods
	public  static void refreshDriver() {		
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getLocalizedMessage());
		}
	}

	//TODO: shouldn't be loading properties in each time. Should make a properties singleton
	public Properties getProperties() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("suite.properties");
		try {
			prop.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return prop;
	}
	
	public String getSecureEmailLinkFromGmail() throws Exception{
		String emailLink	=	null;
		try{
	        	Properties props = System.getProperties();
	        	props.setProperty("mail.store.protocol", "imaps");

	            Session session = Session.getDefaultInstance(props, null);
	            Store store = session.getStore("imaps");
	            store.connect("imap.gmail.com", "bbmitestuser","bbmitest123");

	            Folder folder = store.getFolder("INBOX");
	            folder.open(Folder.READ_WRITE);

	           // System.out.println("Total Message:" + folder.getMessageCount());
	           // System.out.println("Unread Message:"+ folder.getUnreadMessageCount());
	            
	            Message[] messages = null;
	            boolean isMailFound = false;
	            Message mailFromGod= null;

	            //Search for mail from God
	            for (int i = 0; i < 5; i++) {
	                messages = folder.search(new SubjectTerm(
	                        "Notification of new Direct email message"),
	                        folder.getMessages());
	                //Wait for 10 seconds
	                if (messages.length == 0) {
	                    Thread.sleep(10000);
	                }
	            }

	            //Search for unread mail from God
	            //This is to avoid using the mail for which 
	            //Registration is already done
	            for (Message mail : messages) {
	                if (!mail.isSet(Flags.Flag.SEEN)) {
	                    mailFromGod = mail;
//	                    System.out.println("Message Count is: "+ mailFromGod.getMessageNumber());
	                    isMailFound = true;
	                }
	            }

	            //Test fails if no unread mail was found from God
	            if (!isMailFound) {
	                throw new Exception(
	                        "Could not find new mail from God :-(");
	            
	            //Read the content of mail and launch registration URL                
	            } else {
	                String line;
	                StringBuffer buffer = new StringBuffer();
	                BufferedReader reader = new BufferedReader(
	                        new InputStreamReader(mailFromGod
	                                .getInputStream()));
	                while ((line = reader.readLine()) != null) {
	                    buffer.append(line);
	                }
	                //System.out.println(buffer.toString());

	                //Your logic to split the message and get the Registration URL goes here
//	                String registrationURL = buffer.toString().split("https://158.147.211.124/<wbr>JavaBridge/mail/src/login.php")[0].split("href=")[1];
	                emailLink	=	buffer.toString().substring(buffer.toString().indexOf("https://"));
	                System.out.println("registrationURL--->"+emailLink);                            
	            }
	    
		}catch(Exception e){
			e.printStackTrace();
		}
		return emailLink.trim();
	}
}
