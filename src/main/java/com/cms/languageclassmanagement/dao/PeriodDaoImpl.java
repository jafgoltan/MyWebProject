package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Period;
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
public class PeriodDaoImpl implements PeriodDao {
    @Autowired
   private SessionFactory sessionFactory;
    @Override
    public void savePeriod(Period pr) {
        Session se=  sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=    se.beginTransaction();

                se.save(pr);


            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            se.close();
        }


    }

    @Override
    public void delPeriod(Period pr) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("delete Period where id=:myid");
        Transaction tx=null;
        tx = session.beginTransaction();
        System.out.println(pr.getId());
        query.setParameter("myid", pr.getId());
        query.executeUpdate();

        tx.commit();
session.close();

    }

    @Override
    public Period findPeriodById(Long pr) {

        Session session = sessionFactory.openSession();
        Transaction tx=null;
        List<Period> li=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Period where id=:myid");
            query.setParameter("myid",pr);
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
        return li.get(0);
    }


    @Override
    public List<Period> getAllPeriod() {

         Session session = sessionFactory.openSession();
        Transaction tx=null;
        List<Period> li=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Period");
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
