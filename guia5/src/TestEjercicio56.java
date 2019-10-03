import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestEjercicio56 {

	public static void main(String args[]){
		int [] d = {1,3,7,12,9,15,5};
		int [] a = {2,2,4,3,5,1,3};
		int [] m = {3,1,5,2,6,2,4};
		
		SummerTour s = new SummerTour();
		List<Integer> l = new ArrayList<Integer>();		
		int benefit = s.selectProposals(d, a, m, l);
		System.out.println("Selected proposals: " + l.toString());				
		System.out.println("Benefit: " + benefit);
	}
}
