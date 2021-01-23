package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Period;
import com.cms.languageclassmanagement.model.Teacher;
import com.cms.languageclassmanagement.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveTeacher(Teacher teacher) {
        sessionFactory.openSession().save(teacher);

    }

    @Override
    public Teacher findTeacherByName(String teachername) {
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        List<Teacher> li=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Teacher where teachrname=:name");
            query.setParameter("name",teachername);

            li = query.list();
            tx.commit();

        } catch (HibernateException e) {
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        if(li.size()==0 || li==null) {
            return null;
        } else {
            return li.get(0);
        }
    }

    @Override
    public List<Teacher> getAllTeacher() {
       final Session session = sessionFactory.openSession();
        Transaction tx=null;
        List<Teacher> li=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Teacher");
            li = query.list();
            tx.commit();

        } catch (HibernateException e) {
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return li;
    }
}
