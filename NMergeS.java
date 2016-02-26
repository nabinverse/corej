import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class NMergeS {
	 public static List<Integer> list = new ArrayList<Integer>(10);
	public static void main(String[] args) {
		 int [] arr = new int[9];
		 arr[0]=100;
		 arr[1]=12;
		 arr[2]=56;
		 arr[3]=10;
		 arr[4]=123;
		 arr[5]=67;
		 arr[6]=89;
		 arr[7]=167;
		 arr[8]=6;
		 mergeSort(arr,0,8);

	}
	// O(n*n)
	//Uses: Insertion sort is uses when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
	private static void mergeSort(int [] inputArray,int f,int l) {
	   if(f<l){
		   int m= f+(l-f)/2;
		   mergeSort(inputArray,f,m);
		   mergeSort(inputArray,m+1,l);
		   merge(inputArray,f,m,l);
	   }
	}
	private static void merge(int[] inputArray, int f, int m, int l) {
		// temporary/intermediate  storage
		int out [] = new int[9];
		
		//initialization
		int i=f;
		int j=m+1;
		int k=0;
		//merging 
		while(true){
			if(inputArray[i]<inputArray[j]){
				out[k]=inputArray[i];
				i++;
			}else{
				out[k]=inputArray[j];
				j++;
			}
			k++;
			if(i>m || j>l){
				break;
			}
		}
		
		for(int p=i;p<=m;p++,k++){
			out[k]=inputArray[p];
		}
		for(int p=j;p<=l;p++,k++){
			out[k]=inputArray[p];
		}
		k=0;
		for(int n=f;n<=l;n++){
			inputArray[n]=out[k];
			k++;
		}
		// result
		print(inputArray);
	}
	private static void print(int[] out) {
		for(int i:out){
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

}
