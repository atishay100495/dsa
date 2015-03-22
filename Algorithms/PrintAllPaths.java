public class PrintAllPaths
	private static void printAllPathsUtil(int mat[][], int i, int j, int m, int n, int[] path, int pi)
	{
	 if (i == m - 1)
	 {
	     for (int k = j; k < n; k++)
	         path[pi + k - j] = mat[i][k];
	     for (int l = 0; l < pi + n - j; l++)
	         System.out.print(path[l]+" ");
	     System.out.println();
	     return;
	 }

	 if (j == n - 1)
	 {
	     for (int k = i; k < m; k++)
	         path[pi + k - i] = mat[k][j];
	     for (int l = 0; l < pi + m - i; l++)
	         System.out.print(path[l] + " ");
	     System.out.println();
	     return;
	 }

	 path[pi] = mat[i][j];

	 printAllPathsUtil(mat, i+1, j, m, n, path, pi + 1);

	 printAllPathsUtil(mat, i, j+1, m, n, path, pi + 1);

	}

	private static void printAllPaths(int mat[][], int m, int n)
	{
	 int[] path = new int[m+n];
	 printAllPathsUtil(mat, 0, 0, m, n, path, 0);
	}

	public static void main(String[] args)
	{
	 int mat[][] = {{1, 2, 3}, {4, 5, 6}};
	 printAllPaths(mat, 2, 3);
	}
}

