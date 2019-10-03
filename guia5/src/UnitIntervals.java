import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitIntervals {

	public List<Double> getMinimumUnitIntervals(double [] points){
		List<Double> intervals = new ArrayList<Double>();
		
		// Copy array points into points2 to remove selected points
		double [] points2 = Arrays.copyOf(points, points.length);
		
		// Select the smallest point
		int selectedIndex = minimum(points);					
		double rightEnd = 0;
		do{															
			if (intervals.isEmpty() || points[selectedIndex]>rightEnd){ 
				// Create a new interval if the selected point that does not fit in the current interval
				intervals.add((double) points[selectedIndex]);
				intervals.add((double) (points[selectedIndex]+1));						
				rightEnd = points[selectedIndex] + 1;						
			}							
			// Mark the point as already covered
			points2[selectedIndex] = Integer.MAX_VALUE;
			// Select the smallest point not covered yet
			selectedIndex = minimum(points2);
		}while (points2[selectedIndex]!=Integer.MAX_VALUE);			
		return intervals;
	}
	
	private int minimum(double [] a){
		int min = 0;
		for (int i=0; i<a.length; i++){
			if (a[i]<a[min]){
				min = i;
			}
		}
		return min;
	}
}
