package resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f  = new File("C:\\Users\\IBM_ADMIN\\Desktop\\upload\\"+"t.csv");
		Map<String,String> map = new HashMap<String,String>();
		Map<String,String> map2 = new HashMap<String,String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s="";
			while((s=br.readLine())!=null){
				String[] res= s.split(",");
				map.put(res[0],res[1]);
			}
			File f1  = new File("C:\\Users\\IBM_ADMIN\\Desktop\\upload\\"+"r.txt");
			File f3  = new File("C:\\Users\\IBM_ADMIN\\Desktop\\upload\\"+"out.csv");
			
			BufferedReader br2 = new BufferedReader(new FileReader(f1));
			String ss="";
			while((ss=br2.readLine())!=null){
				String val =map.get("\""+ss+"\"");
				StringBuilder sb = new StringBuilder(val);
				String result = sb.insert(4, "-").insert(7, "-").toString();
				map2.put(ss, result);
				System.out.println(ss+ " , "+result);
				
			}
			System.out.println(map2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
