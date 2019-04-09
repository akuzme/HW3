package com.transfer.Student;

public class Student {
    private String name;
    private int rating;
    private static int count;
    private static double ratingSum;

    public Student(String name) {
        this.name = name;
        count++;
    }

    public Student(){
        count++;
    }

    public Student(String name, int rating){
        this.name = name;
        this.rating = rating;
        count++;
        ratingSum = ratingSum + this.rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        ratingSum = ratingSum - this.rating + rating;
        this.rating = rating;
    }

    public boolean betterStudent(Student student2){
        return this.rating > student2.rating;
    }

    public String toString(){
        return "Student " + name + " has rating " + rating;
    }

    public void changeRating(int changeRatingValue){
        ratingSum = ratingSum - this.rating + changeRatingValue;
        this.rating = changeRatingValue;
    }

    public static double getAverageRating(){
        if (count > 0){
        return ratingSum/count;
        }
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println("Average rating of all students is " + getAverageRating());
        Student student1 = new Student();
        student1.setName("Eva");
        student1.setRating(8);
        System.out.println("Average rating of all students is " + getAverageRating());
        Student student2 = new Student("Kris",9);
        System.out.println("Average rating of all students is " + getAverageRating());
        Student student3 = new Student ("Lus", 5);
        student3.setRating(7);
        System.out.println("Average rating of all students is " + getAverageRating());
        student2.changeRating(2);
        System.out.println("Average rating of all students is " + getAverageRating());
        System.out.println(student3.betterStudent(student2));
        System.out.println(student1.toString());
        removeStudent(student3);
        System.out.println(student3.toString());
    }

    public static void removeStudent(Student student) {
        Student.ratingSum = Student.ratingSum - student.rating;
        student.rating = 0;
        student.name = null;
        count--;

    }
}
