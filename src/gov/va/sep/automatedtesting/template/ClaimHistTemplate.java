package gov.va.sep.automatedtesting.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClaimHistTemplate {	
	
	private String statusClaimsLbl;	
	
	private String openClaimsLbl;
	private String openDateOfClaim;
	private String openEstClaimCompDate;
	private String openClaimStatus;
	private String openClaimType;
	private String openClaimUpdates;
	private String openClaimActions;
	
	private String hstClaimsLbl;
	private String hstDateOfClaim;
	private String hstClaimType;
	private String hstClaimDateClosed;
	private String hstClaimUpdates;	
	
	private String claimsDetailLbl;
	private String openDetailClaimReceivedDate;
	private String openDetailClaimCompletedDate;
	private String openDetailEstClaimCompDate;
	private String openDetailClaimType;
	private String openDetailClaimContentions;
	private String openDetailTmpRegOffJurisdiction;
	private String openDetailRegOffJurisdiction;
	private String openDetailRegOffJurisMailAdd;
	private String openDetailPowerOfAttorney;
	
	private String hstDetailClaimReceivedDate;
	private String hstDetailClaimCompletedDate;
	private String hstDetailEstClaimCompDate;
	private String hstDetailClaimType;
	private String hstDetailClaimContentions;
	private String hstDetailTmpRegOffJurisdiction;
	private String hstDetailRegOffJurisdiction;
	private String hstDetailRegOffJurisMailAdd;
	private String hstDetailPowerOfAttorney;
	
	public ClaimHistTemplate(Properties propFile){
		statusClaimsLbl = propFile.getProperty("statusClaimsLbl");
		
		openClaimsLbl = propFile.getProperty("openClaimsLbl");
		openDateOfClaim = propFile.getProperty("openDateOfClaim");
		openEstClaimCompDate = propFile.getProperty("openEstClaimCompDate");
		openClaimStatus = propFile.getProperty("openClaimStatus");
		openClaimType = propFile.getProperty("openClaimType");
		openClaimUpdates = propFile.getProperty("openClaimUpdates");
		openClaimActions = propFile.getProperty("openClaimActions");
		
		hstClaimsLbl = propFile.getProperty("hstClaimsLbl");
		hstDateOfClaim = propFile.getProperty("hstDateOfClaim");
		hstClaimType = propFile.getProperty("hstClaimType");
		hstClaimDateClosed = propFile.getProperty("hstClaimDateClosed");
		hstClaimUpdates = propFile.getProperty("hstClaimUpdates");
		
		claimsDetailLbl = propFile.getProperty("claimsDetailLbl");
		openDetailClaimReceivedDate = propFile.getProperty("openDetailClaimReceivedDate");
		openDetailClaimCompletedDate = propFile.getProperty("openDetailClaimCompletedDate");
		openDetailEstClaimCompDate = propFile.getProperty("openDetailEstClaimCompDate");
		openDetailClaimContentions = propFile.getProperty("openDetailClaimContentions");
		openDetailTmpRegOffJurisdiction = propFile.getProperty("openDetailTmpRegOffJurisdiction");
		openDetailRegOffJurisdiction = propFile.getProperty("openDetailRegOffJurisdiction");
		openDetailRegOffJurisMailAdd = propFile.getProperty("openDetailRegOffJurisMailAdd");
		openDetailPowerOfAttorney = propFile.getProperty("openDetailPowerOfAttorney");
		openDetailClaimType = propFile.getProperty("openDetailClaimType");
		
		hstDetailClaimReceivedDate = propFile.getProperty("hstDetailClaimReceivedDate");
		hstDetailClaimCompletedDate = propFile.getProperty("hstDetailClaimCompletedDate");
		hstDetailEstClaimCompDate = propFile.getProperty("hstDetailEstClaimCompDate");
		hstDetailClaimContentions = propFile.getProperty("hstDetailClaimContentions");
		hstDetailTmpRegOffJurisdiction = propFile.getProperty("hstDetailTmpRegOffJurisdiction");
		hstDetailRegOffJurisdiction = propFile.getProperty("hstDetailRegOffJurisdiction");
		hstDetailRegOffJurisMailAdd = propFile.getProperty("hstDetailRegOffJurisMailAdd");
		hstDetailPowerOfAttorney = propFile.getProperty("hstDetailPowerOfAttorney");
		hstDetailClaimType = propFile.getProperty("hstDetailClaimType");		
		
	}	
	
	public String getStatusClaimsLbl() {
		return statusClaimsLbl;
	}


	public void setStatusClaimsLbl(String statusClaimsLbl) {
		this.statusClaimsLbl = statusClaimsLbl;
	}


	public String getOpenClaimsLbl() {
		return openClaimsLbl;
	}


	public void setOpenClaimsLbl(String openClaimsLbl) {
		this.openClaimsLbl = openClaimsLbl;
	}


	public String getOpenDateOfClaim() {
		return openDateOfClaim;
	}


	public void setOpenDateOfClaim(String openDateOfClaim) {
		this.openDateOfClaim = openDateOfClaim;
	}


	public String getOpenEstClaimCompDate() {
		return openEstClaimCompDate;
	}


	public void setOpenEstClaimCompDate(String openEstClaimCompDate) {
		this.openEstClaimCompDate = openEstClaimCompDate;
	}


	public String getOpenClaimStatus() {
		return openClaimStatus;
	}


	public void setOpenClaimStatus(String openClaimStatus) {
		this.openClaimStatus = openClaimStatus;
	}


	public String getOpenClaimType() {
		return openClaimType;
	}


	public void setOpenClaimType(String openClaimType) {
		this.openClaimType = openClaimType;
	}


	public String getOpenClaimUpdates() {
		return openClaimUpdates;
	}


	public void setOpenClaimUpdates(String openClaimUpdates) {
		this.openClaimUpdates = openClaimUpdates;
	}


	public String getOpenClaimActions() {
		return openClaimActions;
	}


	public void setOpenClaimActions(String openClaimActions) {
		this.openClaimActions = openClaimActions;
	}


	public String getHstClaimsLbl() {
		return hstClaimsLbl;
	}


	public void setHstClaimsLbl(String hstClaimsLbl) {
		this.hstClaimsLbl = hstClaimsLbl;
	}


	public String getHstDateOfClaim() {
		return hstDateOfClaim;
	}


	public void setHstDateOfClaim(String hstDateOfClaim) {
		this.hstDateOfClaim = hstDateOfClaim;
	}


	public String getHstClaimType() {
		return hstClaimType;
	}


	public void setHstClaimType(String hstClaimType) {
		this.hstClaimType = hstClaimType;
	}


	public String getHstClaimDateClosed() {
		return hstClaimDateClosed;
	}


	public void setHstClaimDateClosed(String hstClaimDateClosed) {
		this.hstClaimDateClosed = hstClaimDateClosed;
	}


	public String getHstClaimUpdates() {
		return hstClaimUpdates;
	}


	public void setHstClaimUpdates(String hstClaimUpdates) {
		this.hstClaimUpdates = hstClaimUpdates;
	}


	public String getClaimsDetailLbl() {
		return claimsDetailLbl;
	}


	public void setClaimsDetailLbl(String claimsDetailLbl) {
		this.claimsDetailLbl = claimsDetailLbl;
	}


	public String getOpenDetailClaimReceivedDate() {
		return openDetailClaimReceivedDate;
	}


	public void setOpenDetailClaimReceivedDate(String openDetailClaimReceivedDate) {
		this.openDetailClaimReceivedDate = openDetailClaimReceivedDate;
	}


	public String getOpenDetailClaimCompletedDate() {
		return openDetailClaimCompletedDate;
	}


	public void setOpenDetailClaimCompletedDate(String openDetailClaimCompletedDate) {
		this.openDetailClaimCompletedDate = openDetailClaimCompletedDate;
	}


	public String getOpenDetailEstClaimCompDate() {
		return openDetailEstClaimCompDate;
	}


	public void setOpenDetailEstClaimCompDate(String openDetailEstClaimCompDate) {
		this.openDetailEstClaimCompDate = openDetailEstClaimCompDate;
	}


	public String getOpenDetailClaimType() {
		return openDetailClaimType;
	}


	public void setOpenDetailClaimType(String openDetailClaimType) {
		this.openDetailClaimType = openDetailClaimType;
	}


	public String getOpenDetailClaimContentions() {
		return openDetailClaimContentions;
	}


	public void setOpenDetailClaimContentions(String openDetailClaimContentions) {
		this.openDetailClaimContentions = openDetailClaimContentions;
	}


	public String getOpenDetailTmpRegOffJurisdiction() {
		return openDetailTmpRegOffJurisdiction;
	}


	public void setOpenDetailTmpRegOffJurisdiction(
			String openDetailTmpRegOffJurisdiction) {
		this.openDetailTmpRegOffJurisdiction = openDetailTmpRegOffJurisdiction;
	}


	public String getOpenDetailRegOffJurisdiction() {
		return openDetailRegOffJurisdiction;
	}


	public void setOpenDetailRegOffJurisdiction(String openDetailRegOffJurisdiction) {
		this.openDetailRegOffJurisdiction = openDetailRegOffJurisdiction;
	}


	public String getOpenDetailRegOffJurisMailAdd() {
		return openDetailRegOffJurisMailAdd;
	}


	public void setOpenDetailRegOffJurisMailAdd(String openDetailRegOffJurisMailAdd) {
		this.openDetailRegOffJurisMailAdd = openDetailRegOffJurisMailAdd;
	}


	public String getOpenDetailPowerOfAttorney() {
		return openDetailPowerOfAttorney;
	}


	public void setOpenDetailPowerOfAttorney(String openDetailPowerOfAttorney) {
		this.openDetailPowerOfAttorney = openDetailPowerOfAttorney;
	}


	public String getHstDetailClaimReceivedDate() {
		return hstDetailClaimReceivedDate;
	}


	public void setHstDetailClaimReceivedDate(String hstDetailClaimReceivedDate) {
		this.hstDetailClaimReceivedDate = hstDetailClaimReceivedDate;
	}


	public String getHstDetailClaimCompletedDate() {
		return hstDetailClaimCompletedDate;
	}


	public void setHstDetailClaimCompletedDate(String hstDetailClaimCompletedDate) {
		this.hstDetailClaimCompletedDate = hstDetailClaimCompletedDate;
	}


	public String getHstDetailEstClaimCompDate() {
		return hstDetailEstClaimCompDate;
	}


	public void setHstDetailEstClaimCompDate(String hstDetailEstClaimCompDate) {
		this.hstDetailEstClaimCompDate = hstDetailEstClaimCompDate;
	}


	public String getHstDetailClaimType() {
		return hstDetailClaimType;
	}


	public void setHstDetailClaimType(String hstDetailClaimType) {
		this.hstDetailClaimType = hstDetailClaimType;
	}


	public String getHstDetailClaimContentions() {
		return hstDetailClaimContentions;
	}


	public void setHstDetailClaimContentions(String hstDetailClaimContentions) {
		this.hstDetailClaimContentions = hstDetailClaimContentions;
	}


	public String getHstDetailTmpRegOffJurisdiction() {
		return hstDetailTmpRegOffJurisdiction;
	}


	public void setHstDetailTmpRegOffJurisdiction(
			String hstDetailTmpRegOffJurisdiction) {
		this.hstDetailTmpRegOffJurisdiction = hstDetailTmpRegOffJurisdiction;
	}


	public String getHstDetailRegOffJurisdiction() {
		return hstDetailRegOffJurisdiction;
	}


	public void setHstDetailRegOffJurisdiction(String hstDetailRegOffJurisdiction) {
		this.hstDetailRegOffJurisdiction = hstDetailRegOffJurisdiction;
	}


	public String getHstDetailRegOffJurisMailAdd() {
		return hstDetailRegOffJurisMailAdd;
	}


	public void setHstDetailRegOffJurisMailAdd(String hstDetailRegOffJurisMailAdd) {
		this.hstDetailRegOffJurisMailAdd = hstDetailRegOffJurisMailAdd;
	}


	public String getHstDetailPowerOfAttorney() {
		return hstDetailPowerOfAttorney;
	}


	public void setHstDetailPowerOfAttorney(String hstDetailPowerOfAttorney) {
		this.hstDetailPowerOfAttorney = hstDetailPowerOfAttorney;
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
