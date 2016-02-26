import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class NInsertionS {
	 public static List<Integer> list = new ArrayList<Integer>(10);
	public static void main(String[] args) {
		 List<Integer> inputList = new ArrayList<Integer>();
		 inputList.add(14);
		 inputList.add(250);
		 inputList.add(10);
		 inputList.add(177);
		 inputList.add(13);
		 inputList.add(66);
		 insertionSort(inputList);

	}
	// O(n*n)
	//Uses: Insertion sort is uses when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
	private static void insertionSort(List<Integer> inputList) {
		List<Integer> sortedList = new ArrayList<Integer>();
		sortedList.add(inputList.get(0));
		for(int j=1;j<inputList.size();j++){
			int temp =inputList.get(j);
			boolean elementAdded=false;
			for(int i=0;i<sortedList.size();i++){
				if(sortedList.get(i)>temp){
					sortedList.add(i, temp);
					elementAdded=true;
					break;
				}
			}
			if(!elementAdded){
				sortedList.add(temp);
			}
		}
		//print the results
		for(Integer s:sortedList){
			System.out.println(s);
		}
		System.out.println("");
		
	}

}
