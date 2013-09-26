package gov.va.sep.automatedtesting.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VDCFormTemplate {	
	
	private String fileUploadPath;		


	public VDCFormTemplate(Properties propFile){
		fileUploadPath = propFile.getProperty("fileUploadPath");			
		
	}	
	
	public String getFileUploadPath() {
		return fileUploadPath;
	}


	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}
	
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
