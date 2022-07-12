
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
class ManageStudent {

    //Create student
    public void createStudent(ArrayList<Student> studentList) {
        InputData input = new InputData();
        //Check size of list student to continue
        if (studentList.size() > 10) {
            if (input.inputYesNo("Do you want to continue (Y/N)?").equalsIgnoreCase("No")) {
                return;
            }
        }
        //Loop to input valid student
        while (true) {
            String id = input.getId("Please input student id: ");
            String name = "";
            //check valid id 
            if (checkIdExisted(studentList, id)) {
                System.out.println("Id existed , you don't need to provide name of student");
                name = getNameById(studentList, id);
            } else { //get name from user
                name = input.getStudentName("Please input student name: ");
            }

            String semester = input.getSemester("Please input semester: ");
            String course = input.getCourseName("Please input course in list(Java,.Net,C/C++)");
            //check existed student
            if (checkExistedStudent(studentList, id, course, semester)) {
                System.out.println("Student existed. Please input new student");
                continue;
            } else {//student not existed
                Student newStudent = new Student(id, name, semester, course);
                studentList.add(newStudent);
                System.out.println("Create student success");
                //Show list of student information after added sucess 
                Display display = new Display();
                display.showInformationStudentCourse(studentList);
                break;
            }
        }

    }

    private String getNameById(ArrayList<Student> ls, String id) {
        //loop to traversal student in list
        for (Student st : ls) {
            //Get name by id
            if (st.getStudentId().equals(id)) {
                return st.getStudentName();
            }

        }
        return null;
    }

