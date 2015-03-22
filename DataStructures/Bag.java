import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bag<Item> implements Iterable<Item> {
    private int N;         
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    public Bag() {
        first = null;
        N = 0;
        assert check();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
        assert check();
    }

    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
        }
        else if (N == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first.next == null) return false;
        }

        int numberOfNodes = 0;
        for (Node x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != N) return false;

        return true;
    } 

    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of items:");
		int numItems = in.nextInt();
		System.out.println("Enter Items:");
		for(int i = 0; i<numItems; i++)
		{
			String item = in.next();
			bag.add(item);
		}
        
        System.out.println("size of bag = " + bag.size());
        System.out.println("Printing items in bag:");
        for (String s : bag) {
            System.out.println(s);
        }
        
        in.close();
    }


}

