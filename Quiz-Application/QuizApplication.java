import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {

        System.out.println("========= QUIZ APPLICATION =========");
        System.out.println("Welcome to the Java Quiz!");
        System.out.println("Answer the following questions.");

        Scanner sc = new Scanner(System.in);

        int score = 0;
        int answer;

        // Question 1
        System.out.println();
        System.out.println("Q1. Which language is used for Android development?");
        System.out.println("1. HTML");
        System.out.println("2. Java");
        System.out.println("3. CSS");
        System.out.println("4. SQL");

        while (true) {
            System.out.print("Enter your answer (1-4): ");

            if (sc.hasNextInt()) {
                answer = sc.nextInt();

                if (answer >= 1 && answer <= 4) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid input! Enter a number between 1 and 4.");
        }

        if (answer == 2) {
            System.out.println("Correct Answer!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
            System.out.println("Correct answer is Java.");
        }

        // Question 2
        System.out.println();
        System.out.println("Q2. Which keyword is used to create an object in Java?");
        System.out.println("1. class");
        System.out.println("2. void");
        System.out.println("3. new");
        System.out.println("4. static");

        while (true) {
            System.out.print("Enter your answer (1-4): ");

            if (sc.hasNextInt()) {
                answer = sc.nextInt();

                if (answer >= 1 && answer <= 4) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid input! Enter a number between 1 and 4.");
        }

        if (answer == 3) {
            System.out.println("Correct Answer!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
            System.out.println("Correct answer is new.");
        }

        // Question 3
        System.out.println();
        System.out.println("Q3. Which method is the starting point of a Java program?");
        System.out.println("1. start()");
        System.out.println("2. run()");
        System.out.println("3. main()");
        System.out.println("4. print()");

        while (true) {
            System.out.print("Enter your answer (1-4): ");

            if (sc.hasNextInt()) {
                answer = sc.nextInt();

                if (answer >= 1 && answer <= 4) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid input! Enter a number between 1 and 4.");
        }

        if (answer == 3) {
            System.out.println("Correct Answer!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
            System.out.println("Correct answer is main().");
        }

        // Final score
        System.out.println();
        System.out.println("========== QUIZ RESULT ==========");
        System.out.println("Final Score: " + score + "/3");

        if (score == 3) {
            System.out.println("Excellent! Perfect Score!");
        } else if (score == 2) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Keep Practicing!");
        }

        System.out.println();
        System.out.println("Thank you for playing!");
        System.out.println("Quiz completed successfully.");

        sc.close();
    }
}