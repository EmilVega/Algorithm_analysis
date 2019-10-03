import java.util.ArrayList;
import java.util.List;

public class TestEjercicio57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] points = {1.75,3.5,0.5,2,1.5,0};
//		double [] points = {0,0.3,1.5,2.1,3};
		
		UnitIntervals I = new UnitIntervals();
		List<Double> l = new ArrayList<Double>();
		l = I.getMinimumUnitIntervals(points);
		System.out.print(l.toString());
	}

}