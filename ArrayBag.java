public class ArrayBag {
    private Object[] items;
    private int numItems;

    public static final int DEFAULT_MAX_SIZE = 50;
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE]; this.numItems = 0;
    }
    public ArrayBag(int maxSize) { 
        if (maxSize <= 0) {
            throw new IllegalArgumentException( "maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }

    public void setNumItems() {
        int i = 0;
        while (i < items.length) {
            if (items[i] == null)
                break;
            
            i++;
        }
        numItems = i;
    }

    public boolean add(Object item) {
        if (item == null)
            throw new IllegalArgumentException();
    
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                numItems++;
                return true;
            }
        }

        return false;
    }

    public boolean contains(Object item) {
        if (item == null) 
            throw new IllegalArgumentExeception();
        
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item))
                return true;
        }
    
        return false;
    }
}

/*
public boolean contains(Object item) {
    if (item == null) 
        throw new IllegalArgumentExeception();
    
    for (int i = 0; i < this.numItems; i++) {
        if (this.items[i].equals(item))
            return true;
    }

    return false;
}
*/