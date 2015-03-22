public class MaxPQ
{
	private int[] pq;
	private int N;
	
	public MaxPQ(int capacity)
	{ 
		pq = (int[]) new int[capacity+1];
	}
	
	public boolean isEmpty()
	{ 
		return N == 0;
	}
	
	public void insert(int x)
	{
		pq[++N] = x;
		swim(N);
	}
	
	public int delMax()
	{
		int max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1] = -1;	
		return max;
	}
	
	private void swim(int k)
	{
		while (k > 1 && less(k/2, k))
		{
			exch(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while (2*k <= N)
		{
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private boolean less(int i, int j)
	{ 
		return compare(pq[i], pq[j]);
	}
	
	private void exch(int i, int j)
	{
		int t = pq[i]; pq[i] = pq[j]; pq[j] = t; 
	}
	
	private static boolean compare(int a, int b)
	{
		if(a<b) return true;
		else return false;
	}
	
	
	
}
