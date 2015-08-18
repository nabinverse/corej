package resource;

import java.util.HashMap;
import java.util.Map;

public class JugProblem {

	public static void main(String[] args) {
		
		int m=20, n=8, d=12;
		Map<String, String> map = new HashMap<String, String>();
		
		int x=0,y=0;
		
		System.out.println(x + " " +y);
		while(true){
			
			//Step 0: Termination condition. No Solution possible
			String key=""+x+y;
			if(map.get(key)!=null){
				System.out.println(" We have come up on a repitative situation. So infinite loop . So no solution possible. ");
				break;
			}else{
				//make a note of the key
				map.put(key, key);
			}
			//Step 1 Termination condition with Solution : any jug has matched the goal means terminate the program we have got the solution
			if(x==d || y==d){
				System.out.println("Done");
				break;
			}
			// Step2 Re-initialization :Big jug is full reinitialize and swap
			if(y==m){
				y=0;
				System.out.println(x + " " +y);
				if(x>0){
					x=x^y;
					y=x^y;
					x=x^y;
					System.out.println(x + " " +y);
				}
				continue;
			}
			
			//Step3 Algorithm :small Jug is full and big jug has got capacity to consume small so reinitialize small jug and add up big jug
			if(x==n && y+n<m){
				x=0;
				y=y+n;
				System.out.println(x + " " +y);
				continue;
			}
			//small Jug is full and big jug has not got capacity to consume all, fill big Jug completely 
			if(x==n && y+n>m){
				x=x-(m-y);
				y=m;
				System.out.println(x + " " +y);
				continue;
			}
			
			// pour water in small jug
			x=n;
			System.out.println(x + " " +y);
		}
	}

}
