package gov.va.sep.automatedtesting.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PaymentHistTemplate {	
	
	private String hstPaymentHistLbl;	
	private String hstPaymentSumTblCol1;	
	private String hstPaymentSumTblCol2;
	private String hstPaymentSumTblCol3;
	private String hstPaymentSumTblCol4;
	
	private String hstPaymentDetailLbl;
	private String hstDetailPaymentAmount;	
	private String hstDetailPaymentDate;
	private String hstDetailPaymentType;
	private String hstDetailPaymentMethod;
	private String hstDetailCheckRecipient;	
	private String hstDetailAddressLine1;
	private String hstDetailAddressLine2;
	private String hstDetailZipCode;
	
	private String hstNoPaymentDetail;
	
	public PaymentHistTemplate(Properties propFile){
		hstPaymentHistLbl = propFile.getProperty("hstPaymentHistLbl");
		hstPaymentSumTblCol1 = propFile.getProperty("hstPaymentSumTblCol1");
		hstPaymentSumTblCol2 = propFile.getProperty("hstPaymentSumTblCol2");
		hstPaymentSumTblCol3 = propFile.getProperty("hstPaymentSumTblCol3");
		hstPaymentSumTblCol4 = propFile.getProperty("hstPaymentSumTblCol4");
		
		hstPaymentDetailLbl = propFile.getProperty("hstPaymentDetailLbl");
		hstDetailPaymentAmount = propFile.getProperty("hstDetailPaymentAmount");
		hstDetailPaymentDate = propFile.getProperty("hstDetailPaymentDate");
		hstDetailPaymentType = propFile.getProperty("hstDetailPaymentType");
		hstDetailPaymentMethod = propFile.getProperty("hstDetailPaymentMethod");
		hstDetailCheckRecipient = propFile.getProperty("hstDetailCheckRecipient");
		hstDetailAddressLine1 = propFile.getProperty("hstDetailAddressLine1");
		hstDetailAddressLine2 = propFile.getProperty("hstDetailAddressLine2");
		hstDetailZipCode = propFile.getProperty("hstDetailZipCode");
		
		hstNoPaymentDetail = propFile.getProperty("hstNoPaymentDetail");
	}	
	public String getHstPaymentHistLbl() {
		return hstPaymentHistLbl;
	}
	public void setHstPaymentHistLbl(String hstPaymentLbl) {
		this.hstPaymentHistLbl = hstPaymentLbl;
	}
	public String getHstPaymentSumTblCol1() {
		return hstPaymentSumTblCol1;
	}

	public void setHstPaymentSumTblCol1(String hstPaymentSumTblCol1) {
		this.hstPaymentSumTblCol1 = hstPaymentSumTblCol1;
	}

	public String getHstPaymentSumTblCol2() {
		return hstPaymentSumTblCol2;
	}

	public void setHstPaymentSumTblCol2(String hstPaymentSumTblCol2) {
		this.hstPaymentSumTblCol2 = hstPaymentSumTblCol2;
	}

	public String getHstPaymentSumTblCol3() {
		return hstPaymentSumTblCol3;
	}

	public void setHstPaymentSumTblCol3(String hstPaymentSumTblCol3) {
		this.hstPaymentSumTblCol3 = hstPaymentSumTblCol3;
	}

	public String getHstPaymentSumTblCol4() {
		return hstPaymentSumTblCol4;
	}

	public void setHstPaymentSumTblCol4(String hstPaymentSumTblCol4) {
		this.hstPaymentSumTblCol4 = hstPaymentSumTblCol4;
	}
	
	public String getHstPaymentDetailLbl() {
		return hstPaymentDetailLbl;
	}

	public void setHstPaymentDetailLbl(String hstPaymentDetailLbl) {
		this.hstPaymentDetailLbl = hstPaymentDetailLbl;
	}
	public String getHstDetailPaymentAmount() {
		return hstDetailPaymentAmount;
	}

	public void setHstDetailPaymentAmount(String hstDetailPaymentAmount) {
		this.hstDetailPaymentAmount = hstDetailPaymentAmount;
	}
	public String getHstDetailPaymentDate() {
		return hstDetailPaymentDate;
	}

	public void setHstDetailPaymentDate(String hstDetailPaymentDate) {
		this.hstDetailPaymentDate = hstDetailPaymentDate;
	}

	public String getHstDetailPaymentType() {
		return hstDetailPaymentType;
	}

	public void setHstDetailPaymentType(String hstDetailPaymentType) {
		this.hstDetailPaymentType = hstDetailPaymentType;
	}

	public String getHstDetailPaymentMethod() {
		return hstDetailPaymentMethod;
	}

	public void setHstDetailPaymentMethod(String hstDetailPaymentMethod) {
		this.hstDetailPaymentMethod = hstDetailPaymentMethod;
	}
	public String getHstDetailCheckRecipient() {
		return hstDetailCheckRecipient;
	}

	public void setHstDetailCheckRecipient(String hstDetailCheckRecipient) {
		this.hstDetailCheckRecipient = hstDetailCheckRecipient;
	}

	public String getHstDetailAddressLine1() {
		return hstDetailAddressLine1;
	}

	public void setHstDetailAddressLine1(String hstDetailAddressLine1) {
		this.hstDetailAddressLine1 = hstDetailAddressLine1;
	}

	public String getHstDetailAddressLine2() {
		return hstDetailAddressLine2;
	}

	public void setHstDetailAddressLine2(String hstDetailAddressLine2) {
		this.hstDetailAddressLine2 = hstDetailAddressLine2;
	}

	public String getHstDetailZipCode() {
		return hstDetailZipCode;
	}

	public void setHstDetailZipCode(String hstDetailZipCode) {
		this.hstDetailZipCode = hstDetailZipCode;
	}
	public String getHstNoPaymentDetail() {
		return hstNoPaymentDetail;
	}

	public void setHstNoPaymentDetail(String hstNoPaymentDetail) {
		this.hstNoPaymentDetail = hstNoPaymentDetail;
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
