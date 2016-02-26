import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class NQuickS {
	 public static List<Integer> list = new ArrayList<Integer>(10);
	public static void main(String[] args) {
		 List<Integer> inputList = new ArrayList<Integer>();
		 inputList.add(0);
		 inputList.add(250);
		 inputList.add(10);
		 inputList.add(170);
		 inputList.add(177);
		 inputList.add(87);
		 inputList.add(0);
		 quickSort(inputList,0,inputList.size()-1);
		 System.out.println(inputList);

	}
	private static void quickSort(List<Integer> inputList,int f, int l) {
		if(f>=l){
			return;
		}
		int pp=partitionPoint(inputList,f,l);
		quickSort(inputList, f, pp-1);
		quickSort(inputList, pp+1, l);
	}
	private static int partitionPoint(List<Integer> inputList,int f,int l) {
		int pivot = inputList.get(f);
		int up=f;
		int down= l;
		boolean upset=false,downset=false;
		while(true){
			//search for the swap indices
			if(inputList.get(up)>pivot && !upset){
				upset=true;
			}else if(!upset){
				up++;
			}
			if(inputList.get(down)<pivot && !downset){
				downset=true;
			}else if(!downset){
				down--;
			}
			//swap and reset
			if(downset && upset && up<down){
				int dval=inputList.get(down);
				int upval=inputList.get(up);
				inputList.remove(up);
				inputList.add(up,dval);
				inputList.remove(down);
				inputList.add(down,upval);
				upset=false;
				downset=false;
				
			}
			//termination condition
			if(up>down)
			 break;
		}
		//place pivot in proper place
		inputList.add(up,pivot);
		inputList.remove(f);
		return down;
	}

}
