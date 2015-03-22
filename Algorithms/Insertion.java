public class Insertion
{
	public static void main(String[] args)
	{
		int[] a = {5, 4, 3, 2, 1};
		sort(a);
		for(int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public static void sort(int[] a)
	{
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j-1]))
					exch(a, j, j-1);
				else break;
	}
	
	private static boolean less(int v, int w)
	{ 
		return v<w;
	}
	
	private static void exch(int[] a, int i, int j)
	{
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
