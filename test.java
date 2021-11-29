import java.util.*;

/*
public class test {
    public static void doubleAllStack(Stack <Object> stack, Object item) {
        Stack <Object> temp = new Stack <>();
        
        while (!stack.isEmpty()) {
            Object testing = stack.pop();
            
            if (testing.equals(item)) {
                temp.push(testing);
                temp.push(testing);
            }
            
            else 
                temp.push(testing);
        }
    
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }        

    public static void doubleAllQueue(Queue<Object> stack, Object item) {
        Queue <Object> temp = new LLQueue <>();
            
            while (!stack.isEmpty()) {
                Object testing = stack.remove();
                
                if (testing.equals(item)) {
                    temp.insert(testing);
                    temp.insert(testing);
                }
                
                else 
                    temp.insert(testing);
            }
        
            while (!temp.isEmpty()) {
                stack.insert(temp.remove());
            }
        }
        
    
    public static boolean search (Stack <Object> S, Object item) {
        Queue <Object> Q = new LLQueue <>();
        boolean returnVal = false;
    
        while (!S.isEmpty()) {
            Object test = S.pop();
    
            if (test.equals(item))
                returnVal = true;
            
            Q.insert(test);
        }
    
        while (!Q.isEmpty()) {
            S.push(Q.remove());
        }
    
        while (!S.isEmpty()) {
            Q.insert(S.pop());
        }
    
        while (!Q.isEmpty()) {
            S.push(Q.remove());
        }
        
        return returnVal;
    }
  
    public static void main(String [] args) {
        Queue <Object> test = new LLQueue <>();

        // {5, 2, 7, 2, 10}
        test.insert(5);
        test.insert(2);
        test.insert(7);
        test.insert(2);
        test.insert(10);
        
        doubleAllQueue(test, 2);

        while (!test.isEmpty()) 
            System.out.println(test.remove());
    }
}

*/

public class test extends LLList {
    public static LLList intersect(LLList list1, LLList list2) {
        LLList inters = new LLList();
        ListIterator iter1 = list1.iterator();
    
        while (iter1.hasNext()) {
            Object item1 = iter1.next();
            
            ListIterator iter2 = list2.iterator();
            while (iter2.hasNext()) {
                Object item2 = iter2.next();
                
                if (item1.equals(item2)) {
                    inters.addItem(item2, inters.length());
                }
            }
        }
    
        return inters;
    }
    
    public static void main(String [] args) {
        System.out.println(inters);
    }
}

public interface ListIterator {
    /*
     * does the iterator have additional items to visit?
     */
    boolean hasNext();

    /*
     * return a reference to the next Object in the iteration
     */
    Object next();
}

public class LLList implements List {
    // Inner class for a node.  We use an inner class so that the LLList
    // methods can access the instance variables of the nodes.
    private class Node {
        private Object item;
        private Node next;
        
        private Node(Object i, Node n) {
            item = i;
            next = n;
        }
    }
    
    // fields of the LLList object
    private Node head;     // dummy head node
    private int length;    // # of items in the list
    
    /*
     * Constructs a LLList object for a list that is initially empty.
     */
    public LLList() {
        head = new Node(null, null);
        length = 0;
    }
    
    /*
     * Constructs an LLList object containing the items in the specified array
     */
    public LLList(Object[] initItems) {
        head = new Node(null, null);
        
        Node prevNode = head;
        for (int i = 0; i < initItems.length; i++) {
            Node nextNode = new Node(initItems[i], null);
            prevNode.next = nextNode;
            prevNode = nextNode;
        }
        
        length = initItems.length;
    }
    
    /* 
     * length - returns the number of items in the list 
     */
    public int length() {
        return length;
    }
    
    /* 
     * isFull - always returns false, because the linked list can
     * grow indefinitely and thus the list is never full.
     */
    public boolean isFull() {
        return false;
    }
    
    /* 
     * getNode - private helper method that returns a reference to the
     * ith node in the linked list.  It assumes that the value of the
     * parameter is valid.  
     * 
     * If i == -1, it returns a reference to the dummy head node.
     */
    private Node getNode(int i) {
        Node trav = head;
        int travIndex = -1;
        
        while (travIndex < i) {
            travIndex++;
            trav = trav.next;
        }
        
        return trav;
    }
    
    /* 
     * getItem - returns the item at position i in the list 
     */
    public Object getItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        Node n = getNode(i);
        return n.item;
    }
    
    /* 
     * addItem - adds the specified item at position i in the list,
     * shifting the items that are currently in positions i, i+1, i+2,
     * etc. to the right by one.  Always returns true, because the list
     * is never full.
     *
     * We don't need a special case for insertion at the front of the
     * list (i == 0), because getNode(0 - 1) will return the dummy
     * head node, and the rest of insertion can proceed as usual.
     */
    public boolean addItem(Object item, int i) {
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        
        Node newNode = new Node(item, null);
        Node prevNode = getNode(i - 1);           
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        
        length++;
        return true;
    }
    
    /* 
     * removeItem - removes the item at position i in the list,
     * shifting the items that are currently in positions i+1, i+2,
     * etc. to the left by one.  Returns a reference to the removed
     * object.
     *
     * Here again, we don't need a special case for i == 0 (see the
     * note accompanying addItem above).
     */
    public Object removeItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        Node prevNode = getNode(i - 1);           
        Object removed = prevNode.next.item;
        prevNode.next = prevNode.next.next;
        
        length--;
        return removed;
    }
    
    /*
     * toString - converts the list into a String of the form 
     * {item0, item1, ...}
     */
    public String toString() {
        String str = "{";
        
        Node trav = head.next;    // skip over the dummy head node
        while (trav != null) {
            str = str + trav.item;
            if (trav.next != null) {
                str = str + ", ";
            }
            trav = trav.next;
        }
        
        str = str + "}";
        return str;
    }
    
    /*
     * iterator - returns an iterator for this list
     */
    public ListIterator iterator() {
        return new LLListIterator();
    }
    
    /*
     * private inner class for an iterator over an LLList
     */
    private class LLListIterator implements ListIterator {
        private Node nextNode;       // the next node to visit    
        
        public LLListIterator() {
            nextNode = head.next;    // skip over the dummy head node
        }
        
        /*
         * hasNext - does the iterator have additional items to visit?
         */
        public boolean hasNext() {
            return (nextNode != null);
        }
        
        /*
         * next - returns a reference to the next Object in the iteration
         */
        public Object next() {
            if (nextNode == null) {
                throw new NoSuchElementException();
            }
            
            Object item = nextNode.item;
            nextNode = nextNode.next;
            return item;
        }
    }
}

public interface List {
    /* returns the item at position i in the list */
    Object getItem(int i);

    /* 
     * adds the specified item at position i in the list, shifting the
     * items that are currently in positions i, i+1, i+2, etc. to the
     * right by one.  Returns false if the list is full, and true
     * otherwise.
     */
    boolean addItem(Object item, int i);

    /* 
     * removes the item at position i in the list, shifting the items
     * that are currently in positions i+1, i+2, etc. to the left by
     * one.  Returns a reference to the removed object.
     */
    Object removeItem(int i);

    /* returns the number of items in the list */
    int length();

    /* returns true if the list is full, and false otherwise */
    boolean isFull();

    /* returns an iterator object for this list. */
    ListIterator iterator();
}
