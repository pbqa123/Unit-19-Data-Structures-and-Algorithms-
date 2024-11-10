/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreeAlgorithm;

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

class BSTNode {
    Student student;
    BSTNode left, right;

    public BSTNode(Student student) {
        this.student = student;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private BSTNode insertRec(BSTNode root, Student student) {
        if (root == null) {
            root = new BSTNode(student);
            return root;
        }
        if (student.grade < root.student.grade) {
            root.left = insertRec(root.left, student);
        } else if (student.grade > root.student.grade) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.student);
            inOrderRec(root.right);
        }
    }
    
    public Student search(double grade) {
        return searchRec(root, grade);
    }

    private Student searchRec(BSTNode root, double grade) {
        if (root == null || root.student.grade == grade) {
            return (root != null) ? root.student : null;
        }
        if (grade < root.student.grade) {
            return searchRec(root.left, grade);
        }
        return searchRec(root.right, grade);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(new Student("S001", "Alice", 8.5));
        bst.insert(new Student("S002", "Bob", 6.0));
        bst.insert(new Student("S003", "Charlie", 7.2));
        bst.insert(new Student("S004", "David", 5.4));
        bst.insert(new Student("S005", "Eve", 9.1));

        System.out.println("In-Order Traversal of BST:");
        bst.inOrderTraversal();
        
        double searchGrade = 7.2;
        Student foundStudent = bst.search(searchGrade);
        System.out.println("\nSearching for grade " + searchGrade + ": " + (foundStudent != null ? foundStudent : "Not found"));
    }
}

