import java.io.*;
import java.util.*;

public class StudentInfo {
    public static void main(String[] args) {
        List<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for student information until they choose to exit
        while (true) {
            System.out.println("Enter student data (or type 'exit' to finish):");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Address: ");
            String address = scanner.nextLine();

            //Prevents an impossible GPA from being inputed
            double GPA = -1;
            while (GPA < 0 || GPA > 4) {
                System.out.print("GPA: ");
                if (scanner.hasNextDouble()) {
                    GPA = scanner.nextDouble();
                    if (GPA < 0 || GPA > 4) {
                        System.out.println("GPA must be between 0 and 4");
                    }
                } else {
                    System.out.println("Invalid input. GPA must be a number between 0 and 4");
                    scanner.next(); // consume invalid input
                }
            }
            scanner.nextLine(); // Consume the newline character

            Student student = new Student(name, address, GPA);
            studentList.add(student);
        }

        // Sort the student list by name in ascending order
        Collections.sort(studentList, (s1, s2) -> s1.getName().compareTo(s2.getName()));

        // Write the sorted student data to a text file
        try (FileWriter writer = new FileWriter("student_data.txt")) {
            for (Student student : studentList) {
                writer.write(student.toString());
            }
            System.out.println("Student data has been written to student_data.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}