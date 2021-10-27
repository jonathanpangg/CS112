public class ValuePair {
    private int a;
    private double b;
    
    public ValuePair(int a, double b) {
        setA(a);
        setB(b);
    }

    public double product() {
        return this.a * this.b;
    }

    public int getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public void setA(int num) {
        if (num % 2 == 0) 
        	this.a = num;
        else 
            throw new IllegalArgumentException();
    }

    public void setB(double num) {
        if (this.b >= 0) 
        	this.b = num;
        else 
            throw new IllegalArgumentException();
    }
}
