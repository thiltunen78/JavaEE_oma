/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Course;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tero
 */
public class CourseDAO 
{
    public static void addCourse(Course cour) throws Exception
    {
        //create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();        
        //because we are writing to database we need transaction besides session
        Transaction transaction = session.beginTransaction();
        
        System.out.println("save course info to db");
                
        //add course to database
        session.save(cour);
        
        //end transaction
        transaction.commit();
        //release session
        session.close();
    }
    
    public static List<Course> getCourses() throws Exception
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        //use hql(hibernate query language) language here, not sql!!!
        Query query = session.createQuery("from Course");
        //make the query to database
        List<Course> lst = query.list();
        
        session.close();
        
        //return list of courses
        return lst;
    }    
}
