import java.util.Scanner;


public class Divisibility {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long p = in.nextLong();
		long q = in.nextLong();
		
		long s = in.nextLong();
		
		for(int i=0; i<q; i++)
		{
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			long[] nums = getNums(a, b, s);
			int numDivisible = getNumberOfDivisibleNums(nums, p);
			System.out.println(numDivisible);
		}
		in.close();
	}
	
	public static long[] getNums(int a, int b, long s)
	{
		String str = String.valueOf(s);
		int numEntries = 0;
		numEntries = (b-a+1) * (b-a+1);
		long[] subs = new long[numEntries];
		int m = 0;
		for(int i=a; i<=b; i++)
		{
			for(int j=i; j<=b; j++)
			{
				String sub = str.substring(a, b+1);
				subs[m] = Long.parseLong(sub);
				m++;
			}
		}
		
		return subs;
	}
	
	public static int getNumberOfDivisibleNums(long[] nums, long p)
	{
		int result = 0;
		
		for(long num: nums)
		{
			System.out.println(num + "%" + p + ":");
			if(isDivisible(num, p))
			{
				System.out.print("true");
				result++;
			}
		}
		
		return result;
	}
	
	public static boolean isDivisible(long num, long p)
	{
		boolean isDiv = false;
		
		if(num % p == 0)
		{
			isDiv = true;
		}
		
		return isDiv;
	}
}
