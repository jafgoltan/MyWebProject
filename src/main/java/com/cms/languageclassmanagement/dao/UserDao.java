
package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface UserDao {
    public void saveUser(User user);
    public User findUserByUsername(String user);
}

