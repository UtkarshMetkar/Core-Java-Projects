import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int number = random.nextInt(100) + 1;

        System.out.println("I have chosen a number between 1 and 100.");

        System.out.print("Enter your guess: ");
        int guess = sc.nextInt();

        int attempts = 1;

        while (guess != number) {

            if (guess > number) {
                System.out.println("Too High!");
            } 
            else {
                System.out.println("Too Low!");
            }

            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;
        }

        System.out.println("Correct! You guessed the number.");
        System.out.println("Attempts: " + attempts);

        sc.close();
    }
}