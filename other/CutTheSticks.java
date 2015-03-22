import java.util.Scanner;


public class CutTheSticks {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numTestCases = in.nextInt();
		int[] sticksArr = new int[numTestCases];
		
		for(int i = 0; i<numTestCases; i++)
		{
			sticksArr[i] = in.nextInt();
		}
		
		int numZeros = countNumZeros(sticksArr);
		while(numZeros !=sticksArr.length)
		{
			System.out.println(sticksArr.length - numZeros);
			int min = findMinInArray(sticksArr);
			for(int i=0; i<sticksArr.length; i++)
			{
				if(sticksArr[i] != 0)
				{
					sticksArr[i] = sticksArr[i] - min;
				}
			}
			numZeros = countNumZeros(sticksArr);
		}
		
		in.close();
	}
	
	public static int findMinInArray(int[] arr)
	{
		int min = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] < min && arr[i] > 0)
			{
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int countNumZeros(int[] arr)
	{
		int count = 0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] == 0)
			{
				count++;
			}
		}
		return count;
	}
	
	
}
