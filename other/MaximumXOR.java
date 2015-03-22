import java.util.Scanner;


public class MaximumXOR {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int R = in.nextInt();
		
		int max = 0;
		
		for(int i=L; i<=R; i++)
		{
			int a = i;
			for(int j=L; j<=R; j++)
			{
				int b = j;
				int temp_result = a^b;
				if(max < temp_result)
				{
					max = temp_result;
				}
			}
		}
		
		System.out.println(max);
		in.close();
	}
}
