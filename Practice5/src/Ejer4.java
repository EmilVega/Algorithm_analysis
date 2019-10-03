import java.util.Iterator;
import java.util.LinkedList;

public class Ejer4 {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	Ejer4(int v){
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}
	
	void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	void greedyColoring(){
		int result[] = new int[V];
		result[0]= 0;
		for (int u = 1; u < V; u++)
			result[u] = -1;
		boolean available[] = new boolean[V];
		for (int cr = 0; cr < V; cr++)
			available[cr] = false;
		for (int u = 1; u < V; u++){
			Iterator<Integer> it = adj[u].iterator() ;
			while (it.hasNext()){
				int i = it.next();
				if (result[i] != -1)
					available[result[i]] = true;
			}
			int cr;
			for (cr = 0; cr < V; cr++)
				if (available[cr] == false)
					break;
			result[u] = cr;
			it = adj[u].iterator() ;
			while (it.hasNext()){
				int i = it.next();
				if (result[i] != -1)
					available[result[i]] = false;
			}
		}
		for (int u = 0; u < V; u++)
			System.out.println("Vertex: " + u + " Color: "+ result[u]);
	}
}
