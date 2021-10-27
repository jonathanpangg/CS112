import java.util.*;

public class Greetings2 {
    public static void greetMe() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scan.nextLine();
        System.out.println("Hello " + name +", Welcome to CS112!!!");
        System.out.print(name + " how old are you? ");
        int age = scan.nextInt();
        System.out.println("");
        insult(name, age);
        scan.close();
    }

    public static void insult(String name, int age) {
        System.out.print("Holy cow " + name + ", ");
        if (age >= 1 && age <= 10) {
            System.out.println("you are sweet.");
        }
        else if (age >= 11 && age <= 17) {
            System.out.println("you are dweebs.");
        }
        else if (age >= 18 && age <= 20) {
            System.out.println("you are counting down to legal age.");
        }
        else if (age == 21) {
            System.out.println("you just made legal age.");
        }
        else if (age >= 22 && age <= 29) {
            System.out.println("you are counting down to 30.");
        }
        else if (age >= 30 && age <= 40) {
            System.out.println("you are suffering adults");
        }
        else if (age >= 41 && age < 50) {
            System.out.println("you are miserable adults");
        }
        else if (age >= 50) {
            System.out.println("you are speechless!!");
        }
        else {
            System.out.println("You entered a negative age.");
        }
    }

    public static void main(String [] args) {
        greetMe();
    }
}
