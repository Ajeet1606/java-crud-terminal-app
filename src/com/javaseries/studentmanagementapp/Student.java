package com.javaseries.studentmanagementapp;

public class Student {
    private String studentName;
    private String StudentId;
    private String StudentCity;
    private String studentPhone;

//    getters & setters

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getStudentCity() {
        return StudentCity;
    }

    public void setStudentCity(String studentCity) {
        StudentCity = studentCity;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    //    constructors
    public Student(String studentName, String studentId, String studentCity, String studentPhone) {
        super();
        this.studentName = studentName;
        StudentId = studentId;
        StudentCity = studentCity;
        this.studentPhone = studentPhone;
    }

    public Student(String studentName, String studentCity, String studentPhone) {
        super();
        this.studentName = studentName;
        StudentCity = studentCity;
        this.studentPhone = studentPhone;
    }

    public Student() {
        super();
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", StudentId='" + StudentId + '\'' +
                ", StudentCity='" + StudentCity + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                '}';
    }
}
