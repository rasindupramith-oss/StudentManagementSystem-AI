package studentmanagement.app;

import studentmanagement.model.Student;
import studentmanagement.service.StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("========================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n----- Add Student -----");
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.next();
                    scanner.nextLine();

                    String name;
                    while (true) {
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();

                        if (!name.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Name cannot be empty.");
                    }

                    int age;
                    while (true) {
                        System.out.print("Enter Age: ");
                        age = scanner.nextInt();

                        if (age > 0) {
                            break;
                        }
                        System.out.println("Age must be greater than 0.");
                    }
                    scanner.nextLine();

                    String course;
                    while (true) {
                        System.out.print("Enter Course: ");
                        course = scanner.nextLine();

                        if (!course.trim().isEmpty()) {
                            break;
                        }

                        System.out.println("Course cannot be empty.");
                    }

                    double gpa;
                    while (true) {
                        System.out.print("Enter GPA: ");
                        gpa = scanner.nextDouble();

                        if (gpa >= 0 && gpa <= 4) {
                            break;
                        }
                        System.out.println("GPA must be between 0.0 and 4.0");
                    }

                    Student s1 = new Student(studentId, name, age, course, gpa);
                    boolean added = manager.addStudent(s1);

                    if (added) {
                        System.out.println("\nStudent added successfully!");
                    } else {
                        System.out.println("\nStudent ID already exists.");
                    }

                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    System.out.println("\n----- Search Student -----");
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.next();

                    Student foundStudent = manager.searchStudentById(searchId);

                    if (foundStudent != null) {
                        System.out.println("\nStudent Found:");
                        System.out.println("---------------------------------------------------------------");
                        System.out.printf("%-10s %-20s %-5s %-20s %-5s%n",
                                "ID", "Name", "Age", "Course", "GPA");
                        System.out.println("---------------------------------------------------------------");

                        System.out.printf("%-10s %-20s %-5d %-20s %-5.2f%n",
                                foundStudent.getStudentId(),
                                foundStudent.getName(),
                                foundStudent.getAge(),
                                foundStudent.getCourse(),
                                foundStudent.getGpa());

                        System.out.println("---------------------------------------------------------------");
                    } else {
                        System.out.println("\nStudent not found.");
                    }
                    break;

                case 4:
                    System.out.println("\n----- Update Student -----");
                    System.out.print("Enter Student ID: ");
                    String updateId = scanner.next();
                    scanner.nextLine();

                    Student studentToUpdate = manager.searchStudentById(updateId);

                    if (studentToUpdate == null){
                        System.out.println("\nStudent not found.");
                    } else {
                        System.out.println("\nCurrent Student Details:");
                        System.out.println("---------------------------------------------------------------");
                        System.out.printf("%-10s %-20s %-5s %-20s %-5s%n",
                                "ID", "Name", "Age", "Course", "GPA");
                        System.out.println("---------------------------------------------------------------");

                        System.out.printf("%-10s %-20s %-5d %-20s %-5.2f%n",
                                studentToUpdate.getStudentId(),
                                studentToUpdate.getName(),
                                studentToUpdate.getAge(),
                                studentToUpdate.getCourse(),
                                studentToUpdate.getGpa());

                        System.out.println("---------------------------------------------------------------");

                        String updateName;
                        while (true) {
                            System.out.print("Enter new Name: ");
                            updateName = scanner.nextLine();

                            if (!updateName.trim().isEmpty()) {
                                break;
                            }
                            System.out.println("Name cannot be empty.");
                        }

                        int updateAge;
                        while (true) {
                            System.out.print("Enter new Age: ");
                            updateAge = scanner.nextInt();

                            if (updateAge > 0) {
                                break;
                            }
                            System.out.println("Age must be greater than 0.");
                        }
                        scanner.nextLine();

                        String updateCourse;
                        while (true) {
                            System.out.print("Enter new Course: ");
                            updateCourse = scanner.nextLine();

                            if (!updateCourse.trim().isEmpty()) {
                                break;
                            }
                            System.out.println("Course cannot be empty.");
                        }

                        double updateGpa;
                        while (true) {
                            System.out.print("Enter new GPA: ");
                            updateGpa = scanner.nextDouble();

                            if (updateGpa >= 0.0 && updateGpa <= 4.0) {
                                break;
                            }
                            System.out.println("GPA must be between 0.0 and 4.0.");
                        }

                        manager.updateStudent(updateId, updateName, updateAge, updateCourse, updateGpa);

                        System.out.println("Student updated successfully!");
                    }

                    break;

                case 5:
                    System.out.println("\n----- Delete Student -----");
                    System.out.print("Enter Student ID: ");
                    String deleteId = scanner.next();
                    scanner.nextLine();

                    Student studentToDelete = manager.searchStudentById(deleteId);

                    if (studentToDelete == null){
                        System.out.println("\nStudent not found.");
                    } else {
                        System.out.println("\nCurrent Student Details:");
                        System.out.println("---------------------------------------------------------------");
                        System.out.printf("%-10s %-20s %-5s %-20s %-5s%n",
                                "ID", "Name", "Age", "Course", "GPA");
                        System.out.println("---------------------------------------------------------------");

                        System.out.printf("%-10s %-20s %-5d %-20s %-5.2f%n",
                                studentToDelete.getStudentId(),
                                studentToDelete.getName(),
                                studentToDelete.getAge(),
                                studentToDelete.getCourse(),
                                studentToDelete.getGpa());

                        System.out.println("---------------------------------------------------------------");
                        System.out.print("Are you sure you want to delete this student? (Y/N): ");
                        String decision = scanner.next();

                        if (decision.equalsIgnoreCase("Y") ){
                            manager.deleteStudent(deleteId);
                            System.out.println("\nStudent deleted successfully!");
                        } else {
                            System.out.println("\nDeletion cancelled.");
                        }
                    }
                    break;

                case 6:
                    running = false;
                    scanner.close();
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");

            }
            System.out.println();
        }
    }
}
