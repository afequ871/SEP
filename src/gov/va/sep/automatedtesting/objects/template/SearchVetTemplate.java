package gov.va.sep.automatedtesting.objects.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SearchVetTemplate {	
	
	private String searchHeaderLbl;	
	private String searchSSNLbl;
	private String searchSSN;
	private String searchForVetLbl;
	
	private String searchResultsHeaderLbl;
	private String searchResultVetName;
	private String searchResultVetDOB;
	private String searchResultVetSSN;
	private String searchResultVetLocation;
	private String searchResultVetRepThrough;
	
	public SearchVetTemplate(Properties propFile){
		searchHeaderLbl = propFile.getProperty("searchHeaderLbl");
		searchSSNLbl = propFile.getProperty("searchSSNLbl");
		searchSSN = propFile.getProperty("searchSSN");
		searchForVetLbl = propFile.getProperty("searchForVetLbl");
		
		searchResultsHeaderLbl = propFile.getProperty("searchResultsHeaderLbl");
		searchResultVetName = propFile.getProperty("searchResultVetName");
		searchResultVetDOB = propFile.getProperty("searchResultVetDOB");
		searchResultVetSSN = propFile.getProperty("searchResultVetSSN");
		searchResultVetLocation = propFile.getProperty("searchResultVetLocation");
		searchResultVetRepThrough = propFile.getProperty("searchResultVetRepThrough");
		
	}
	
	public String getSearchHeaderLbl() {
		return searchHeaderLbl;
	}



	public void setSearchHeaderLbl(String searchHeaderLbl) {
		this.searchHeaderLbl = searchHeaderLbl;
	}



	public String getSearchSSNLbl() {
		return searchSSNLbl;
	}



	public void setSearchSSNLbl(String searchSSNLbl) {
		this.searchSSNLbl = searchSSNLbl;
	}



	public String getSearchSSN() {
		return searchSSN;
	}



	public void setSearchSSN(String searchSSN) {
		this.searchSSN = searchSSN;
	}



	public String getSearchForVetLbl() {
		return searchForVetLbl;
	}



	public void setSearchForVetLbl(String searchForVetLbl) {
		this.searchForVetLbl = searchForVetLbl;
	}



	public String getSearchResultsHeaderLbl() {
		return searchResultsHeaderLbl;
	}



	public void setSearchResultsHeaderLbl(String searchResultsHeaderLbl) {
		this.searchResultsHeaderLbl = searchResultsHeaderLbl;
	}



	public String getSearchResultVetName() {
		return searchResultVetName;
	}



	public void setSearchResultVetName(String searchResultVetName) {
		this.searchResultVetName = searchResultVetName;
	}



	public String getSearchResultVetDOB() {
		return searchResultVetDOB;
	}



	public void setSearchResultVetDOB(String searchResultVetDOB) {
		this.searchResultVetDOB = searchResultVetDOB;
	}



	public String getSearchResultVetSSN() {
		return searchResultVetSSN;
	}



	public void setSearchResultVetSSN(String searchResultVetSSN) {
		this.searchResultVetSSN = searchResultVetSSN;
	}



	public String getSearchResultVetLocation() {
		return searchResultVetLocation;
	}



	public void setSearchResultVetLocation(String searchResultVetLocation) {
		this.searchResultVetLocation = searchResultVetLocation;
	}



	public String getSearchResultVetRepThrough() {
		return searchResultVetRepThrough;
	}



	public void setSearchResultVetRepThrough(String searchResultVetRepThrough) {
		this.searchResultVetRepThrough = searchResultVetRepThrough;
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
