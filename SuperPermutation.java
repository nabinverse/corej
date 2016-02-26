import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SuperPermutation {

	List<Dice> list = new ArrayList<Dice>();

	public List<Dice> getList() {
		return list;
	}

	public void setList(List<Dice> list) {
		this.list = list;
	}
	
	
	public void permute(String input){
		Set<String> result= new HashSet<String>();
		
		int s=input.length();
		String temp="";
		for(int i=0;i<s;i++){
			list.add(new Dice(input,i));
		}
		Double n=Math.pow(s, s);
	   for(int i=1;i<n;i++){
		   for(Dice d:list){
			   temp=temp+d.getFace();
		   }
		  
		   list.get(0).roll();
		  for(int k=1;k<s;k++){
			   if(i%(Math.pow(s, k))==0){
				   list.get(k).roll();
			   }
		   }
		   if(iAnagram(input,temp)){
			 //  System.out.println("GOT"+i);
			   result.add(temp);
			  // System.out.println(temp);
		   }
		   temp="";
	   }
	   System.out.println(result);
	}
	
	public static boolean iAnagram(String word, String anagram){
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();       
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        return Arrays.equals(charFromWord, charFromAnagram);
    }

}
