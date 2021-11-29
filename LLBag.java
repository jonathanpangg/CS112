/*
 * LLBag.java
 * 
 * Jonathan Pang
 * LLBag Class
 */

import java.util.*;

public class LLBag implements Bag {
    private static class Node {
        Object object;
        Node next;

        private Node(Object o, Node n) {
            object = o;
            next = n;
        }
    }
    private Node curr;
    private int numItems;

    public LLBag() {
        curr = null;
        numItems = 0;
    }

    // adds the object into the LLBag
    public boolean add(Object item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node newNode = new Node(item, curr);
        curr = newNode;
        numItems++;

        return true;
    }

    // returns a boolean and removes the provided object if possible
    public boolean remove(Object item) {
        if (item == null)
            throw new IllegalArgumentException();
        
        Node temp = curr;

        while (temp.next != null) {
            if (temp.equals(curr) && temp.object.equals(item)) {
                curr = curr.next;
                return true;
            }

            if (temp.next.object.equals(item)) {
                temp.next = temp.next.next;
                numItems--; 
                return true;
            }
            temp = temp.next;
        }
        
        return false;
    }

    // returns a boolean if the given object is in the LLBag
    public boolean contains(Object item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node temp = curr;

        while (temp != null) {
            if (temp.object.equals(item))
                return true;
            temp = temp.next;
        }

        return false;
    }

    // returns the length of the LLBag
    public int numItems() {
        return numItems;
    }

    // returns a random element within the LLBag
    public Object grab() {
        int random = (int) (Math.random() * numItems);

        Node temp = curr;
        int counter = 0;

        while (counter < random) {
            temp = temp.next;
            counter++;
        }

        return temp.object;
    }

    // returns an object array of the LLBag
    public Object [] toArray() {
        Object [] arr = new Object[numItems];

        Node temp = curr;
        int counter = 0;

        while (temp != null) {
            arr[counter] = temp.object;
            temp = temp.next;
            counter++;
        }

        return arr;
    }

    // returns the string representation of the LLBag
    public String toString() {
        String str = "{";
        
        Node temp = curr;

        while (temp != null) {
            str = str + temp.object;
            if (temp.next != null) {
                str += ", ";
            }

            temp = temp.next;
        }
        
        str = str + "}";
        return str;
    }

    /*
    public static void main(String [] args) {
        LLBag n = new LLBag();
        
        //test for add
        n.add("Hi");
        n.add("Hey");
        System.out.println(Arrays.toString(n.toArray()));
        
        //test for removes
        n.remove("Hey");
        System.out.println(Arrays.toString(n.toArray()));
        
        // test for contains
        System.out.println(n.contains("Hey"));
        System.out.println(n.contains("Hi"));

        // test for numItems
        System.out.println(n.numItems);

        // test for grab
        n.add("Hi");
        n.add("Hello");
        System.out.println(Arrays.toString(n.toArray()));
        System.out.println(n.grab());

        // test for toString
        System.out.println(n);
    }
    */

    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an ArrayBag named bag1.
        System.out.print("size of bag 1: ");
        int size = scan.nextInt();
        LLBag bag1 = new LLBag();
        scan.nextLine();    // consume the rest of the line
        
        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < size; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // Iterate over the objects in bag1, printing them one per
        // line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
    }
}

/*
public interface Bag {
    boolean add(Object item);
     
    boolean remove(Object item);
     
    boolean contains(Object item);

    int numItems();

    Object grab();

    Object[] toArray();
} */
