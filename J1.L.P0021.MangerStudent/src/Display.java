
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
class Display {

    public void menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("   (Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }

    public void showInformationStudentCourse(ArrayList<Student> ls) {
        System.out.printf("%-10s|%-10s|%-15s|%-15s|%-15s\n", "Index", "Id", "Student name", "Semester", "Course name");
        //Loop to traversal student to show information
        int index = 1;
        for (Student student : ls) {
            System.out.printf("%-10d|%-10s|%-15s|%-15s|%-15s\n", index, student.getStudentId(), student.getStudentName(),
                     student.getSemester(), student.getCourseName());
            index++;

        }
    }

    public void showReport(ArrayList<Course> courseList){
        for (Course course : courseList) {
            System.out.printf("%-13s| %-4s | %-15d\n",course.getStudent().getStudentName(),course.getStudent().getCourseName(),course.getTotalCourse());
        }
            
    }

}
