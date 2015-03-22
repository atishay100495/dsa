import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item> {
    private int N;         
    private Node first;    
    private Node last;     

    private class Node {
        private Item item;
        private Node next;
    }

    public Queue() {
        first = null;
        last  = null;
        N = 0;
        assert check();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;     
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
        assert check();
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;  
        assert check();
        return item;
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
            if (last  != null) return false;
        }
        else if (N == 1) {
            if (first == null || last == null) return false;
            if (first != last)                 return false;
            if (first.next != null)            return false;
        }
        else {
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
               numberOfNodes++;
            }
            if (numberOfNodes != N) return false;

            Node lastNode = first;
            while (lastNode.next != null) {
               lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

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
        Queue<String> q = new Queue<String>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of items:");
		int numItems = in.nextInt();
		System.out.println("Enqueue Items:");
		for(int i = 0; i<numItems; i++)
		{
			String item = in.next();
			q.enqueue(item);
		}
		System.out.println();
		System.out.println("Size:");
        System.out.println(q.size());
        System.out.println();
        System.out.println("List of items in queue:");
        for(String item: q)
        {
        	System.out.println(item);
        }
        System.out.println();
        System.out.println("Dequeuing:");
        while(!q.isEmpty())
        {
        	System.out.println(q.dequeue());
        }
        System.out.println();
        System.out.println(q.size());
        in.close();
    }
}
