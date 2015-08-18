package resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.wink.common.model.multipart.InMultiPart;
import org.apache.wink.common.model.multipart.InPart;



@Path("/myservice")
public class FirstService {

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_XML)
	public Response returnStringResponse(){
		String returnStr = "Hello Nabin";
		//some more code
		
		OutputVO v = new OutputVO();
		v.setId("1234");
		v.setName("Nabin Mandal");
		v.setPhone(new String[]{"8697042514"});
		//some more code 
		Response res=null;
		try{
		 res=Response.status(200).entity(v).header("CustomHeader", "CustomHeader").build();
		}
		catch(Exception e){
			System.out.println(""+e.getMessage());
		}
		System.out.println("Done");
		return res;
	}
	@GET
	@Path("/test/{uuid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response second(@PathParam("uuid") String uuid){
		String returnStr = "Hello Nabin";
		System.out.println("you passed is : "+uuid);
		//code here
		
		return Response.status(200).entity(returnStr).header("CustomHeader", "CustomHeader").build();
	}
	
	@POST
	@Path("/p")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnEntityResponsePostJSON(){
		OutputVO outputVO = new OutputVO();
		outputVO.setId("100");
		outputVO.setName("NABIN");
		String[] phones = {"022","033","111"};
		String[] addresses = {"Kol","Delhi","Mumbai"};
		outputVO.setAddress(addresses);
		outputVO.setPhone(phones);
		return Response.status(200).entity(outputVO).header("CustomHeader", "CustomHeader").build();
	}
	
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(InMultiPart inMP){
		String fileName=null;
		try{
		while (inMP.hasNext()) {
			
	        InPart part = inMP.next();
	        MultivaluedMap<String, String> heades = part.getHeaders();
	       
	        String CDHeader = heades.getFirst("Content-Disposition");
	        String[] headers=CDHeader.split(";");
	        for(String header:headers){
	        	if(header.contains("filename")){
	        		fileName = header.split("=")[1];
	        		fileName =fileName.replaceAll("\"", "");
	        	}
	        }
	    	//File f  = new File("C:\\Users\\IBM_ADMIN\\Desktop\\upload\\"+fileName);
	        String workingDir = System.getProperty("user.dir");
	        String filePath = 
	        		new java.io.File( ".").getCanonicalPath()+"\\webapps\\upload\\";
	        		String filePath2 = new File(System.getProperty("catalina.base"))+ "\\webapps\\upload\\";
	        		
	        		/*File catalinaBase = new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile();
	        		File propertyFile = new File( catalinaBase, "\\webapps\\strsproperties\\strs.properties" );*/
	        		
	        		System.out.println("Working dir : "+workingDir);
	        		 System.out.println("filePath dir : "+filePath);
	        		 System.out.println("filePath2 dir : "+filePath2);

	        File f  = new File(filePath2+fileName);
	    	f.createNewFile();
			OutputStream os = new FileOutputStream(f);
	        InputStream is = part.getBody(InputStream.class, null);
	        byte[] bte = new byte[1024];
	        int r=0;
	       while((r=is.read(bte))!=-1){
	    	   os.write(bte);
	    	   System.out.println(bte);
	       }
	       os.flush();
	       os.close();
	       is.close();
	       System.out.println("Done");
	        // use the input stream to read the part body
	    }
		}
		catch(Exception e){
			System.out.println("hello : "+e.getMessage());
		}
		
		OutputVO outputVO = new OutputVO();
		outputVO.setId("100");
		outputVO.setName(fileName);
		String[] phones = {"022","033","111"};
		String[] addresses = {"Kol","Delhi","Mumbai"};
		outputVO.setAddress(addresses);
		outputVO.setPhone(phones);
		return Response.status(200).entity(outputVO).header("CustomHeader", "CustomHeader").build();
	}
	
	@POST
	@Path("/pos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Response getData(Bean bean){
		OutputVO outputVO = new OutputVO();
		outputVO.setId("100");
		outputVO.setName("NABIN");
		String[] phones = {"022","033","111"};
		String[] addresses = {"Kol","Delhi","Mumbai"};
		outputVO.setAddress(addresses);
		outputVO.setPhone(phones);
		return Response.status(200).entity(outputVO).header("CustomHeader", "CustomHeader").build();
	}
	
}
