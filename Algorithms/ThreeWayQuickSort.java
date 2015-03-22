public class ThreeWayQuickSort
{
	public static void main(String[] args)
	{
		int[] a = {5, 4, 3, 2, 1};
		sort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	private static void sort(int[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int lt = lo, gt = hi;
		int v = a[lo];
		int i = lo;
		while (i <= gt)
		{
			int cmp = compare(a[i], v);
			if (cmp < 0) exch(a, lt++, i++);
			else if (cmp > 0) exch(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
	
	
	private static void exch(int[] a, int i, int j)
	{
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static int compare(int a, int b)
	{
		if(a<b) return -1;
		else if(a>b) return 1;
		else return 0;
	}


}
