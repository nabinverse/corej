package com.nabin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class DatabaseActivity {
	public static Connection connection = null;
	public static Connection getConnection(){
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		try {
			
			//cloud
			//connection = DriverManager.getConnection("jdbc:db2://localhost:60000/EM3T1COR","em3appdb", "aipIbvp5jc1TWXs");
			//stage
			connection = DriverManager.getConnection("jdbc:db2://localhost:60000/EM3SGCOR","em3appdb", "B6wRO4N21OgpLSL");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return connection;
	}
	
	public static void updateLoanAndItem(List<LoanDetails> list){
		
		String sqlLoanItem="";
		String sqlLoan="";
		Statement stm;
		List<String> loanIteamLines= new ArrayList<String>();
		List<String> loanLines= new ArrayList<String>();
		try {
			File loanItemUpdateFile= FileUtils.getFile("C://loalItemUpdate2.sql");
			File loanUpdateFile= FileUtils.getFile("C://loalUpdate2.sql");
			//stm = getConnection().createStatement();
			int i=1;
			for(LoanDetails ld:list){
				sqlLoanItem="update stm.LOAN_ITEM set REF_LOAN_ITEM_STATUS_ID=7,RETURNED_DATE='"+ld.getFormattedDate()+"' where OFFLINE_STORAGE_ID="+ld.getOfflineStorageId()+" and LOAN_ID in (select ID from stm.loan where REFERENCE_NUMBER="+ld.getLoanRefNumber()+")" ;
				sqlLoan="update stm.loan set REF_LOAN_STATUS_ID=4 where REFERENCE_NUMBER="+ld.getLoanRefNumber();
				//stm.executeUpdate(sqlLoanItem);
				//stm.executeUpdate(sqlLoan);
				System.out.println("Loan Item Update :"+i+" "+sqlLoanItem);
				System.out.println("Loan Update :"+i+" "+sqlLoan);
				loanLines.add(sqlLoan);
				loanIteamLines.add(sqlLoanItem);
				i++;
			}
			FileUtils.writeLines(loanItemUpdateFile, loanIteamLines);
			FileUtils.writeLines(loanUpdateFile, loanLines);
		}catch(Exception ex){
			System.out.println("OPPPSSSSSSSS...");
			System.out.println("First query : "+sqlLoanItem);
			System.out.println("Second query : "+sqlLoan);
			ex.printStackTrace();
		}
	}
	
	public static List<String> getSpoolUUIDs(List<LoanDetails> list){
		List<String> spoolUUIDs = new ArrayList<String>();
		String spoolID="";
		int i=0;
		for(LoanDetails ld:list){
			spoolID =spoolID+ld.getOfflineStorageId()+",";
			i++;
		}
		spoolID=spoolID.substring(0, spoolID.length()-1);
		System.out.println("spool id "+spoolID);
		try {
			Statement stm = getConnection().createStatement();
			String sql="Select UUID from stm.offline_storage where ID in ("+spoolID+")";			
			System.out.println("sql : "+sql);
		    ResultSet rs =	stm.executeQuery(sql);
		    while(rs.next()){
		    	String uuid =rs.getString("UUID");
		    	spoolUUIDs.add(uuid);
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return spoolUUIDs;
	}

}
