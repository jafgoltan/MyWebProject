package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Language;
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
public class LanguageDaoImpl implements LanguageDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Language> getAllLanguage() {
        final Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Language");
        return query.list();
    }
    @Override
    public Language findLanguageByName(String name) {
        final Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Language where langname=:name");
        query.setParameter("name",name);
        return (Language) query.list().get(0);
    }

    @Override
    public void saveLanguage(Language language) {

        Session se=  sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx=    se.beginTransaction();

            se.save(language);


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
