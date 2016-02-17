/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.controller;

import com.base.DAO.StudentDAO;
import com.base.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tero
 */
@Controller
public class StudentController 
{
    @RequestMapping(value="/admin/student", method=RequestMethod.GET)
    public String renderStudent(ModelMap map)
    {
        return "student";
    }
    
    @RequestMapping(value="/admin/addstudent", method=RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("student") Student stud, ModelMap map)
    {
        map.addAttribute("isLogged",true);
        
        try
        {
            StudentDAO.addStudent(stud);
            map.addAttribute("save_info","Student added succesfully!");
            map.addAttribute("students",StudentDAO.getStudents());
        }
        catch(Exception e)
        {
            map.addAttribute("save_info","Database error!");
            e.printStackTrace();
        }
        return "student";
    }
}
