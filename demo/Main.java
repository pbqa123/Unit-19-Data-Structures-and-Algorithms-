/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentQueue queue = new StudentQueue();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Clear the newline character
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();

                    Student newStudent = new Student(id, name, marks);
                    queue.enqueue(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.println("\n--- Student List ---");
                    queue.display();
                    break;

                case 3:
                    System.out.print("Enter Student ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();  // Clear the newline character
                    queue.editStudent(editId, scanner);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    queue.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    queue.searchStudent(searchId);
                    break;

                case 6:
                    queue.sortByMarks();
                    System.out.println("Students sorted by marks.");
                    break;

                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

