/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Student;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tero
 */
public class StudentDAO 
{
    public static void addStudent(Student stud) throws Exception
    {
        //create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();        
        //because we are writing to database we need transaction besides session
        Transaction transaction = session.beginTransaction();
        
        System.out.println("save student info to db");
                
        //add student to database
        session.save(stud);
        
        //end transaction
        transaction.commit();
        //release session
        session.close();
    }
    
    public static List<Student> getStudents() throws Exception
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        //use hql(hibernate query language) language here, not sql!!!
        Query query = session.createQuery("from Student");
        //make the query to database
        List<Student> lst = query.list();
        
        session.close();
        
        //return list of students
        return lst;
    }
    
}
