import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases;
        numTestCases = in.nextInt();
        int[] arr = new int[numTestCases];
        for(int i = 0; i<numTestCases; i++)
            {
            arr[i] = in.nextInt();
            int result = calcUtopianHeight(arr[i]);
            System.out.println(result);
        }
        in.close();
    }
    
    public static int calcUtopianHeight(int n)
        {
        int result = 1;
        for(int i=1; i<=n && n<=60; i++)
            {
            if(i%2 == 1)
                {
                result = result * 2;
            }
            else
                {
                result = result + 1;
            }
        }
        return result;
    }
}