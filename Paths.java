package com.nabin.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paths {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int m = in.nextInt();
	        int n = in.nextInt();
	        int [][] arr= new int[m][n];
	        for(int i = 0; i < m; i++){
	        	for(int j=0;j<n;j++){
	        		arr[i][j]= in.nextInt();
	        	}
	        }
	        
	        process(arr,m,n);
	        
	}

	private static void process(int[][] arr,int m,int n) {
		Paths path = new Paths();
		int pathPossible=0;
		List<Node> list = new ArrayList<Node>();
		List<Node> leaf = new ArrayList<Node>();
		Node node= path.new Node(arr[0][0],0,0);
		list.add(node);
		int i=0;
		while(list.size()!=m*n+1){
			Node tn=list.get(i);
			int r=tn.getI();
			int c=tn.getJ();
			if(r+1<m && c<n){
					Node left= path.new Node(arr[r+1][c],r+1,c);
					left.setP(tn);
					tn.setLeft(left);
					list.add(left);
					if(r+1==m-1 && c==n-1){
						leaf.add(left);
					}
			}
			if(r<m && c+1<n){
					Node right= path.new Node(arr[r][c+1],r,c+1);
					tn.setRight(right);
					right.setP(tn);
					list.add(right);
					if(r==m-1 && c+1==n-1){
						leaf.add(right);
				}
			}
			
			if(tn.getLeft()==null && tn.getRight()==null){
				break;
			}
			
			i++;
		}
		
		
		for(Node l: leaf){
			boolean isPath=true;
			while(l.getP()!=null){
				if(l.getN()==0){
					isPath=false;
					break;
				}
				l=l.getP();
			}
			if(isPath){
				pathPossible++;
			}
		}
		
		
		System.out.println("Hiya Path : "+pathPossible);
	}
	 
	public class Node {
		int n;
		Node left;
		Node right;
		Node p;
		public Node getP() {
			return p;
		}
		public void setP(Node p) {
			this.p = p;
		}
		int i;
		int j;
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public int getJ() {
			return j;
		}
		public void setJ(int j) {
			this.j = j;
		}
		Node(int n,int i,int j){
			this.n =n;
			this.i=i;
			this.j=j;
		}
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
			
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
}
