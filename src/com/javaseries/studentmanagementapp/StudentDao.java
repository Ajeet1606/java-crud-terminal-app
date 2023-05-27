package com.javaseries.studentmanagementapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student student){
        boolean flag = false;

        try{
//            jdbc code
//            create a connection to db
            Connection connection = ConnectionProvider.createConnection();
//            create query
            String query = "insert into students(sname, sphone, scity) values(?,?,?)";
//            prepare statement for query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            set the values of parameters
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentPhone());
            preparedStatement.setString(3, student.getStudentCity());

//            execute the query
            preparedStatement.execute();
            flag = true;
            connection.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public static boolean deleteStudentFromDB(int sid) {
        boolean flag = false;
        try{
            Connection connection = ConnectionProvider.createConnection();
            //create query
            String query = "delete from students where sid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sid);
            preparedStatement.execute();
            flag = true;
            connection.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  flag;
    }

    public static void showAllStudents() {
        try{
            Connection connection = ConnectionProvider.createConnection();
            String query = "select * from students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String city = resultSet.getString(4);

                System.out.println(
                        "StudentId='" + id + '\'' +
                        ", studentName='" + name + '\'' +
                        ", StudentCity='" + city + '\'' +
                        ", studentPhone='" + phone + '\''
                );
            }
            connection.close();
            statement.close();
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean getStudentInformation(int id) {
        boolean flag = false;

        try{
            Connection connection = ConnectionProvider.createConnection();
            String query = "select * from students where sid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String city = resultSet.getString(4);

                System.out.println("Student name:" + name + '\n' +
                        "Student phone:" + phone + '\n' +
                        "Student city:" + city);
            }
            flag = true;
            connection.close();
            preparedStatement.close();
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean updateStudent(Student student, int id) {
        boolean flag = false;

        try{
            Connection connection = ConnectionProvider.createConnection();
            String query = "update students SET sname=?, sphone=?, scity=? WHERE sid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentPhone());
            preparedStatement.setString(3, student.getStudentCity());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
