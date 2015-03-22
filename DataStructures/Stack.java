import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Stack<Item> implements Iterable<Item> {
    private int N;          
    private Node first;     

    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
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

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
        assert check();
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        
        first = first.next;            
        N--;
        assert check();
        return item;                   
    }


    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
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


    public Iterator<Item> iterator()  { return new ListIterator();  }

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
        Stack<String> s = new Stack<String>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of items:");
		int numItems = in.nextInt();
		System.out.println("Push Items:");
		for(int i = 0; i<numItems; i++)
		{
			String item = in.next();
			s.push(item);
		}
		System.out.println();
		System.out.println("Size:");
        System.out.println(s.size());
        System.out.println();
        System.out.println("List of items in stack:");
        for(String item: s)
        {
        	System.out.println(item);
        }
        System.out.println();
        System.out.println("Pop all items:");
        while(!s.isEmpty())
        {
        	System.out.println(s.pop());
        }
        System.out.println();
        System.out.println(s.size());
        in.close();
    }
}

