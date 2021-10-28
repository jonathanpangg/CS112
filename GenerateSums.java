public class GenerateSums {
    public static String generateSums(int n) {
        int sum = 0;
        String s = "";

        for (int i = 1; i <= n; i++) {
            sum += i;

            if (i != n)
                s += (sum + "\n");

            else
                s += sum;
        }

        return s;
    }
    
    public static void main(String [] args) {
        System.out.println(generateSums(6));
    }
}