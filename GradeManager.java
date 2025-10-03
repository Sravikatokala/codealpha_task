import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeManager {
    private List<Student> students;
    private Scanner scanner;

    public GradeManager() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    displaySummaryReport();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n--- Student Grade Management System ---");
        System.out.println("1. Add a new student");
        System.out.println("2. Add grades for an existing student");
        System.out.println("3. Display summary report");
        System.out.println("4. Exit");
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student newStudent = new Student(name);
        students.add(newStudent);
        System.out.println("Student " + name + " added.");
    }

    private void addGradeToStudent() {
        if (students.isEmpty()) {
            System.out.println("No students in the system. Please add a student first.");
            return;
        }

        System.out.print("Enter student name to add a grade: ");
        String name = scanner.nextLine();
        Student student = findStudent(name);

        if (student != null) {
            double grade = readDouble("Enter grade for " + name + ": ");
            student.addGrade(grade);
            System.out.println("Grade added for " + name + ".");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displaySummaryReport() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("\n--- Grade Summary Report ---");
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            if (student.getGrades().isEmpty()) {
                System.out.println("  No grades recorded.");
            } else {
                System.out.printf("  Average Score: %.2f\n", student.getAverageScore());
                System.out.printf("  Highest Score: %.1f\n", student.getHighestScore());
                System.out.printf("  Lowest Score: %.1f\n", student.getLowestScore());
                System.out.println("  All Grades: " + student.getGrades());
            }
            System.out.println();
        }
    }

    private Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                return value;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                return value;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    public static void main(String[] args) {
        GradeManager manager = new GradeManager();
        manager.start();
    }
}
