public class GenerateSums {
    public static String generateSums(int n) {
        int sum = 0;
        String s = "";
        String copy = "";

        for (int i = 1; i <= n; i++) {
            sum += i;

            if (i == 1) {
                copy += (i + "");
                s += (copy + "\n");
            }

            else if (i < n) {
                copy += (" + " + i);
                s += (copy + " = " + sum + "\n");
            }

            else {
                copy += (" + " + i);
                s += (copy + " = " + sum);
            }
        }

        return s;
    }

    public static void main(String [] args) {
        System.out.println(generateSums(6));
    }
}