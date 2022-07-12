
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
class InputData {
    
    private String inputString(String msg){
        Scanner sc = new Scanner(System.in);
        String result = "";
        //Loop to get valid string (string must be not empty)
        while(true){
            System.out.println(msg);
            result = sc.nextLine().trim();
            //Check user input empty string
            if(result.length() == 0){
                System.out.println("Input can be not empty. Please input again");
                continue;
            }
            //stop the loop
            break;
        }
        return result;
    }
    
    public int getChoice(String msg, int start, int end) {
        double choice = 0;
        //Loop to get valid choice 
        while(true){
            try{
            choice = Double.parseDouble(inputString(msg));
            //Check if choice is not integer
            if((int)choice != choice){
                System.out.println("Choice can be not real number. Please input positive integer!");
                continue;
            }
            //Check if choice out of range
            if(choice < start || choice > end){
                System.out.println("Choice must be positive integer from "+start+" to "+end+" .Please input again!");
                continue;
            }
            break;
            //Catch case input is not number
            }catch(NumberFormatException e){
                System.out.println("Choice can be not string. Please input number");
            }
        }
        return (int)choice;
    }
    
    public String getStudentName(String msg){
        return inputString(msg);
    }
    
    public String getSemester(String msg){
        return inputString(msg);
    }
    
    public String getId(String msg){
        return inputString(msg);
    }
    
    public String getCourseName(String msg){
        String course = "";
        while(true){
            course = inputString(msg);
            //Check valid course 
            if(checkValidCourse(course)){
                break;
            }
            System.out.println("Course must be in list (Java,.Net,C/C++)");
        }
        return course;
    }
    public String inputYesNo(String msg){
        //Loop to get valid answer
        while(true){
            String answer = inputString(msg);
            //check input must be Y or N
            if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")){
                return answer;
            }else{
                System.out.println("Input must be Y or N");
            }
        }
    }
    private boolean checkValidCourse(String course){
        //Check course must be in list course (Java , .Net , C/C++)
        if(course.equals("Java") || course.equals(".Net") || course.equals("C/C++")){
            return true;
        }
        return false;
    }
    public String getUpdateDeleteAnswer(String msg){
        //Loop to get valid answer( U or D)
        while(true){
            String answer  = inputString(msg);
            //Check valid answer
            if(checkValidUDAnswer(answer)){
                return answer;
            }
        }
    }
    private boolean checkValidUDAnswer(String answer){
        //Check answer must be U or D
        if(answer.equals("U") || answer.equals("D")){
            return true;
        }
        return false;
    }
}
