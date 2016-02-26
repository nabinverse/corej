import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Conum {
	
	
	public static void main(String []args){
		int input=759;
		readAmericanNumber(input);
		readIndianNumber(input);
		System.out.println("");
		System.out.println(iAnagram("army", "mmty"));
	
	}
	
	
	public static boolean iAnagram(String word, String anagram){
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();       
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        return Arrays.equals(charFromWord, charFromAnagram);
    }



	
	
	
	private static void readIndianNumber(int input) {
		LinkedList<String> l= new LinkedList<String>();
		int i=0;
		while(true){
			
			if(i==1){
				l.add(getIndianUnits(i));
				l.add(readDigits(input%10));
				input=input/10;
			}
			else{
				l.add(getIndianUnits(i));
				l.add(readDigits(input%100));
				input=input/100;
			}
			if(input==0)break;
			i++;
		}
		  System.out.println("Indian : ");
		while(true){
			System.out.print(l.removeLast());
			if(l.size()==0){
				break;
			}
		}
		
	}


	private static String readDigits(int input) {
		int s=new String(""+(input)).length();
		String retVal="";
		if(s==1){
			retVal = readOneDigit(input);
		}else if(s==2){
			retVal = readTwoDigits(input);
		}else if(s==3){
			retVal = readThreeDigits(input);
		}
		return retVal;
	}


	private static void readAmericanNumber(int input) {
		 int place = 0;
	        String current="";
	        do {
	            int n = input % 1000;
	            if (n != 0){
	                String s = readDigits(n);
	                current = s + getAmericanUnits(place) + current;
	            }
	            place++;
	            input /= 1000;
	        } while (input > 0);
	        
	    System.out.println("American : ");
		System.out.println(current);
	}


	public static String readThreeDigits(int digit){
		
		String ret= readOneDigit(digit/100)+" hundred and "+ readTwoDigits(digit%100);
		
		return ret;
	}
	
	public static String readOneDigit(int digit){
		
		Map<Integer, String> singleDigitMap= new HashMap<Integer, String>();
		
		singleDigitMap.put(0, "Zero");
		singleDigitMap.put(1, "One");
		singleDigitMap.put(2, "Two");
		singleDigitMap.put(3, "Three");
		singleDigitMap.put(4, "Four");
		singleDigitMap.put(5, "Five");
		singleDigitMap.put(6, "Six");
		singleDigitMap.put(7, "Seven");
		singleDigitMap.put(8, "Eight");
		singleDigitMap.put(9, "Nine");
		return singleDigitMap.get(digit);
	}
	
public static String readTwoDigits(int digit){
	
		String retVal="";
		
		Map<Integer, String> twoDigitMap= new HashMap<Integer, String>();
		
		twoDigitMap.put(11, "Eleven");
		twoDigitMap.put(12, "Twelve");
		twoDigitMap.put(13, "Thirteen");
		twoDigitMap.put(14, "Forteen");
		twoDigitMap.put(15, "Fifteen");
		twoDigitMap.put(16, "Sixteen");
		twoDigitMap.put(17, "Seventeen");
		twoDigitMap.put(18, "Eightteen");
		twoDigitMap.put(19, "Nineteen");
		twoDigitMap.put(2, "Twenty");
		twoDigitMap.put(3, "Thirty");
		twoDigitMap.put(4, "Fourty");
		twoDigitMap.put(5, "Fifty");
		twoDigitMap.put(6, "Sixty");
		twoDigitMap.put(7, "Seventy");
		twoDigitMap.put(8, "Eighty");
		twoDigitMap.put(9, "Ninty");
		
		if(digit<20){
			return twoDigitMap.get(digit);
		}
		else{
			retVal =  twoDigitMap.get(digit/10) + " " +readOneDigit(digit%10);
		}
		return retVal;
	}
	
	public static String getAmericanUnits(int i){
		
		Map<Integer, String> myMap=new HashMap<Integer, String>();
		myMap.put(0, " ");
		myMap.put(1, " thousand ");
		myMap.put(2, " million ");
		myMap.put(3, " billion ");
		myMap.put(4, " trillion ");
		myMap.put(5, " quadrillion ");
		myMap.put(6, " quintillion ");
		return myMap.get(i);
	}
	
public static String getIndianUnits(int i){
		
		Map<Integer, String> myMap=new HashMap<Integer, String>();
		myMap.put(0, " ");
		myMap.put(1, " Hundred ");
		myMap.put(2, " Thousand ");
		myMap.put(3, " Lakhs ");
		myMap.put(4, " Crore ");
		myMap.put(5, " ");
		return myMap.get(i);
	}
	

}
