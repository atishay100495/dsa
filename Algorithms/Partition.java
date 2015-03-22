public class Partition 
{
	private static boolean isSubsetSum (int arr[], int n, int sum)
	{
		if (sum == 0)
		  return true;
		if (n == 0 && sum != 0)
		  return false;
	
		if (arr[n-1] > sum)
		  return isSubsetSum (arr, n-1, sum);
	
		return isSubsetSum (arr, n-1, sum) || isSubsetSum (arr, n-1, sum-arr[n-1]);
	}

	private static boolean findPartiion2 (int arr[], int n)
	{
	    int sum = 0;
	    int i, j;
	   
	    for (i = 0; i < n; i++)
	      sum += arr[i];
	     
	    if (sum%2 != 0)  
	       return false;
	   
	    boolean[][] part = new boolean[sum/2+1][n+1];
	     
	    for (i = 0; i <= n; i++)
	      part[0][i] = true;
	       
	    for (i = 1; i <= sum/2; i++)
	      part[i][0] = false;     
	      
	     for (i = 1; i <= sum/2; i++)  
	     {
	       for (j = 1; j <= n; j++)  
	       {
	         part[i][j] = part[i][j-1];
	         if (i >= arr[j-1])
	           part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
	       }        
	     }    
	      
	     for (i = 0; i <= sum/2; i++)  
	     {
	       for (j = 0; j <= n; j++)  
	          System.out.printf("%8b", part[i][j]);
	       System.out.println();
	     } 
	      
	     return part[sum/2][n];
	}     
	 
	
	private static boolean findPartiion (int arr[], int n)
	{
		 int sum = 0;
		 for (int i = 0; i < n; i++)
		    sum += arr[i];
	
		 if (sum%2 != 0)
		    return false;
	
		 return isSubsetSum (arr, n, sum/2);
	}

	public static void main(String[] args)
	{
		int arr[] = {3, 1, 5, 9, 12};
		int n = arr.length;
		if (findPartiion2(arr, n) == true)
		  System.out.println("Can be divided into two subsets of equal sum");
		else
		  System.out.println("Can not be divided into two subsets of equal sum");
	}
}

