import java.util.*;

public class Greetings {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scan.nextLine();
        System.out.println("Hello " + name +", Welcome to CS112!!!");
        System.out.print(name + " how old are you? ");
        int age = scan.nextInt();
        System.out.println("");
        scan.close();
        System.out.print("Wow " + name + "! ");
        if (age >= 1 && age <= 10) {
            System.out.println("You are sweet.");
        }
        else if (age >= 11 && age <= 17) {
            System.out.println("You are dweebs.");
        }
        else if (age >= 18 && age <= 20) {
            System.out.println("You are counting down to legal age.");
        }
        else if (age == 21) {
            System.out.println("You just made legal age.");
        }
        else if (age >= 22 && age <= 29) {
            System.out.println("You are counting down to 30.");
        }
        else if (age >= 30 && age <= 40) {
            System.out.println("You are suffering adults");
        }
        else if (age >= 41 && age < 50) {
            System.out.println("You are miserable adults");
        }
        else {
            System.out.println("You are speechless!!");
        }
    }
}
