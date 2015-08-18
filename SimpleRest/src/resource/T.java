package resource;

public class T {

	public static void main(String[] args) {
		
		String input ="T1=A+New+Student&T3=Myhome@AnytownUSA&T2=10-123-9898&S1=CIS111%2C+CIS115+%28The+Internet%29%2C+MAT100&S2=I+need+it+for+my+degree.&S3=I+am+interested+in+Anything+to+do+with+the+Internet"+
		"%21%21%0D%0AWill+there+be+many+programs+to+write+in+this+course%3F&B1=Submit";
		
		String pairs[] =input.split("&");
		String m[][] = new String[pairs.length][2];
		
		for(int i=0;i<pairs.length;i++){
			m[i]= pairs[i].split("=");
			System.out.println("Field Name : "+m[i][0]);
			m[i][1]=m[i][1].replace("+", " ");
			
			while(m[i][1].indexOf("%")>=0){
				String tmp= (String)m[i][1].subSequence(m[i][1].indexOf("%")+1, m[i][1].indexOf("%")+3);
				String tmp2= ""+(char)Integer.parseInt(tmp, 16);
				m[i][1]=m[i][1].replace("%"+tmp, tmp2);
			}
			System.out.println(" Field content : "+ m[i][1]);
		}

	}

}
