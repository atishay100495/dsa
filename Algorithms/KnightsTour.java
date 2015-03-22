
public class KnightsTour 
{
	public static int N = 8;
	 
	private static int isSafe(int x, int y, int sol[][])
	{
	    if ( x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1)
	        return 1;
	    return 0;
	}
	 
	private static void printSolution(int sol[][])
	{
	    for (int x = 0; x < N; x++)
	    {
	        for (int y = 0; y < N; y++)
	            System.out.printf(" %2d ", sol[x][y]);
	        System.out.println();
	    }
	}
	 
	private static boolean solveKT()
	{
	    int[][] sol = new int[N][N];
	 
	    for (int x = 0; x < N; x++)
	        for (int y = 0; y < N; y++)
	            sol[x][y] = -1;
	 
	    int xMove[] = {  2, 1, -1, -2, -2, -1,  1,  2 };
	    int yMove[] = {  1, 2,  2,  1, -1, -2, -2, -1 };
	 
	    sol[0][0]  = 0;
	 
	    if(solveKTUtil(0, 0, 1, sol, xMove, yMove) == false)
	    {
	        System.out.println("Solution does not exist");
	        return false;
	    }
	    else
	        printSolution(sol);
	 
	    return true;
	}
	 
	private static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[],
	                int yMove[])
	{
	   int k, next_x, next_y;
	   if (movei == N*N)
	       return true;
	 
	   for (k = 0; k < 8; k++)
	   {
	       next_x = x + xMove[k];
	       next_y = y + yMove[k];
	       if (isSafe(next_x, next_y, sol)==1)
	       {
	         sol[next_x][next_y] = movei;
	         if (solveKTUtil(next_x, next_y, movei+1, sol, xMove, yMove) == true)
	             return true;
	         else
	             sol[next_x][next_y] = -1;
	       }
	   }
	 
	   return false;
	}
	 
	public static void main(String[] args)
	{
	    solveKT();
	}
}
