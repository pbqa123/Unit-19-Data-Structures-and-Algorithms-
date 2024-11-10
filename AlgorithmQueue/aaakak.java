/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgorithmQueue;

class Student {
    String studentID;
    String fullName;
    double grade;

    public Student(String studentID, String fullName, double grade) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + studentID + ", Name: " + fullName + ", Grade: " + grade;
    }
}

class StudentQueue {
    private Student[] queue;
    private int front;
    private int rear;
    private int size;

    public StudentQueue(int capacity) {
        queue = new Student[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void addStudent(Student student) {
        if (size == queue.length) {
            System.out.println("Queue is full. Cannot add more students.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = student;
        size++;
    }

    public void displayStudents() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.println(queue[index]);
        }
    }

    // Bubble Sort - Sorts students by grade
    public void bubbleSort() {
        Student[] students = toArray();
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].grade > students[j + 1].grade) {
                    // Swap adjacent students
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        updateQueue(students);
    }

    // Selection Sort - Sorts students by grade
    public void selectionSort() {
        Student[] students = toArray();
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].grade < students[minIndex].grade) {
                    minIndex = j;
                }
            }
            // Swap minimum element with first element of unsorted part
            Student temp = students[minIndex];
            students[minIndex] = students[i];
            students[i] = temp;
        }
        updateQueue(students);
    }

    // Helper function to convert queue to array for sorting
    private Student[] toArray() {
        Student[] students = new Student[size];
        for (int i = 0; i < size; i++) {
            students[i] = queue[(front + i) % queue.length];
        }
        return students;
    }

    // Helper function to update queue after sorting
    private void updateQueue(Student[] students) {
        front = 0;
        rear = students.length - 1;
        size = students.length;
        for (int i = 0; i < students.length; i++) {
            queue[i] = students[i];
        }
    }

    public static void main(String[] args) {
        StudentQueue studentQueue = new StudentQueue(10);

        // Adding students to the queue
        studentQueue.addStudent(new Student("S001", "Alice", 8.5));
        studentQueue.addStudent(new Student("S002", "Bob", 6.0));
        studentQueue.addStudent(new Student("S003", "Charlie", 7.2));
        studentQueue.addStudent(new Student("S004", "David", 5.4));
        studentQueue.addStudent(new Student("S005", "Eve", 9.1));

        System.out.println("Original Queue:");
        studentQueue.displayStudents();

        // Bubble Sort
        studentQueue.bubbleSort();
        System.out.println("\nQueue after Bubble Sort:");
        studentQueue.displayStudents();

        // Adding new students for Selection Sort demonstration
        studentQueue.addStudent(new Student("S006", "Frank", 4.8));
        studentQueue.addStudent(new Student("S007", "Grace", 8.1));

        // Selection Sort
        studentQueue.selectionSort();
        System.out.println("\nQueue after Selection Sort:");
        studentQueue.displayStudents();
    }
}

