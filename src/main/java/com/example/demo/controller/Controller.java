package com.example.demo.controller;

import com.example.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.service.search;
import sun.util.resources.cldr.fr.CalendarData_fr_BJ;

@RestController
@RequiredArgsConstructor
public class Controller {
    public String dataBaseName;

    @RequestMapping("/search/condition")
    public List<Student> SearchByConditon(String SQLrequest,String dataBaseName){

        Student student = new Student();
        search search = new search();
        this.dataBaseName = dataBaseName;
//        search.setDataBaseName_Global(dataBaseName);
        List list = new ArrayList<>();
        try {
            list = student.SearchByConditon(SQLrequest);
            //list = search.SearchByConditon(SQLrequest,dataBaseName);
        } catch (Exception e){

            e.printStackTrace();
        }
        return list;
    }
    @RequestMapping("/search/searchAll")
    public List SearchAllByConditon(String SQLrequest,String dataBaseName){

        //Student student = new Student();
        search search = new search();
        this.dataBaseName = dataBaseName;
//        search.setDataBaseName_Global(dataBaseName);
        List list = new ArrayList<>();
        try {
            //list = student.SearchByConditon(SQLrequest);
            list = search.SearchByConditon(SQLrequest,dataBaseName);
        } catch (Exception e){

            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("/search/searchAll2")
    public Map<String, Object> SearchAllByConditon2(String SQLrequest, String dataBaseName){

        //Student student = new Student();
        search search = new search();
        this.dataBaseName = dataBaseName;
//        search.setDataBaseName_Global(dataBaseName);
        Map<String, Object> map = new HashMap<>();
        try {
            //list = student.SearchByConditon(SQLrequest);
            map = search.SearchByConditon2(SQLrequest);
        } catch (Exception e){

            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/search/dataBaseName")
    public String setDataBaseName(){
        return this.dataBaseName;
    }


    @RequestMapping("/search/TableName")
    public Map<String, Object> SearchTableName() throws SQLException, ClassNotFoundException {
        search search = new search();
        Map<String, Object> map = new HashMap<>();
        map = search.SearchTableName();
        return map;
    }

}
