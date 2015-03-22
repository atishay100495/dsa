public class Heap
{
	public static void main(String[] args)
	{
		int[] a = { -1, 5, 4, 3, 2, 1};
		sort(a);
		for(int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public static void sort(int[] a)
	{
		int N = a.length-1;
		for (int k = N/2; k >= 1; k--)
			sink(a, k, N);
		while (N > 1)
		{
			exch(a, 1, N);
			sink(a, 1, --N);
		}
	}
	
	private static void sink(int[] a, int k, int N)
	{
		while (2*k <= N)
		{
			int j = 2*k;
			if (j < N && less(a, j, j+1)) j++;
			if (!less(a, k, j)) break;
			exch(a, k, j);
			k = j;
		}
	}
	
	private static boolean less(int[] pq, int i, int j)
	{ 
		return compare(pq[i], pq[j]); 
	}
	
	private static void exch(int[] pq, int i, int j)
	{
		int t = pq[i]; pq[i] = pq[j]; pq[j] = t; 
	}
	
	private static boolean compare(int a, int b)
	{
		if(a<b) return true;
		else return false;
	}
}
