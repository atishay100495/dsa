import java.util.Arrays;

public class Problem3 {

	public static void main(String[] args)
	{
		int n = 2;
		int m = 4;
		int[] a= {2, 5};
		Problem3 p = new Problem3();
		int result = p.calc(n, m, a);
		System.out.println(result);
	}
	
	public int calc(int n, int m, int[] a)
	{
		int result = 0;
		int count = m;
		Arrays.sort(a);
		while(count > 0)
		{
			int index = reset(a);
			result = result + a[index];
			a[index] = a[index]-1;
			count--;
		}
		
		return result;
	}
	
	public static int reset(int[] a)
	{
		int i=a.length-1;
		
		if(i>0)
		{
			while(a[i] == a[i-1])
			{
				i--;
				if(i==0)
				{
					break;
				}
			}
		}
		
		return i;
	}
	
}
