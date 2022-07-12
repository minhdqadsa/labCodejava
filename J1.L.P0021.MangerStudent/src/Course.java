/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class Course {
    private Student student;
    private int totalCourse;

    public Course() {
    }

    public Course(Student student, int totalCourse) {
        this.student = student;
        this.totalCourse = totalCourse;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
    
    
    
    
}
