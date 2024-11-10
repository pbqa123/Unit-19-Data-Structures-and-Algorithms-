/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;
class Student {
    int id;
    String name;
    double marks;
    String rank;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = determineRank(marks);
    }

    private String determineRank(double marks) {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = determineRank(marks); // Update rank when marks are changed
    }

    // Display student details
    public void displayStudent() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank);
    }

    // Getter for marks
    public double getMarks() {
        return this.marks;
    }

    // Optional Getters for other fields if needed
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRank() {
        return this.rank;
    }
}

