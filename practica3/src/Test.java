import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int a1 [] = {1,2,3,8,9};
		int a2 [] = {4,5,16,27,38};
		
		// Median of A1
		System.out.println("A1 = " + Arrays.toString(a1));
		System.out.println("The median of A1 is " + Median.median(a1));
		// Median of A2
		System.out.println("A2 = " + Arrays.toString(a2));
		System.out.println("The median of A2 is " + Median.median(a2));
		
		// Median of A1 and A2
		System.out.println("The median of A1 and A2 is " + Median.medianTwoArrays(a1, a2));
	}

}
