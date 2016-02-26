package com.nabin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class EditTemplate {

	public static void main(String[] args) {
		
		List<String> libasic = new ArrayList<String>();
		
		String fileName="C://input.txt";
		String template=readTemplate(fileName);
		
		List<String> spoolUUIDS= getSpoolUUIDs();
		
		for(String uuid:spoolUUIDS){
			
			String message = template.replaceAll("UUUUUUIIIIIIDDDDDD", uuid.trim());
			writeToFile(message,uuid.trim());
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private static void writeToFile(String message, String uuid) {
		long time=Calendar.getInstance().getTime().getTime();
		File file = new File("C://output//output_message_"+uuid+"_"+time+".xml");
		
		try{
			file.createNewFile();
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			br.write(message);
			br.flush();
			br.close();
		}catch(Exception e){
			System.out.println("Hello Exception on template reading : "+e.getMessage());
		}
	}

	private static List<String> getSpoolUUIDs() {
		List<String> spoolUUIDs= new ArrayList<String>();
	//	File inputUUID = new File("C://inputUUID.txt");
		try{
			
		/*	BufferedReader br = new BufferedReader(new FileReader(inputUUID));
			String s=null;
			while((s=br.readLine())!=null){
				String up=s.trim();
				if(!spoolUUIDs.contains(up)){
					spoolUUIDs.add(up);
				}
				}*/
			
			XLReader xr= new XLReader();
			spoolUUIDs = DatabaseActivity.getSpoolUUIDs(xr.readXL());
		}catch(Exception e){
			System.out.println("Hello Exception on getSpoolUUIDs : "+e.getMessage());
		}
		
		return spoolUUIDs;
	}

	private static String readTemplate(String fileName) {
		
		File template = new File(fileName);
		StringBuilder sb= new StringBuilder("");
		String s="";
		try{
			
			BufferedReader br = new BufferedReader(new FileReader(template));
			while((s=br.readLine())!=null){
				sb.append(s);
				}
		}catch(Exception e){
			System.out.println("Hello Exception on template reading : "+e.getMessage());
		}
		// TODO Auto-generated method stub
		return sb.toString();
	}

}

