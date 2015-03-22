import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        System.out.println("Enter number of items:");
		int numItems = in.nextInt();
		int[] a = new int[numItems];
		System.out.println("Enter Items:");
		for(int i = 0; i<numItems; i++)
		{
			int item = in.nextInt();
			a[i] = item;
		}
    	
        Arrays.sort(a);

        System.out.println("Enter number of keys to find:");
		int numKeys = in.nextInt();
		for(int i = 0; i<numKeys; i++)
		{
			int key = in.nextInt();
			int index = rank(key, a);
			if(index == -1)
			{
				System.out.println(key + " not found...");
			}
			else
			{
				System.out.println(key + " found at "+index+1);
			}
		}
		in.close();
    }
}

