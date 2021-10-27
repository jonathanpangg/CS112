public class Woo extends Zoo {
    int x;
    int y;

    public int two() {
        return 2;
    }

    public String toString() {
        return "hi";
    }

    public static void main(String [] args) {
        Zoo x = new Woo();
        System.out.println(x.a);
    }
}