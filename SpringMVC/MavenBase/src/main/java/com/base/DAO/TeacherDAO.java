/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Teacher;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class is for making CRUD operations to teacher table in our database
 * 
 * @author Tero
 */
public class TeacherDAO 
{
    /**
    * This method adds new teacher into database
    * @param teach
    * @throws java.lang.Exception
    **/
    public static void addTeacher(Teacher teach) throws Exception
    {
        //create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();        
        //because we are writing to database we need transaction besides session
        Transaction transaction = session.beginTransaction();
        
        System.out.println("save teacher info to db");
                
        //add teacher to database
        session.save(teach);
        
        //end transaction
        transaction.commit();
        //release session
        session.close();
    }
    
    public static List<Teacher> getTeachers() throws Exception
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        //use hql(hibernate query language) language here, not sql!!!
        Query query = session.createQuery("from Teacher");
        //make the query to database
        List<Teacher> lst = query.list();
        
        session.close();
        
        //return list of teachers
        return lst;
    }
}
