package com.javaseries;

import com.javaseries.studentmanagementapp.Student;
import com.javaseries.studentmanagementapp.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("Welcome to Student Management App");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("""
                    Enter:\s
                    1: To Create a new Student\s
                    2: To Delete a Student\s
                    3: To Display a Student Information\s
                    4. To see all students present in database\s
                    5. To update your information\s
                    6. To Exit App""");

            int choice = Integer.parseInt(br.readLine());

            if (choice == 1){
//                Add student
                System.out.println("Enter Student Name");
                String name = br.readLine();

                System.out.println("Enter Student City");
                String city = br.readLine();

                System.out.println("Enter Student Phone");
                String phone = br.readLine();

                Student student = new Student(name, city, phone);
                boolean ans = StudentDao.insertStudentToDB(student);
                if (ans){
                    System.out.println("Student Added Successfully");
                }else {
                    System.out.println("Something went wrong");
                }
                System.out.println(student);
            }else if (choice == 2){
//                delete student
                System.out.println("Enter your id:");
                int sid = Integer.parseInt(br.readLine());
                boolean ans = StudentDao.deleteStudentFromDB(sid);
                if (ans){
                    System.out.println("Student Deleted");
                }else{
                    System.out.println("Something went wrong");
                }
            }else if (choice == 3){
                System.out.println("Enter the Student id:");
                int id = Integer.parseInt(br.readLine());
                boolean ans = StudentDao.getStudentInformation(id);
                if (ans){
                    System.out.println("Operation Successful");
                }else{
                    System.out.println("Something Went Wrong");
                }
            }else if (choice == 4){
                System.out.println("Here are the details of all students");
                StudentDao.showAllStudents();
            }else if (choice == 5){
                System.out.println("Enter your id:");
                int id = Integer.parseInt(br.readLine());
                System.out.println("Your details are: \n");
                boolean ans = StudentDao.getStudentInformation(id);
                if (ans){
                    System.out.println("Let's update it: \n");
                    System.out.println("Enter Your Name");
                    String name = br.readLine();

                    System.out.println("Enter Your City");
                    String city = br.readLine();

                    System.out.println("Enter Your Phone");
                    String phone = br.readLine();

                    Student student = new Student(name, city, phone);
                    boolean flag = StudentDao.updateStudent(student, id);
                    if (flag){
                        System.out.println("Updated...");
                    }else{
                        System.out.println("Something Went Wrong");
                    }
                }else{
                    System.out.println("We couldn't find your id.");
                }
            }
            else if (choice == 6){
//                exit
                break;
            }
        }

        System.out.println("Thank you for using our application, hope you liked it");
    }
}
