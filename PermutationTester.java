import java.util.Calendar;


public class PermutationTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperPermutation sp = new SuperPermutation();
		long startTime=Calendar.getInstance().getTimeInMillis();
		sp.permute("NABIN");
		long endTime=Calendar.getInstance().getTimeInMillis();
		System.out.println("Time Taken : "+(endTime-startTime));
	}

}
