import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 521;
		int b = 1050;
		int [] s = {1,3,0,5,3,5,6,8,8,2,12};
		int [] f = {4,5,6,7,9,9,10,11,12,14,16};		
		
		P5 P = new P5();
		
		// Exercise 1
		List<Integer> l1 = P.EgyptianFractions(a, b);
		Iterator<Integer> iter = l1.iterator();
		String solution = a + "/" + b + " = ";
		while (iter.hasNext()){
			solution = solution + "1/" + iter.next();	
			if (iter.hasNext()){
				solution += " + ";
			}
		}
		System.out.println("Exercise 1:");
		System.out.println(solution);		
		
		// Exercise 2
		System.out.println("\nExercise 2:");
		List<Integer> l2 = P.activitiesAssignment(s, f);
		System.out.println("The highest number of activities satisfied is " + l2.size());
		System.out.println(l2.toString());
	}

}
