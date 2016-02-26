package com.nabin;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLReader {
	
	public List<LoanDetails> readXL() throws Exception{
		List<LoanDetails> list= new ArrayList<LoanDetails>();
		FileInputStream file = new FileInputStream(new File("C:\\t.xls"));
					
		//Get the workbook instance for XLS file 
		org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);

		//Get first sheet from the workbook
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Data");

		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()){
			LoanDetails ld= new LoanDetails();
			Row row =rowIterator.next();
			//Get iterator to all cells of current row
			Cell cell = row.getCell(2);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING){
				System.out.println(cell.getStringCellValue());
			}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
				StringBuilder val=new StringBuilder(""+cell.getNumericCellValue());
				ld.setOfflineStorageId(Integer.parseInt(val.substring(0, val.indexOf("."))));
				System.out.println(cell.getNumericCellValue());
			}
		/*	System.out.println(" ");
			cell = row.getCell(8);
			
			if(cell.getCellType()==Cell.CELL_TYPE_STRING){
				System.out.print(cell.getStringCellValue());
			}
			else if(HSSFDateUtil.isCellDateFormatted(cell)){
				ld.setReturnDate(cell.getDateCellValue());
				System.out.print(cell.getDateCellValue());
			}
			System.out.println(" ");*/
			
		/*	cell = row.getCell(3);
			
			if(cell.getCellType()==Cell.CELL_TYPE_STRING){
				System.out.println(cell.getStringCellValue());
			}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
				StringBuilder val=new StringBuilder(""+cell.getNumericCellValue());
				String ref=null;
				if(val.indexOf("E")>0){
					ref=val.substring(0,val.indexOf("E"));
					int digitsAfterPoint =ref.length()-ref.indexOf(".")-1;
					String power= val.substring(val.indexOf("E")+1);
					//double d= new Double(ref) * Math.pow(10, Integer.parseInt(power));
					//System.out.println(d);
					val = new StringBuilder(ref.replace(".", ""));
					if(Integer.parseInt(power)>digitsAfterPoint){
						for(int k=(Integer.parseInt(power)-digitsAfterPoint);k>0;k--){
							val.append("0");
						}
					}
					
				}else if(val.indexOf(".")>0){
					val = new StringBuilder(val.toString().substring(0,val.indexOf(".")));
				}
				//ld.setLoanRefNumber(Integer.parseInt(val.substring(0, val.lastIndexOf("."))));
				ld.setLoanRefNumber(val.toString());
				System.out.println(cell.getNumericCellValue());
			}*/
			if(ld.getOfflineStorageId()>0){
				list.add(ld);
			}
		}
		return list;
	}

}
