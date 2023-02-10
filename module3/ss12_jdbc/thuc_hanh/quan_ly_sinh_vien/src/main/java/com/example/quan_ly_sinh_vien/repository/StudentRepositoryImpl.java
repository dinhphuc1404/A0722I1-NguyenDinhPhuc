package com.example.quan_ly_sinh_vien.repository;

import com.example.quan_ly_sinh_vien.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository{
    private static final String INSERT_USERS_SQL = "insert into student" + "  (ma_sinh_vien, ten_sinh_vien, tuoi) values " +
            " (?, ?, ?);";
    private static final String UPDATE_USERS_SQL = "update student set ten_sinh_vien= ?, tuoi =? where ma_sinh_vien = ?;";
    private static final String SELECT_USER_BY_ID = "select ma_sinh_vien,ten_sinh_vien,tuoi from users where ma_sinh_vien =?";

//        private static List<Student> studentList;
//    static {
//        studentList = new ArrayList<>();
//        studentList.add(new Student(1, "Nguyen Dinh Phuc", 23));
//        studentList.add(new Student(1, "Nguyen Dinh Phuc", 23));
//    }
    @Override
    public List<Student> findAll() {
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();
        if(connection != null){
            try {
                statement = connection.prepareStatement("select * from student");
                resultSet = statement.executeQuery();

                Student student =   null;
                while (resultSet.next()){
                    int id = resultSet.getInt("ma_sinh_vien");
                    String name = resultSet.getString("ten_sinh_vien");
                    int age = resultSet.getInt("tuoi");

                    student = new Student(id,name,age);
                    studentList.add(student);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = DBConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(3,student.getAge());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean edit(Student student) {
        boolean row = false;
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)){
            statement.setInt(1,student.getId());
            statement.setString(2,student.getName());
            statement.setInt(3,student.getAge());
            row = statement.executeUpdate()>0;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
       try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)){
            preparedStatement.setInt(1,id);
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()){
               String name = rs.getString("ten_sinh_vien");
               int age = rs.getInt("tuoi");
               student = new Student(id,name,age);
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
        return student;
    }
}
