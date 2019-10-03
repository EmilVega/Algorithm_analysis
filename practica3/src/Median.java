/*
 * Emil Darío Vega Gualán
 * 0706950151
 */

import java.sql.Array;
import java.util.Arrays;

public class Median {
	public static double medianTwoArrays(int a1[], int a2[]){
		int n = a1.length;
		if (n!=a2.length){
			System.out.println("Error: the two arrays must have the same length.");
			return -1;
		}else{
			if (n<=0){
				System.out.println("Error: the length of the arrays must be higher than 0.");
				return -1;
			}else if (n==1){
				return (a1[0]+a2[0])/2;
			}else if (n==2){
				return (Math.max(a1[0],a2[0]) + Math.min(a1[1],a2[1]))/2.0;
			}else{			
				if (median(a1)>median(a2)){
					return medianTwoArrays(Arrays.copyOfRange(a1, 0, n-1), Arrays.copyOfRange(a2, 1, n));
				}else{
					return medianTwoArrays(Arrays.copyOfRange(a1, 1, n), Arrays.copyOfRange(a2, 0, n-1));
				}				
			}
		}
	}
	
	public static double median(int a[]){
		int size = a.length;
		int m = size/2;
		if (size%2==0){
			return (a[m-1] + a[m])/2.0;			
		}else{
			return a[m];
		}
	}
}
