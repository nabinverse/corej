package com.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Solution {
	
	Map<Integer,Integer> map= null;
    public static void main(String[] args) {
    	
    	Solution s= new Solution(); 
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        List<String> result = new ArrayList<>();
        long time =Calendar.getInstance().getTimeInMillis();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            List<Integer> verticies = new ArrayList<>();
            List<Edge> edges= new ArrayList<>();
            for(int a1 = 0; a1 < n-1; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                if(!verticies.contains(u)){
                	 verticies.add(u);
                } if(!verticies.contains(v)){
               	 verticies.add(v);
               }
               
                 
                Edge e=s.new Edge(u,v);
                edges.add(e);
            }
            
            int g = in.nextInt();
            int k = in.nextInt();
            List<String> guessmap = new ArrayList<String>();
            for(int a1 = 0; a1 < g; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                guessmap.add(v+";"+u);
            }
            int satiscount=0;
            int prev=-1;
           for(Integer v:verticies){
        	   Map m=prepareGraph(s,v,prev,edges,n);
        	   if(satisfyGuess(m,guessmap,k)){
        		   satiscount++;
        	   }
        	   prev=v;
           }
           
           int hcf = getHCF(satiscount,verticies.size());
           
           
           if(hcf !=0){
        	   result.add((satiscount/hcf)+"/"+(verticies.size()/hcf));
        	  // System.out.println((satiscount/hcf)+"/"+(verticies.size()/hcf));
           }
           else{
        	   result.add((satiscount)+"/"+(verticies.size()));
        	 //  System.out.println((satiscount)+"/"+(verticies.size()));
           }
            s.map=null;
            
           
        }
        
        for(String r:result){
        	 System.out.println(r);
        }
        System.out.println("Time Taken :"+(Calendar.getInstance().getTimeInMillis()-time));
    }

	private static int getHCF(int n1, int n2) {
		
		int min = Math.min(n1,n2);
        
        for(int i=min; i >= 1; i--)
        {
            if(n1%i == 0 && n2%i == 0)
            {
               return i;
            }
        }    
		
		return 0;
	}

	private static boolean satisfyGuess(Map m, List<String> guessmap,int k) {
		
		Iterator<String> itr =guessmap.iterator();
		int match=0;
		while(itr.hasNext()){
			
			String next=itr.next();
			String arr[] = next.split(";");
			int ke=Integer.parseInt(arr[0]);
			if(m.get(ke)!=null && arr[1].equals(""+m.get(ke))){
				match +=1;
			}
		}
		
		if(match>=k){
			return true;
		}
		return false;
	}

	private static Map<Integer,Integer> prepareGraph(Solution s,Integer v,Integer prev, List<Edge> edges,int n) {
		Node g= s.new Node(v);
		if(s.map==null){
			s.map=new HashMap<Integer, Integer>();
		List<Node> list = new ArrayList<Node>();
		list.add(g);
		int l=0;
		Node t=g;
		
		CopyOnWriteArrayList<Edge> cedges = new CopyOnWriteArrayList<>(edges);
		while(true){
			
			for(Edge e:cedges){
				if(t.getN()==e.getStart()|| t.getN()==e.getEnd()){
				     if(t.getN()==e.getStart()){
				    	 Node node = s.new Node(e.getEnd());
				    	// t.getList().add(node);
				    	 list.add(node);
				    	 s.map.put(e.getEnd(), t.getN());
				     }else{
				    	Node node= s.new Node(e.getStart());
				    	//t.getList().add(node);
				    	s.map.put(e.getStart(), t.getN());
				    	list.add(node);
				     }
				     cedges.remove(e);
				}
				
			}
			if(cedges.size()==0){
				break;
			}
			l++;
			t=list.get(l);
		}
		}else{
			Stack<Integer> stack = new Stack<>();
			while(true){
				int key = s.map.get(v);
				int value =v;
				stack.push(v);
				v=key;
				if(key==prev){
					break;
				}
			}
			while(!stack.isEmpty()){
				int key =stack.pop();
				int val = s.map.get(key);
				s.map.remove(key);
				s.map.put(val,key);
				
			}
		}
		return s.map;
	}
    
	public class Edge{
		
		int start;
		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		int end;
		
		Edge(int start,int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public class Node {
		int n;
		//List<Node>  list= new ArrayList<>();
		
		Node(int n){
			this.n =n;
		}
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}
		/*public List<Node> getList() {
			return list;
		}
		public void setList(List<Node> list) {
			this.list = list;
		}*/
		
	}
   
}

