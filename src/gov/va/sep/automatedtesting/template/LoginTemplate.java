package gov.va.sep.automatedtesting.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginTemplate {	
	
	private String loginHeaderLbl;	
	private String loginNortonBtnLbl;
	
	private String loginContinueHeaderLbl;
	private String loginContinueBtnLbl;
	
	private String loginPleaseSignInHeaderLbl;
	private String loginSignInBtnLbl;	
	private String loginEmailAddress;
	private String loginPassword;
	
	private String loginSecurityCodeHeaderLbl;
	private String loginSecurityCodeCellNumber;
	
	private String loginEnterSecurityCodeHeaderLbl;
	
	public LoginTemplate(Properties propFile){
		loginHeaderLbl = propFile.getProperty("loginHeaderLbl");
		loginNortonBtnLbl = propFile.getProperty("loginNortonBtnLbl");
		
		loginContinueHeaderLbl = propFile.getProperty("loginContinueHeaderLbl");
		loginContinueBtnLbl = propFile.getProperty("loginContinueBtnLbl");
		
		loginPleaseSignInHeaderLbl = propFile.getProperty("loginPleaseSignInHeaderLbl");
		loginSignInBtnLbl = propFile.getProperty("loginSignInBtnLbl");		
		loginEmailAddress = propFile.getProperty("loginEmailAddress");
		loginPassword = propFile.getProperty("loginPassword");
		
		loginSecurityCodeHeaderLbl = propFile.getProperty("loginSecurityCodeHeaderLbl");
		loginSecurityCodeCellNumber = propFile.getProperty("loginSecurityCodeCellNumber");
		
		loginEnterSecurityCodeHeaderLbl = propFile.getProperty("loginEnterSecurityCodeHeaderLbl");
		
	}
	
	public String getLoginHeaderLbl() {
		return loginHeaderLbl;
	}



	public void setLoginHeaderLbl(String loginHeaderLbl) {
		this.loginHeaderLbl = loginHeaderLbl;
	}



	public String getLoginNortonBtnLbl() {
		return loginNortonBtnLbl;
	}



	public void setLoginNortonBtnLbl(String loginNortonBtnLbl) {
		this.loginNortonBtnLbl = loginNortonBtnLbl;
	}



	public String getLoginContinueHeaderLbl() {
		return loginContinueHeaderLbl;
	}



	public void setLoginContinueHeaderLbl(String loginContinueHeaderLbl) {
		this.loginContinueHeaderLbl = loginContinueHeaderLbl;
	}



	public String getLoginContinueBtnLbl() {
		return loginContinueBtnLbl;
	}



	public void setLoginContinueBtnLbl(String loginContinueBtnLbl) {
		this.loginContinueBtnLbl = loginContinueBtnLbl;
	}



	public String getLoginPleaseSignInHeaderLbl() {
		return loginPleaseSignInHeaderLbl;
	}



	public void setLoginPleaseSignInHeaderLbl(String loginPleaseSignInHeaderLbl) {
		this.loginPleaseSignInHeaderLbl = loginPleaseSignInHeaderLbl;
	}



	public String getLoginSignInBtnLbl() {
		return loginSignInBtnLbl;
	}



	public void setLoginSignInBtnLbl(String loginSignInBtnLbl) {
		this.loginSignInBtnLbl = loginSignInBtnLbl;
	}



	public String getLoginEmailAddress() {
		return loginEmailAddress;
	}



	public void setLoginEmailAddress(String loginEmailAddress) {
		this.loginEmailAddress = loginEmailAddress;
	}



	public String getLoginPassword() {
		return loginPassword;
	}



	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}



	public String getLoginSecurityCodeHeaderLbl() {
		return loginSecurityCodeHeaderLbl;
	}



	public void setLoginSecurityCodeHeaderLbl(String loginSecurityCodeHeaderLbl) {
		this.loginSecurityCodeHeaderLbl = loginSecurityCodeHeaderLbl;
	}



	public String getLoginSecurityCodeCellNumber() {
		return loginSecurityCodeCellNumber;
	}



	public void setLoginSecurityCodeCellNumber(String loginSecurityCodeCellNumber) {
		this.loginSecurityCodeCellNumber = loginSecurityCodeCellNumber;
	}



	public String getLoginEnterSecurityCodeHeaderLbl() {
		return loginEnterSecurityCodeHeaderLbl;
	}



	public void setLoginEnterSecurityCodeHeaderLbl(
			String loginEnterSecurityCodeHeaderLbl) {
		this.loginEnterSecurityCodeHeaderLbl = loginEnterSecurityCodeHeaderLbl;
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
