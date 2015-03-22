import java.util.Scanner;

public class DepthFirstSearch {
	private boolean[] marked; 
	private int count; 

	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of Vertices:");
		int V = in.nextInt();
		System.out.println("Enter number of edges:");
		int E = in.nextInt();
		Graph G = new Graph(V);
		System.out.println("Enter the edges (v1, v2):");
		for (int i = 0; i < E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			G.addEdge(v, w);
		}

		System.out.println("Enter element to search:");
		int s = in.nextInt();
		DepthFirstSearch search = new DepthFirstSearch(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (search.marked(v))
				System.out.println(v + " ");
		}

		System.out.println();
		if (search.count() != G.V())
			System.out.println("NOT connected");
		else
			System.out.println("connected");
		
		in.close();
	}

}
