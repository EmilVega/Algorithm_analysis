import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Split {
	int sum;
	int numObjects;
	int [][] V;

	public Split(int numObjects_, int sum_){		
		numObjects = numObjects_;
		sum = sum_;
		V = new int[numObjects+1][sum+1];			
	}

	public int solveSplitProblem(int [] weights){				
		// Initialize column j=0 as 1. 0 sum is possible 
	    // with all elements in a partition.
	    for (int i = 0; i<V.length; i++){
	        V[i][0] = 1;
	    }
	    
	    // Initialize row i=0 as 0, except V[0][0]. With
	    // 0 elements the only possible sum is 0.
	    for (int j = 1; j <V.length; j++){
	        V[0][j] = 0;
	    }
	    
		for (int i=1;i<V.length;i++){
			for (int j=1;j<V[i].length;j++){				
				V[i][j] = V[i-1][j];
				if (weights[i-1]<=j){
					V[i][j] = V[i-1][j-weights[i-1]];					
				}
			}			
		}
		
		// Initialize difference of two sums 
	    int diff = Integer.MAX_VALUE;
	     
	    // Find the largest j such that V[numObjects][j]
	    // is 1 where j loops from sum/2 to 0
	    int j=sum/2;	    
	    boolean found = false;
	    while ((!found) && (j>=0)){
	        // Find the largest j such that V[numObjects][j] is 1
	        if (V[numObjects][j] == 1){
	            diff = sum-2*j;	            
	            found = true;
	        }else{
	        	j--;
	        }
	    }
	    
	    // Rebuild the optimal solution	    
	    List<Integer> partition1 = new LinkedList<Integer>();	    	    
	    List<Integer> partition2 = new LinkedList<Integer>();	   
	    int i = numObjects;	    
	    while ((j>=0) && (i>0)){
	    	if ((V[i][j] == 1) && (V[i-1][j] == 0)){
		    	partition1.add(i);			    	
		    	j = j - weights[i-1];
	    	}else{
	    		partition2.add(i);	    		
	    	}
	    	i--;
	    }
	    System.out.println("Partition 1: " + partition1.toString());
	    System.out.println("Partition 2: " + partition2.toString());	    
		return diff;
	}	

	public String toString(){
		StringBuilder sb = new StringBuilder("Number of elements: " + numObjects + "\n");
		sb.append("Sum of all elements: " + sum + "\n");		
		sb.append("Table Content: \n");		
		sb.append("\t");
		for (int j=0;j<V[0].length;j++){
			sb.append(j + "\t");
		}
		sb.append("\n");
		for (int j=0;j<=V[0].length*9;j++){
			sb.append("-");
		}
		sb.append("\n");
		for (int i=0;i<V.length;i++){
			for (int j=0;j<=V[i].length;j++){
				if (j==0){
					sb.append(i + "|\t");
				}else{
					sb.append(V[i][j-1] + "\t");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
