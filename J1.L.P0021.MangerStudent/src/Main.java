
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
public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        InputData input = new InputData();
        ManageStudent manageStudent = new ManageStudent();
        //Step 1 : Create list of student
        ArrayList<Student> studentList = new ArrayList<>();
        //studentList.add(new Student("101", "Nguyen Van A", "Spring", "Java"));
        studentList.add(new Student("102", "Nguyen Van B", "Spring", ".Net"));
        //studentList.add(new Student("103", "Nguyen Van C", "Spring", "C/C++"));
        studentList.add(new Student("101", "Nguyen Van A", "Summer", ".Net"));
        studentList.add(new Student("102", "Nguyen Van B", "Spring", "Java"));

        while (true) {
            //Step 2 : Display menu
            display.menu();
            //Step 3 : User enter choice
            int choice = input.getChoice("Please input your choice (1-5): ",1,5);
            //Step 4 : Do task of user choice
            switch (choice) {
                //Create student
                case 1:
                    manageStudent.createStudent(studentList);
                    break;

                //Find student by name in list and sort by name list student    
                case 2:
                    manageStudent.findAndSortByName(studentList);
                    break;

                //Update student or delete student in list
                case 3:
                    manageStudent.updateOrDeleteStudent(studentList);
                    break;

                //Display report of student with total Courses of this student
                case 4:
                    manageStudent.reportStudentWithCourse(studentList);
                    break;

                //Exit program
                case 5:
                    System.exit(0);
                    break;
            }

        }
    }
}
