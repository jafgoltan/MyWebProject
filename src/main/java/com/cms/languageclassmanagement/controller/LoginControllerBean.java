package com.cms.languageclassmanagement.controller;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;

@PreAuthorize("!isAuthenticated()")
//https://github.com/HiSpringMan/SpringBoot-Jsf-PrimeFaces-Hibernate/tree/master/src/main/webapp/user

@Controller
@Join(path = "/login", to = "/login.jsf")
public class LoginControllerBean {

}
