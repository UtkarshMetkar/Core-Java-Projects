import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            System.out.print("Enter the choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter roll number: ");
                    int rollNumber = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();

                    boolean rollExists = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).rollNumber == rollNumber) {
                            rollExists = true;
                            break;
                        }
                    }

                    if (rollNumber <= 0) {
                        System.out.println("Invalid roll number.");
                    } else if (marks < 0 || marks > 100) {
                        System.out.println("Invalid marks. Marks must be between 0 and 100.");
                    } else if (rollExists) {
                        System.out.println("Roll number already exists.");
                    } else {
                        Student student = new Student(rollNumber, name, marks);
                        students.add(student);

                        System.out.println("Student added successfully!");
                    }

                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (int i = 0; i < students.size(); i++) {

                            Student s = students.get(i);

                            System.out.println("Roll Number: " + s.rollNumber);
                            System.out.println("Name: " + s.name);
                            System.out.println("Marks: " + s.marks);
                            System.out.println("--------------------------");
                        }
                    }

                    break;

                case 3:
                    System.out.print("Enter the roll number to search: ");
                    int searchRollNumber = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < students.size(); i++) {

                        Student s = students.get(i);

                        if (s.rollNumber == searchRollNumber) {
                            System.out.println("Student found!");
                            System.out.println("Roll Number: " + s.rollNumber);
                            System.out.println("Name: " + s.name);
                            System.out.println("Marks: " + s.marks);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:
                    System.out.println("Thank you for using the Student Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}