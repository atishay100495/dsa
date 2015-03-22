
public class LLAP 
{
	private static boolean arithmeticThree(int set[], int n)
	{
	 for (int j=1; j<n-1; j++)
	 {
	     int i = j-1, k = j+1;

	     while (i >= 0 && k <= n-1)
	     {
	         if (set[i] + set[k] == 2*set[j])
	             return true;
	         if(set[i] + set[k] < 2*set[j])
	        	 k++;
	         else
	        	 i--;
	     }
	 }

	 return false;
	}

	private static int lengthOfLongestAP(int set[], int n)
	{
	 if (n <= 2)  return n;

	 int L[][] = new int[n][n];
	 int llap = 2;  

	 for (int i = 0; i < n; i++)
	     L[i][n-1] = 2;

	 for (int j=n-2; j>=1; j--)
	 {
	     int i = j-1, k = j+1;
	     while (i >= 0 && k <= n-1)
	     {
	        if (set[i] + set[k] < 2*set[j])
	            k++;

	        else if (set[i] + set[k] > 2*set[j])
	        {   L[i][j] = 2; i--;   }

	        else
	        {
	            L[i][j] = L[j][k] + 1;

	            llap = max(llap, L[i][j]);

	            i--; k++;
	        }
	     }

	     while (i >= 0)
	     {
	         L[i][j] = 2;
	         i--;
	     }
	 }
	 return llap;
	}

	private static int max(int a, int b) { return (a > b)? a : b;}
	
	public static void main(String[] args)
	{
	 int set1[] = {1, 7, 10, 13, 14, 19};
	 int n1 = set1.length;
	 System.out.println(lengthOfLongestAP(set1, n1));

	 int set2[] = {1, 7, 10, 15, 27, 29};
	 int n2 = set2.length;
	 System.out.println(lengthOfLongestAP(set2, n2));
	 
	 int set3[] = {2, 4, 6, 8, 10};
	 int n3 = set3.length;
	 System.out.println(lengthOfLongestAP(set3, n3));

	}
}

