package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveRole(Role role) {
        Session se=  sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=    se.beginTransaction();

            se.save(role);


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
}
