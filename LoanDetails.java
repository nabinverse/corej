package com.nabin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanDetails {
	
	int loanIteamId;
	Date returnDate;
	String loanRefNumber;
	int offlineStorageId;
	public int getOfflineStorageId() {
		return offlineStorageId;
	}
	public void setOfflineStorageId(int offlineStorageId) {
		this.offlineStorageId = offlineStorageId;
	}
	public int getLoanIteamId() {
		return loanIteamId;
	}
	public void setLoanIteamId(int loanIteamId) {
		this.loanIteamId = loanIteamId;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getLoanRefNumber() {
		return loanRefNumber;
	}
	public void setLoanRefNumber(String loanRefNumber) {
		this.loanRefNumber = loanRefNumber;
	}
	
	public String getFormattedDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String retVal=sdf.format(this.getReturnDate());
		return retVal;
	}

}
