/*
 * Emil Darío Vega Gualán
 * 0706950151
 */

public class Knapsack {
	
	int maximumWeight;
	int objectNumber;
	int [][] V;
	
	public Knapsack(int maximumWeight_, int objectNumber_){
		maximumWeight = maximumWeight_;
		objectNumber = objectNumber_;
		V = new int[objectNumber+1][maximumWeight+1];			
	}
	
	public int solveKnapsackProblem(int [] weights, int [] values){	
		for (int i=0; i < objectNumber+1;i++){
			for (int j=0; j < maximumWeight+1;j++){
				if (i==0 || j==0){
					V[i][j]=0;
				}else if (weights[i-1]>j){
					V[i][j]=V[i-1][j];
				}else {
					V[i][j]=Math.max(V[i-1][j], values[i-1]+V[i-1][j-weights[i-1]]);
				}
			}
		}
		return V[objectNumber][maximumWeight];
	}
	
	public int solveKnapsackProblemMemoization(int [] weights, int [] values){
		for (int i=0; i < objectNumber+1 ;i++){
			for (int j=0; j < maximumWeight+1;j++){
				if (i==0 || j==0){
					V[i][j]=0;
				}else{
					V[i][j]=-1;
				}
			}
		}
		return knapsackMemoizationRec(objectNumber, maximumWeight, weights, values);
	}
	
	public int knapsackMemoizationRec (int i, int j, int [] w, int [] v){
		if (V[i][j]==-1){
			if (w[i-1]>j){
				V[i][j] = knapsackMemoizationRec(i-1, j, w, v);
			}else{
				V[i][j] = Math.max(knapsackMemoizationRec(i-1, j, w, v), knapsackMemoizationRec(i-1, j - w[i-1], w, v)+v[i-1]);
			}
		}			
		return V[i][j];
	}
		
	public String toString(){
		StringBuilder sb = new StringBuilder("Maximum weight: " + maximumWeight + "\n");
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
