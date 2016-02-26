import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class NRadixS {
	 public static List<Integer> list = new ArrayList<Integer>(10);
	public static void main(String[] args) {
		 List<Integer> inputList = new ArrayList<Integer>();
		 inputList.add(14);
		 inputList.add(250);
		 inputList.add(10);
		 inputList.add(177);
		 inputList.add(13);
		 inputList.add(66);
		 radixSort(inputList);

	}
	// O( (n+b)*log (MaxNumber))
	//Uses: Insertion sort is uses when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
	private static void radixSort(List<Integer> inputList) {
		
		int numberOfDigitsofMaxNumber = getMaxDigits(inputList);
		for(int j=0;j<numberOfDigitsofMaxNumber;j++){
			Map<Integer, List<Integer>> myMap =  new HashMap<Integer, List<Integer>>();
			for(Integer i:inputList){
				int index=(i/(int)(Math.pow(10, j)))%(10);
				if(myMap.get(index)==null){
					List<Integer> list =new LinkedList<Integer>();
					list.add(i);
					myMap.put(index, list);
				}else{
					List<Integer> list=myMap.get(index);
					list.add(i);
					myMap.put(index, list);
				}
			}
			inputList = getList(myMap);
		}
		
		for(Integer s:inputList){
			System.out.println(s);
		}
		System.out.println("");
		
	}

	private static int getMaxDigits(List<Integer> inputList) {
		int max=inputList.get(0);
		for(Integer i:inputList){
			if(i>max){
				max=i;
			}
		}
		
		return (""+max).length();
	}

	private static List<Integer> getList(Map<Integer, List<Integer>> myMap) {
		List<Integer> inputList = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			boolean val=(myMap.get(i)!=null)?inputList.addAll(myMap.get(i)):false;
		}
		return inputList;
	}

}
