package com.cms.languageclassmanagement.dao;


import com.cms.languageclassmanagement.model.User;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveUser(User user) {
     Session se=  sessionFactory.openSession();
        Transaction tx=null;
        try {
        tx=    se.beginTransaction();
se.saveOrUpdate(user);
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
    public User findUserByUsername(String user) {
        final Session session = sessionFactory.openSession();

        Query query = session.createQuery("from User where username=:name ");
        query.setParameter("name", user.toLowerCase());
        User list =(User) query.list().get(0);
        session.close();
        return list!=null? list:null;

    }


}
