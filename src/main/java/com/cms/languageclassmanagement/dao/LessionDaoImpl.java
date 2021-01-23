package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Lession;
import com.cms.languageclassmanagement.model.Teacher;
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
public class LessionDaoImpl implements LessionDao {
    @Autowired
    private SessionFactory sessionFactory;
  /*  @Override
    public Lession findLessionByName(String lname) {
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        List<Lession> li=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Lession where lession_subject=:name");
            query.setParameter("name",lname);

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
        }    }*/
}
