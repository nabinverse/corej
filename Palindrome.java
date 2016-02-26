package com.client;

public class Palindrome {

	public static void main(String[] args) {
		String input ="NABIN";
		StringBuilder temp=new StringBuilder();
		for(int i=input.length()-1;i>=0;i--){
			temp.append(""+input.charAt(i));
		}
		if(temp.toString().equals(input)){
			System.out.println("PALINDROME");
		}else{
			System.out.println("Its not");
		}
	}

}
