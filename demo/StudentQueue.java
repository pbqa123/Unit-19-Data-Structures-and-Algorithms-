/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;
import java.util.Scanner;

class StudentQueue {
    Node front, rear;

    public StudentQueue() {
        this.front = this.rear = null;
    }

    // Add a new student
    public void enqueue(Student student) {
        Node newNode = new Node(student);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Display all students
    public void display() {
        Node temp = front;
        if (temp == null) {
            System.out.println("The queue is empty.");
            return;
        }
        while (temp != null) {
            temp.student.displayStudent();
            temp = temp.next;
        }
    }

    // Edit a student's information
    public void editStudent(int id, Scanner scanner) {
        Node temp = front;
        while (temp != null && temp.student.id != id) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found.");
        } else {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new marks: ");
            double newMarks = scanner.nextDouble();
            temp.student.setName(newName);
            temp.student.setMarks(newMarks);
            System.out.println("Student information updated.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        Node temp = front, prev = null;
        while (temp != null && temp.student.id != id) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found.");
            return;
        }
        if (temp == front) {
            front = front.next;
        } else {
            prev.next = temp.next;
        }
        if (temp == rear) {
            rear = prev;
        }
        System.out.println("Student deleted.");
    }

    void sortByMarks() {
        if (front == null || front.next == null) {
            return; // Queue is empty or has only one student, no need to sort.
        }
        boolean swapped;
        do {
            Node current = front;
            Node prev = null;
            Node next = current.next;
            swapped = false;
            while (next != null) {
                if (current.student.getMarks() > next.student.getMarks()) {
                    // Swap nodes
                    if (prev == null) {
                        front = next;
                    } else {
                        prev.next = next;
                    }
                    current.next = next.next;
                    next.next = current;

                    // Update pointers for next iteration
                    prev = next;
                    next = current.next;
                    swapped = true;
                } else {
                    // Move to the next pair
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }

    void searchStudent(int searchId) {
        Node temp = front;
        while (temp != null) {
            if (temp.student.id == searchId) {
                temp.student.displayStudent();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
}


