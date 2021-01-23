package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.model.Role;
import com.cms.languageclassmanagement.model.User;

public interface UserService {

     User findUserByUsername(String userName);

     void saveUser(String username, String fullname, Long phonenumber, String password);
     void saveUser(User user);
}
