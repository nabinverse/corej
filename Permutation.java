package com.client;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Permutation {
   
	private static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		String input="ABCDEFGH";
		
		//Set<String> results = permutationGenerator(input); NOT FULLY DEVELOPED
		Long ds=Calendar.getInstance().getTimeInMillis();
		Set<String> results=permutations(input);
		Long de=Calendar.getInstance().getTimeInMillis();
		System.out.println("Time taken : " +(de-ds));
		/*for(String p:results){
			System.out.println(p);
		}*/
	}

	
	
	
	private static Set<String> permutations(String input) {
		int f=factorial(input.length());
		int d= getFactor(getFrequencyMap(input));
		int pn=f/d;
		Set<String> permutationResult= new HashSet<String>();
		List<Long> list= new ArrayList<Long>();
		StringBuilder sb= new StringBuilder();
		while(true){
			Long i=Math.round((input.length()-1)*(Math.random()));
			if(!list.contains(i)){
				list.add(i);
				int p=Integer.parseInt(""+i);
				sb.append(""+input.charAt(p));
			}
			if(list.size()==input.length()){
				list.removeAll(list);
				permutationResult.add(sb.toString());
				sb=new StringBuilder();
				if(permutationResult.size()==pn){
					break;
				}
			}
		}
		return permutationResult;
	}




	private static int getFactor(Map<String, Integer> frequencyMap) {
		Iterator<String> itr=frequencyMap.keySet().iterator();
		int result=1;
		while(itr.hasNext()){
			result=result*factorial(frequencyMap.get(itr.next()));
		}
		
		return result;
	}




	private static int factorial(int in) {
		if(in==0||in==1){
			return 1;
		}
		else{
			return in*factorial(in-1);
		}
	}

   private static Map<String, Integer> getFrequencyMap(String input){
	   Map<String, Integer> map = new HashMap<String, Integer>();
	   char[] chars= input.toCharArray();
	   for(int i=0;i<chars.length;i++){
		   if(map.get(""+chars[i])==null){
			   map.put(""+chars[i], new Integer(1));
		   }else{
			   map.put(""+chars[i], map.get(""+chars[i])+1);
		   }
	   }
	   return map;
   }


	public static Set<String> generatePerm(String input)
	{
	    Set<String> set = new HashSet<String>();
	    if (input == "")
	        return set;

	    Character a = input.charAt(0);

	    if (input.length() > 1)
	    {
	        input = input.substring(1);

	        Set<String> permSet = generatePerm(input);

	        for (String x : permSet)
	        {
	            for (int i = 0; i <= x.length(); i++)
	            {
	                set.add(x.substring(0, i) + a + x.substring(i));
	            }
	        }
	    }
	    else
	    {
	        set.add(a + "");
	    }
	    return set;
	}
	
	
	public static Set<String> permutationGenerator(String input){
		Set<String> cop = new HashSet<String>();
		cop.add(input);
	/*	CopyOnWriteArrayList<String> cop= new CopyOnWriteArrayList<String>();
		cop.add(input);*/
		int i=0;
		while(true){
			String s=cop.iterator().next();
			String first=s.substring(0,1);
			String rest=s.substring(1);
			genAndAdd(cop,first,rest);
			if(i==cop.size()){
				break;
			}
			i++;
		}
		
		return cop;
	}




	private static Set<String> genAndAdd(Set<String> set, String first, String rest) {
		
		for(int i=1;i<=rest.length();i++){
			set.add(rest.substring(0, i) + first + rest.substring(i,rest.length()));
		}
		return set;
	}
	
	
	
	
	
	

}