    private boolean checkExistedStudent(ArrayList<Student> studentList, String id,
          String course, String semeter) {
        //loop to traversal list student
        for (Student student : studentList) {
            //check student existed
            if (student.getStudentId().equalsIgnoreCase(id)
                    && student.getCourseName().equalsIgnoreCase(course)
                    && student.getSemester().equalsIgnoreCase(semeter)
                    ) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIdExisted(ArrayList<Student> studentList, String id) {
        //Loop to check id student and student name
        for (Student student : studentList) {
            //Check id existed with other student name
            if (student.getStudentId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    //find and sort by name
    public void findAndSortByName(ArrayList<Student> studentList) {
        //Check list is empty
        if (studentList.size() == 0) {
            System.out.println("List of student is empty.Please creat new student");
            return;
        }
        InputData input = new InputData();
        String name = input.getStudentName("Please input name of part of name to find");
        //Find list student by name or past of name
        ArrayList<Student> foundStudentList = findListStudentByNameOrPartOfName(studentList, name);
        //check student can not found
        if (foundStudentList.isEmpty()) {
            System.out.println("Student is not exist!");
            return;
        }

        //Sort list foundstudent by name
        Comparator<Student> compareByName = new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                return t.getStudentName().compareTo(t1.getStudentName());
            }
        };
        Collections.sort(foundStudentList, compareByName);
        // Show list student was found and sorted by name
        Display display = new Display();
        display.showInformationStudentCourse(foundStudentList);
    }

    private ArrayList<Student> findListStudentByNameOrPartOfName(ArrayList<Student> ls, String name) {
        ArrayList<Student> foundStudent = new ArrayList<>();
        //Traversal list student to find
        for (Student student : ls) {
            //Check student had found
            if (student.getStudentName().contains(name)) {
                foundStudent.add(student);
            }
        }
        return foundStudent;
    }

    public void updateOrDeleteStudent(ArrayList<Student> studentList) {
        InputData input = new InputData();
        //Loop to get id existed in list student
        String idToFind = "";
        while (true) {
            idToFind = input.getId("Please input id to find or update: ");
            //Check to required user reinput
            if (!checkIdExisted(studentList, idToFind)) {
                System.out.println("Id is not existed.Please input again");

            } else {

                break;
            }
        }
        ArrayList<Student> foundByIdList = getListStudentById(studentList, idToFind);
        Display display = new Display();

        //Show list of student found by id for user can chose
        System.out.println("List of student found by id: ");
        display.showInformationStudentCourse(foundByIdList);
        //Check to get task after
        if (input.getUpdateDeleteAnswer("Do you want to update (U) or delete (D) student: ").equals("D")) {
            //delete student
            int choice = input.getChoice("Please input index of student you want to delete: ", 1, foundByIdList.size());
            Student studentDelete = foundByIdList.get(choice - 1);
            studentList.remove(studentDelete);
            //show message
            System.out.println("Delete success");
            System.out.println("List student information after delete");
            display.showInformationStudentCourse(studentList);
        } else {
            updateStudent(studentList,foundByIdList);
        }

    }

    private void updateStudent(ArrayList<Student> studentList,ArrayList<Student> foundByIdList) {
        InputData input = new InputData();
        Display display = new Display();
        int choice = input.getChoice("Please input index of student you want to update: ", 1, foundByIdList.size());
        Student studentUpdate = foundByIdList.get(choice - 1);

        //Loop to get information to update
        while (true) {
            String id = input.getId("Please input id to update");
            //Check id existed to require user provide name
            String name = input.getStudentName("Please input student name to update");
            String answerToUpdateNameSameId="";
            if (checkIdExistWithOtherName(studentList, id, name)) {
                System.out.println("Do you want to rename all student have id " + id + " or keep old name ?");
                answerToUpdateNameSameId = input.inputYesNo("Y to change ,N to keep old name");
                
            }

            String semester = input.getSemester("Please input semester to update: ");
            String course = input.getCourseName("Please input course to update: ");
            //Check information duplicate
            if (checkExistedStudent(studentList, id, course, semester)) {
                System.out.println("Student information is existed do you want to input new information to update ?");
                //Get answer to continue update when information existed
                if(input.inputYesNo("Enter Y to input new infor, N to stop update.").equals('N')){
                    break;
                }else{//User want to input again
                    continue;
                }
            }
                //Check to update name for all student
                if(answerToUpdateNameSameId.equals("Y")){
                    updateName(studentList, id, name);
                }else{//Not update new name
                    name = getNameById(studentList, id);
                }
                studentUpdate.setStudentId(id);
                studentUpdate.setStudentName(name);
                studentUpdate.setCourseName(course);
                studentUpdate.setSemester(semester);
                System.out.println("Update sucess.");
                System.out.println("List of student after updating");
                display.showInformationStudentCourse(studentList);
                break;
            
        }
    }

    private void updateName(ArrayList<Student> ls, String id, String newName) {
        for (Student l : ls) {
            if (l.getStudentId().equals(id)) {
                l.setStudentName(newName);
            }
        }
    }

    private boolean checkIdExistWithOtherName(ArrayList<Student> ls, String id, String name) {
        for (Student l : ls) {
            if (l.getStudentId().equals(id) && !l.getStudentName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Student> getListStudentById(ArrayList<Student> studentList, String id) {
        ArrayList<Student> foundById = new ArrayList<>();
        //Loop to traversal each student 
        for (Student student : studentList) {
            //Check to add foundlist student by id
            if (student.getStudentId().equalsIgnoreCase(id)) {
                foundById.add(student);
            }
        }
        return foundById;
    }

    public void reportStudentWithCourse(ArrayList<Student> studentList) {
        ArrayList<Course> myCourse = new ArrayList<>();
        for (Student st : studentList) {
            int total = caculateNumberCourse(studentList, st);
            Course newCourse = new Course(st, total);
            if(!checkCourseExisted(myCourse, newCourse)){
                myCourse.add(newCourse);
            }
            
        }
        
        Display ds = new Display();
        ds.showInformationStudentCourse(studentList);
        ds.showReport(myCourse);
    }
    public boolean checkCourseExisted(ArrayList<Course> courseList, Course checkCourse){
        for (Course course : courseList) {
            if(course.getStudent().getStudentId().equals(checkCourse.getStudent().getStudentId())
                    &&course.getStudent().getCourseName().equals(checkCourse.getStudent().getCourseName())){
                return true;
            }
        }
        return false;
    }
    public int caculateNumberCourse(ArrayList<Student> ls, Student studentCheck) {
        int total = 0;
        for (Student l : ls) {
            if (l.getStudentId().equals(studentCheck.getStudentId()) && l.getCourseName().equals(studentCheck.getCourseName())) {
                total++;
            }
        }
        return total;
    }
}
