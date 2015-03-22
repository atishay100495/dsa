public class Maze 
{
	public static int N = 4;

	private static void printSolution(int sol[][])
	{
	 for (int i = 0; i < N; i++)
	 {
	     for (int j = 0; j < N; j++)
	         System.out.printf(" %d ", sol[i][j]);
	     System.out.println();
	 }
	}

	private static boolean isSafe(int maze[][], int x, int y)
	{
	 if(x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1)
	     return true;

	 return false;
	}

	private static boolean solveMaze(int maze[][])
	{
	 int sol[][] = { {0, 0, 0, 0},
	     {0, 0, 0, 0},
	     {0, 0, 0, 0},
	     {0, 0, 0, 0}
	 };

	 if(solveMazeUtil(maze, 0, 0, sol) == false)
	 {
	     System.out.println("Solution doesn't exist");
	     return false;
	 }

	 printSolution(sol);
	 return true;
	}

	private static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][])
	{
	 if(x == N-1 && y == N-1)
	 {
	     sol[x][y] = 1;
	     return true;
	 }

	 if(isSafe(maze, x, y) == true)
	 {
	     sol[x][y] = 1;

	     if (solveMazeUtil(maze, x+1, y, sol) == true)
	         return true;

	     if (solveMazeUtil(maze, x, y+1, sol) == true)
	         return true;

	     sol[x][y] = 0;
	     return false;
	 }   

	 return false;
	}

	public static void main(String[] args)
	{
		 int[][] maze =  { {1, 0, 0, 0},
		     {1, 1, 0, 1},
		     {0, 1, 0, 0},
		     {1, 1, 1, 1}
		 };
		
		 solveMaze(maze);
	}
}

