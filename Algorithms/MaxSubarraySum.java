public class MaxSubarraySum 
{
	private static int max(int a, int b) { return (a > b)? a : b; }
	 
	private static int max(int a, int b, int c) { return max(max(a, b), c); }
	 
	private static int maxCrossingSum(int arr[], int l, int m, int h)
	{
	    int sum = 0;
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= l; i--)
	    {
	        sum = sum + arr[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++)
	    {
	        sum = sum + arr[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	 
	    return left_sum + right_sum;
	}
	 
	private static int maxSubArraySum(int arr[], int l, int h)
	{
	   if (l == h)
	     return arr[l];
	 
	   int m = (l + h)/2;
	 
	   return max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h),
	              maxCrossingSum(arr, l, m, h));
	}
	 
	public static void main(String[] args)
	{
	   int arr[] = {2, 3, 4, 5, 7};
	   int arr2[] = {-2, -5, 6, -2, -3, 1, 5, -6};
	   int n = arr2.length;
	   int max_sum = maxSubArraySum(arr2, 0, n-1);
	   System.out.printf("Maximum contiguous sum is %d\n", max_sum);
	}
}
