// This code is contributed by Aakash Hasija
import java.util.Iterator;
import java.util.LinkedList;

public class GraphColoring {
	private int V;   // No. of vertices
	private LinkedList<Integer> adj[]; //Adjacency List

	//Constructor
	GraphColoring(int v){
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	//Function to add an edge into the graph
	void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v); //Graph is undirected
	}

	// Assigns colors (starting from 0) to all vertices and
	// prints the assignment of colors
	void greedyColoring(){
		int result[] = new int[V];

		// Assign the first color to first vertex
		result[0]  = 0;

		// Initialize remaining V-1 vertices as unassigned
		for (int u = 1; u < V; u++)
			result[u] = -1;  // no color is assigned to u

		// A temporary array to store the available colors. True
		// value of available[cr] would mean that the color cr is
		// assigned to one of its adjacent vertices
		boolean available[] = new boolean[V];
		for (int cr = 0; cr < V; cr++)
			available[cr] = false;

		// Assign colors to remaining V-1 vertices
		for (int u = 1; u < V; u++){
			// Process all adjacent vertices and flag their colors
			// as unavailable
			Iterator<Integer> it = adj[u].iterator() ;
			while (it.hasNext()){
				int i = it.next();
				if (result[i] != -1)
					available[result[i]] = true;
			}

			// Find the first available color
			int cr;
			for (cr = 0; cr < V; cr++)
				if (available[cr] == false)
					break;

			result[u] = cr; // Assign the found color

			// Reset the values back to false for the next iteration
			it = adj[u].iterator() ;
			while (it.hasNext()){
				int i = it.next();
				if (result[i] != -1)
					available[result[i]] = false;
			}
		}

		// print the result
		for (int u = 0; u < V; u++)
			System.out.println("Vertex " + u + " --->  Color " + result[u]);
	}
}
