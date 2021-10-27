public class RomanNumeral {
    private String romanNum;

    public RomanNumeral(String romanNum) {
        this.romanNum = romanNum;
    }

    private static int convertSingleRomanNumeral(char numeral) {
        int val = 0;

        if(numeral == 'I') {
            val = 1;
        } else if(numeral == 'V') {
            val = 5;
        } else if(numeral == 'X') {
            val = 10;
        } else if(numeral == 'L') {
            val = 50;
        } else if(numeral == 'C') {
            val = 100;
        } else if(numeral == 'D') {
            val = 500;
        } else if(numeral == 'M') {
            val = 1000;
        }

        return  val;
    }

    public static int convert(String romanNum) {
        int numericalValue = 0, n = 0, n1 = 0;

        for ( int i = 0; i < romanNum.length() - 1; i++ ) {
            n = convertSingleRomanNumeral(romanNum.charAt(i));
            n1 = convertSingleRomanNumeral(romanNum.charAt(i+1));

            if ( n < n1 ) {
                numericalValue -= n;
            } else {
                numericalValue += n;
            }
        }

        if ( n1 == 0 )
            n1 = convertSingleRomanNumeral(romanNum.charAt(0));
        numericalValue += n1;
        return( numericalValue );
    }

    public boolean equals(RomanNumeral other) {
        return convert(this.romanNum) == convert(other.romanNum);
    }

    public int add(RomanNumeral other) {
        return convert(this.romanNum) + convert(other.romanNum);
    }

    public String toString() {
        return convert(this.romanNum) + "";
    }

    public static void main(String [] args) {
        RomanNumeral r1 = new RomanNumeral("X");
        RomanNumeral r2 = new RomanNumeral("IX");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1.add(r2));
        System.out.println(r1.equals(r2));
    }
}
/**
 * 1 1 roman
 * roman
 * 
 */