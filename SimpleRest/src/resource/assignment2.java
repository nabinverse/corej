package resource;

public class assignment2 {

	public static void main(String[] args) {
		
		//Step 0: The input string
		String input ="T1=A+New+Student&T3=Myhome@AnytownUSA&T2=10-123-9898&S1=CIS111%2C+CIS115+%28The+Internet%29%2C+MAT100&S2=I+need+it+for+my+degree.&S3=I+am+interested+in+Anything+to+do+with+the+Internet"+
		"%21%21%0D%0AWill+there+be+many+programs+to+write+in+this+course%3F&B1=Submit";
		
		//Step 1: slice the input string into pieces based on & and put those sub strings on an array
		String pairs[] =input.split("&");
		
		String[] m=null;
		
		//Step 2: loop through for all the subs strings obtained at step 1
		for(int i=0;i<pairs.length;i++){
			//split each sub string into pieces based on = to get the name value pairs and put that pairs on another string array m
			m= pairs[i].split("=");
			// print the name
			System.out.println("Field Name : "+m[0]);
			// replace + with space on the value part
			m[1]=m[1].replace("+", " ");
			
			/* if the value part contains % then for all occurrence of % cut the % and the next 2 chars and then convert the next two chars to integer in decimal (from hexadecimal expression)
			 then the char is obtained based on the ASCII code table for that integer, finally that chars is then replaced on the original string 
			 e.g if value of m1= "I am Mr Mandal %2D and who r u %3F" then at the end of loop it will be converted to m1= "I am Mr Mandal , and who r u ?"
			 because 2D in hexadecimal is equal to 45 in decimal and 45 in ASCII table maps to hyphen(-)
			 and 3F in hexadecimal is equal to 63 in decimal and 45 in ASCII table maps to question mark(?)
			 
			 here is the on line converter for hexa decimal : http://www.binaryhexconverter.com/hex-to-decimal-converter
			 here is the online ascii table : http://www.theasciicode.com.ar/ascii-printable-characters/question-mark-ascii-code-63.html
			 
			 */
			while(m[1].indexOf("%")>=0){
				//get the next 2 chars after %
				String tmp= (String)m[1].subSequence(m[1].indexOf("%")+1, m[1].indexOf("%")+3);
				// get the ascii char of that hexadecimal
				String tmp2= ""+(char)Integer.parseInt(tmp, 16);
				//now replace %+next 2 chars with just obtained ascii char
				m[1]=m[1].replace("%"+tmp, tmp2);
			}
			//Now print the value 
			System.out.println(" Field content : "+ m[1]);
		}

	}

}
