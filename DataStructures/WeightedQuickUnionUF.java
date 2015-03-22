import java.util.Scanner;

public class WeightedQuickUnionUF {
	private int[] id; 
	private int[] sz; 
	private int count; 

	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter N:");
		int N = in.nextInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		System.out.println("Enter number of operations:");
		int numOps = in.nextInt();
		System.out.println("Enter the values (p, q):");
		for (int i = 0; i < numOps; i++) {
			int p = in.nextInt();
			int q = in.nextInt();
			if (uf.connected(p, q))
				continue;
			uf.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(uf.count() + " components");

		in.close();
	}

}
