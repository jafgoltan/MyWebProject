package com.cms.languageclassmanagement.service;



import com.cms.languageclassmanagement.dao.UserDao;
import com.cms.languageclassmanagement.model.Role;
import com.cms.languageclassmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service

public class UserServiceImpl implements UserService {



   private UserDao userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findUserByUsername(userName.toLowerCase());
    }



    @Override
    public void saveUser(String username, String fullname, Long phonenumber, String password) {
        User user = new User();

        user.setPassword(bCryptPasswordEncoder.encode(password));
user.setFullname(fullname);
user.setPhonenumber(phonenumber);
        user.setUsername(username.toLowerCase());
        Set<Role> ms = new HashSet<>();
        Role r = new Role();
        r.setId(1);
        r.setName("ROLE_USER");

        ms.add(r);
        user.setRoles(ms);
        saveUser(user);

    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);


    }


}
