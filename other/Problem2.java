
public class Problem2 {

	public static void main(String[] args)
	{
		Problem2 p = new Problem2();
		String s = "abcbadcbcbcd";
		int n = p.shortPalin(s);
		System.out.println(n);
	}
	
	public int shortPalin(String s)
	{
		char last = s.charAt(s.length()-1);
		
		int index = 0;
		for(int i=0; i<s.length()-1; i++)
		{
			char temp = s.charAt(i);
			if(temp == last)
			{
				if(isPalindrome(s.substring(i)))
				{
					index = i;
				}
			}
		}
		
		return index;
	}
	
	public boolean isPalindrome(String str)
	{
		boolean isPalindrome = true;
		
		int i=0; 
		int j= str.length()-1;
		
		while(i<=j)
		{
			char i_char = str.charAt(i);
			char j_char = str.charAt(j);
			if(i_char != j_char)
			{
				isPalindrome = false;
			}
			i++;
			j--;
		}
		
		return isPalindrome;
	}
}
