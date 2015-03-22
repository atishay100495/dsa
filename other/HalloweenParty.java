import java.util.Scanner;


public class HalloweenParty {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numTestCases = in.nextInt();
		
		for(int i = 0; i<numTestCases; i++)
		{
			long n = in.nextLong();
			long numOps = calculateNumPieces(n);
			System.out.println(numOps);
		}
		in.close();
	}
	
	public static long calculateNumPieces(long n)
	{
		long result = 0;
		
		long nBy2 = n/2;
		if(n % 2 == 0)
		{
			result = nBy2 * nBy2;
		}
		else
		{
			result = nBy2 * (nBy2 + 1);
		}
		
		return result;
	}
}
