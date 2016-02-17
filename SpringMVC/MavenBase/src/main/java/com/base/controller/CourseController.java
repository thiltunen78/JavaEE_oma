/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.base.controller;

import com.base.DAO.CourseDAO;
import com.base.models.Course;
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
public class CourseController 
{
    @RequestMapping(value="/admin/course", method=RequestMethod.GET)
    public String renderCourse(ModelMap map)
    {
        map.addAttribute("isLogged",true);
        map.addAttribute("course_active","active");
        map.addAttribute("course",new Course());
        
        try
        {
            map.addAttribute("courses",CourseDAO.getCourses());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return "course";
    }
    
    @RequestMapping(value="/admin/addcourse", method=RequestMethod.POST)
    public String addNewCourse(@ModelAttribute("course") Course cour, ModelMap map)
    {
        map.addAttribute("isLogged",true);
        map.addAttribute("course_active","active");
        
        try
        {
            CourseDAO.addCourse(cour);
            map.addAttribute("save_info","Course added succesfully!");
            map.addAttribute("courses",CourseDAO.getCourses());
        }
        catch(Exception e)
        {
            map.addAttribute("save_info","Database error!");
            e.printStackTrace();
        }
        return "course";
    }    
}
