package com.example.case_study_jsp.reponsitory;

import java.sql.*;

public class DBConnection {


    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345678";
    private static final String HOST = "localhost";
    private static final String DATABASE = "furama";
    private static final String PORT = "3306";

    private static Connection connection;

//    public static boolean checkLogin(String username, String password) {
//        boolean isValid = false;
//        try {
//            String sql = "select*from user where username = ? and password = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,username);
//            preparedStatement.setString(2,password);
//            ResultSet rs = preparedStatement.executeQuery();
//            if(rs.next()){
//                isValid = true;
//            }else {
//                isValid = false;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return isValid;
//    }



    public static Connection getConnection () {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //nap driver
            connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

    public static void close(){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
