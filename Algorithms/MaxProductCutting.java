public class MaxProductCutting 
{
	private static int max(int a, int b) { return (a > b)? a : b;}
	private static int max(int a, int b, int c) { return max(a, max(b, c));}

	private static int maxProd(int n)
	{
	 if (n == 0 || n == 1) return 0;

	 int max_val = 0;
	 for (int i = 1; i < n; i++)
	   max_val = max(max_val, i*(n-i), maxProd(n-i)*i);

	 return max_val;
	}
	
	private static int maxProd2(int n)
	{
	   int[] val = new int[n+1];
	   val[0] = val[1] = 0;
	  
	   for (int i = 1; i <= n; i++)
	   {
	      int max_val = 0;
	      for (int j = 1; j <= i/2; j++)
	         max_val = max(max_val, (i-j)*j, j*val[i-j]);
	      val[i] = max_val;
	   }
	   return val[n];
	}

	public static void main(String[] args)
	{
		System.out.println("Maximum Product: " + maxProd2(10));
	}
}

