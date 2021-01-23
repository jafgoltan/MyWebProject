/*
package com.cms.languageclassmanagement.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@Scope(value = "request")
@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/index.jsf")
public class UserControllerBean {
    public void reserve(){
    //    periods.clear();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String action = request.getParameter("id");
        //periodDao.delPeriod(Long.valueOf(action));
    }

}
*/
