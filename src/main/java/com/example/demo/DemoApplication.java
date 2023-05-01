package com.example.demo;

import com.example.demo.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        SpringApplication.run(DemoApplication.class, args);

        Map<String, Object> resultMap = new HashMap<>();
        ArrayList list = new ArrayList<>();
        //1.注册驱动、加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接
        String url = "jdbc:mysql://localhost:3306/sct";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);

        if (connection != null) {

            System.out.println("连接到数据库！");
        } else {

            System.out.println("连接失败！");
        }

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = databaseMetaData .getTables(connection.getCatalog(), null, "%", types);
        int id = 1;
        while(rs.next()){
            System.out.println("table name:" + rs.getString(3));
            resultMap.put("id:"+ id,rs.getString(3));
            id++;
        }
        System.out.println(resultMap);

        //test
//        Student student = new Student();
//        student.InsertStudent("20022021","贾梓萌","女",21,"237011");
//        ArrayList<Student> list = new ArrayList<>();
//        Student student = new Student();
//        list = student.SearchAll();
//        System.out.println(list);
//        Student student = new Student();
//        String string = "SELECT * FROM STUDENT WHERE Sname = \"贾梓萌\";";
//        student.SearchByConditon(string);


    }

}
