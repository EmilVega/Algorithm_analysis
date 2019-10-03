import java.util.Arrays;

public class Communications {
	int numSymbols;
	int numCodes;
	int [][] V;

	public Communications(int numSymbols_, int numCodes_){
		numSymbols = numSymbols_;
		numCodes = numCodes_;
		V = new int[numSymbols+1][numCodes+1];			
	}

	public int solveSendMessage(int [][] bits, int [][] C){	
		int [][] selected = new int[V.length][V[0].length];
		for (int i=0;i<V.length;i++){
			for (int j=0;j<V[i].length;j++){
				if ((i==0) || (j==0)){
					V[i][j] = 0;				
				}else{
					V[i][j] = Integer.MAX_VALUE;
					for (int k=1;k<=numCodes;k++){
						int numBits = bits[i-1][k-1] + C[j-1][k-1] + V[i-1][j];
						if (numBits<V[i][j]){
							V[i][j] = numBits;
							selected[i][j] = k;
						}
					}
				}
			}			
		}		
		// Find the code that send the last symbol with minimum number of bits
		int bestCode = 1;
		for (int j=2;j<=numCodes;j++){
			if (V[numSymbols][j] < V[numSymbols][bestCode]){
				bestCode = j;
			}			
		}
		// Assign to each symbol the selected code
		int [] assignments = new int[numSymbols];
		int j = bestCode;
		for (int i=numSymbols;i>=1;i--){
			assignments[i-1] = selected[i][j];
			j = selected[i][j];
		}
		System.out.println("Selected Codes. " + table2String(selected));
		System.out.println("Assignments of codes to symbols: " + Arrays.toString(assignments) + "\n");
		return V[numSymbols][bestCode];
	}

	public String table2String(int [][] t){
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Table Content: \n");
		sb.append("\t");
		for (int j=0;j<t[0].length;j++){
			sb.append(j + "\t");
		}
		sb.append("\n");
		for (int j=0;j<=t[0].length*9;j++){
			sb.append("-");
		}
		sb.append("\n");
		for (int i=0;i<t.length;i++){
			for (int j=0;j<=t[i].length;j++){
				if (j==0){
					sb.append(i + "|\t");
				}else{
					sb.append(t[i][j-1] + "\t");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
