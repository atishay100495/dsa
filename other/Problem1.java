
public class Problem1 {

	public static void main(String[] args)
	{
		int a[] = {7, 9, 5, 6, 3, 2};
		Problem1 p = new Problem1();
		int max = p.maxDiff(a);
		System.out.println(max);
	}
	
	public int maxDiff(int[] a)
	{
		int len = a.length;
		int max = -1;
		for(int i=0; i<len; i++)
		{
			
			int temp = a[i];
			for(int j=i; j<len; j++)
			{
				if(a[j] > temp)
				{
					int tempVal = a[j] - temp;
					if(tempVal > max)
					{
						max = tempVal;
					}
				}
			}
		}
		return max;
	}
}
