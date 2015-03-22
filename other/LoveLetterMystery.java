import java.util.Scanner;


public class LoveLetterMystery {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numTestCases = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i<numTestCases; i++)
		{
			String input = in.nextLine().toString();
			int numOps = calcNumOperationsToConvertToPalindrome(input);
			System.out.println(numOps);
		}
		in.close();
	}
	
	public static int calcNumOperationsToConvertToPalindrome(String input)
	{
		int result = 0;
		int length = input.length();
		int left = 0, right = length-1;
		while(left <= right)
		{
			int leftCharInt = input.charAt(left);
			int rightCharInt = input.charAt(right);
			
			int difference = Math.abs(rightCharInt-leftCharInt);
			if(difference == 0)
			{
			}
			else
			{
				result = result + difference;
			}
			left = left + 1;
			right = right - 1;
			
		}
		
		return result;
	}
}

