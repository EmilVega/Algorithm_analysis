import java.util.Arrays;

public class Antenna {
	int maximumHeight;	
	int [] W;

	public Antenna(int maximumHeight_){
		maximumHeight = maximumHeight_;		
		W = new int[maximumHeight+1];			
	}

	public int solveAtennaProblem(int [] weights, int [] heights){
		W[0] = 0;		
		for (int i=1;i<W.length;i++){
			W[i] = Integer.MAX_VALUE;
			for (int j=0;j<heights.length;j++){
				int k = i - heights[j];
				if (k>=0){
					int cost = W[k] + weights[j];
					if (cost<W[i]){
						W[i] = cost;
					}
				}
			}			
		}		
		return W[maximumHeight];
	}
	
	public int solveAtennaProblem2(int [] weights, int [] heights){
		int [] selected = new int[W.length]; // selected[i] is the last selected block for height i		
		int [] blocks = new int[heights.length]; // block[j] is the number of blocks used in the solution for block type j 
		W[0] = 0;		
		for (int i=1;i<W.length;i++){
			W[i] = Integer.MAX_VALUE;
			for (int j=0;j<heights.length;j++){
				int k = i - heights[j];
				if (k>=0){
					int cost = W[k] + weights[j];
					if (cost<W[i]){
						W[i] = cost;
						selected[i] = j+1;						
					}
				}
			}			
		}
		
		// Count the number of blocks of each type used
		int i = maximumHeight;
		while (i>0){
			blocks[selected[i]-1]++;
			i = i - heights[selected[i]-1];
		}
		System.out.println("Selected blocks per height: " + Arrays.toString(selected));		
		System.out.println("Number of used blocks per type: " + Arrays.toString(blocks));
		return W[maximumHeight];
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("Height: " + maximumHeight + "\n");
		sb.append("Minimum Weight Vector: \n");	
		for (int i=0;i<W.length;i++){
			sb.append(i + "\t");
		}
		sb.append("\n");
		for (int i=0;i<=W.length*8;i++){
			sb.append("-");
		}
		sb.append("\n");
		for (int i=0;i<W.length;i++){			
			sb.append(W[i] + "\t");			
		}
		return sb.toString();
	}
}
