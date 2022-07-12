
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
public class test {
    public static void main(String[] args) {
        Student student1 = new Student("1", "2", "3","4");
        Student student2 = new Student("1", "2", "3","4");
        Student student3 = new Student("2", "2", "3","5");
        Student student4 = new Student("5", "2", "3","4");
        ArrayList<Student> ls1 = new ArrayList<>();
        ls1.add(student1);
        ls1.add(student2);
        ls1.add(student3);
        ls1.add(student4);
        ArrayList<Student> ls2 = new ArrayList<>();
            for (Student student : ls1) {
                   if(student.getStudentId().equals("1")){
                            ls2.add(student);
                        }
                }
            ls2.get(1).setCourseName("aaaaa");
            Student stu = ls2.get(0);
        ls1.remove(stu);
        for (Student student : ls1) {
            System.out.println(student);
        }
    }
}
