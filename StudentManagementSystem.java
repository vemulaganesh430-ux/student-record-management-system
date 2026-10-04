 import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("     STUDENT RECORD MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }

    // Add Student
    public static void addStudent() {

        System.out.println("\n--- Add Student ---");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // View Students
    public static void viewStudents() {

        System.out.println("\n--- Student Records ---");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
            System.out.println("----------------------");
        }
    }

    // Update Student
    public static void updateStudent() {

        System.out.println("\n--- Update Student ---");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                scanner.nextLine();

                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter New Marks: ");
                double marks = scanner.nextDouble();

                student.setName(name);
                student.setMarks(marks);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.println("\n--- Delete Student ---");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}