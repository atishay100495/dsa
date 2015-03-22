public class Permutation 
{
	private static void swap (char[] a, int i, int j)
	{
	    char temp;
	    temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	  
	private static void permute(char[] a, int i, int n) 
	{
	   int j; 
	   if (i == n)
	     display(a, n);
	   else
	   {
	        for (j = i; j <= n; j++)
	       {
	          swap(a, i, j);
	          permute(a, i+1, n);
	          swap(a, i, j); 
	       }
	   }
	} 
	 
	private static void display(char[] a, int n)
	{
		for(int i=0; i<=n; i++)
		{
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
	   char[] a = {'A', 'B', 'C', 'D'};
	   permute(a, 0, a.length-1);
	}
}
