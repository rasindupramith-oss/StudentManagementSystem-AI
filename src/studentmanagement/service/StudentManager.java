package studentmanagement.service;

import studentmanagement.model.Student;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        Student foundStudent = searchStudentById(student.getStudentId());
        if (foundStudent != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }

        printTableHeader();
        for (Student currentStudent : students) {
            printStudent(currentStudent);
        }

        System.out.println("---------------------------------------------------------------");
    }

    public Student searchStudentById(String studentId) {
        for (Student currentStudent : students) {
            if(currentStudent.getStudentId().equals(studentId)) {
                return currentStudent;
            }
        }
        return null;
    }

    public boolean updateStudent(String studentId,String name,int age,String course,double gpa) {
        Student foundStudent = searchStudentById(studentId);
        if (foundStudent != null) {
            foundStudent.setName(name);
            foundStudent.setAge(age);
            foundStudent.setCourse(course);
            foundStudent.setGpa(gpa);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String studentId) {
        Student foundStudent = searchStudentById(studentId);
        if (foundStudent == null) {
            return false;
        }
        students.remove(foundStudent);
        return true;
    }

    private void printTableHeader() {
        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-5s %-20s %-5s%n",
                "ID", "Name", "Age", "Course", "GPA");
        System.out.println("---------------------------------------------------------------");
    }

    private void printStudent(Student student) {
        System.out.printf("%-10s %-20s %-5d %-20s %-5.2f%n",
                student.getStudentId(),
                student.getName(),
                student.getAge(),
                student.getCourse(),
                student.getGpa());
    }

    public int getTotalStudents() {
        return students.size();
    }

    public double getAverageGpa() {
        if (students.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Student currentStudent : students) {
            total += currentStudent.getGpa();
        }

        return total / students.size();
    }

    public double getHighestGpa() {
        if (students.isEmpty()) {
            return 0;
        }

        double highest = students.get(0).getGpa();

        for (Student currentStudent : students) {
            if (currentStudent.getGpa() > highest) {
                highest = currentStudent.getGpa();
            }
        }

        return highest;
    }

    public double getLowestGpa() {
        if (students.isEmpty()) {
            return 0;
        }

        double lowest = students.get(0).getGpa();

        for (Student currentStudent : students) {
            if (currentStudent.getGpa() < lowest) {
                lowest = currentStudent.getGpa();
            }
        }

        return lowest;
    }


}
