import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void addStudent(String first_name, String last_name, String roll_num, String grade, String Address,
            String Phone_num) {
        Student student = new Student(first_name, last_name, roll_num, grade, Address, Phone_num);
        students.add(student);

    }

    public void removeStudent(String first_name, String last_name, String roll_num) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.first_name.equals(first_name) &&
                    student.last_name.equals(last_name) &&
                    student.roll_num.equals(roll_num)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(String first_name, String last_name, String roll_num) {
        for (Student student : students) {
            if (student.first_name.equals(first_name) &&
                    student.last_name.equals(last_name) &&
                    student.roll_num.equals(roll_num)) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
        System.out.println("----------------------------------------------------------");

    }

    public void display() {
        if (students.isEmpty()) {
            System.out.println("No Any Student Found");
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Scanner se = new Scanner(System.in);
        StudentManagement sms = new StudentManagement();
        System.out.println("WELCOME TO SYSTEM MANAGEMENT SYSTEM");
        while (true) {
            System.out.println("Select an option");
            System.out.println("1:Add Student");
            System.out.println("2:Remove Student");
            System.out.println("3:Search Student");
            System.out.println("4:Display Students");
            System.out.println("5:Exit");
            System.out.println("----------------------------------------------------------");

            int option = sc.nextInt();
            switch (option) {

                case 1:
                    System.out.print("Enter student first_name: ");
                    String first_name = se.nextLine();
                    System.out.print("Enter last_name: ");
                    String last_name = se.nextLine();
                    System.out.print("Enter roll_num: ");
                    String roll_num = se.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = se.nextLine();
                    System.out.print("Enter Address: ");
                    String Address = se.nextLine();
                    System.out.print("Enter Phone_num: ");
                    String Phone_num = se.nextLine();

                    sms.addStudent(first_name, last_name, roll_num, grade, Address, Phone_num);
                    System.out.println("----------------------------------------------------------");
                    break;
                case 2:
                    System.out.print("Enter student first_name: ");
                    first_name = se.nextLine();
                    System.out.print("Enter last_name: ");
                    last_name = se.nextLine();
                    System.out.print("Enter roll_num: ");
                    roll_num = se.nextLine();n 

                    sms.removeStudent(first_name, last_name, roll_num);
                    break;
                case 3:
                    System.out.print("Enter student first_name: ");
                    first_name = se.nextLine();
                    System.out.print("Enter last_name: ");
                    last_name = se.nextLine();
                    System.out.print("Enter roll_num: ");
                    roll_num = se.nextLine();
                    sms.searchStudent(first_name, last_name, roll_num);
                    System.out.println("----------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------");
                    sms.display();
                    break;
            }
            System.out.println("Do you want to continue y/n");
            char ch = se.nextLine().charAt(0);
            if (ch == 'y') {
                continue;
            } else if (ch == 'n')
                break;
        }
    }
}

class Student {
    String first_name, last_name, roll_num, grade, Address, Phone_num;

    public Student(String first_name, String last_name, String roll_num, String grade, String Address,
            String Phone_num) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.roll_num = roll_num;
        this.grade = grade;
        this.Address = Address;
        this.Phone_num = Phone_num;
    }

    public String toString() {
        return "First Name: " + first_name +
                "\nLast Name: " + last_name +
                "\nRoll Number: " + roll_num +
                "\nGrade: " + grade +
                "\nAddress: " + Address +
                "\nPhone Number: " + Phone_num;
    }

}