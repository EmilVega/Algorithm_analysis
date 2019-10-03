/*
 * Emil Darío Vega Gualán
 * 0706950151
 */

import java.util.ArrayList;
import java.util.List;

public class P5 {		
	
	public List<Integer> EgyptianFractions(int a, int b){
		List<Integer> den = new ArrayList<Integer>();	
		int n=0;
		if (a==0||b==0){
			den.add(0);
		}else if (a%b==0){
			den.add(-1);
		}else if (a>b){
			den.addAll(EgyptianFractions(a%b, b));
		}else if (b%a==0){
			n = b/a;
			den.add(n);
		}else{
			n = (b/a)+1;
			den.add(n);	
			den.addAll(EgyptianFractions(a*n-b, b*n));
		}
		return den;
		
	}
	
	public List<Integer> activitiesAssignment(int s[], int f[]){
		// The arrays have to be sorted by finish time
		List<Integer> l = new ArrayList<Integer>();	
		l.add(1);  // No. of position of set (s,f)
		int c=1;   // Counter of request accepted 
		for (int i =1 ; i<s.length; i++){
			if (s[i] > f[(l.get(c-1))-1]){
				l.add(i+1);
				c++;
			}
		}
		return l;
	}
}
