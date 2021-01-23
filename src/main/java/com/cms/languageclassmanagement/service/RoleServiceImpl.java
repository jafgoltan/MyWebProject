package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.dao.RoleDao;
import com.cms.languageclassmanagement.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
@Autowired
private RoleDao roleRepository;


    @Override
    public void saveRole(Role role) {


        roleRepository.saveRole(role);


    }



}
