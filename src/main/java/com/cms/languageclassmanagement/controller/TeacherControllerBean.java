package com.cms.languageclassmanagement.controller;

import com.cms.languageclassmanagement.model.Teacher;
import com.cms.languageclassmanagement.service.TeacherService;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

//@ManagedBean
@Scope(value = "session")
/*@Component(value = "teacherController")
@ELBeanName(value = "teacherController")*/
@Named(value = "teacherController")
@Join(path = "/teacher", to = "/teacherhistory.jsf")
public class TeacherControllerBean {

    @Autowired
    private TeacherService teacherService;
    private Teacher teacher;
    public Teacher getTeacher() {
        return teacher;
    }

    public String teacherpage() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String teachername = request.getParameter("teachername");
        System.out.println("Teacher name:"+teachername);
        Teacher teacher= teacherService.findTeacherByName(teachername);
        this.teacher=teacher;
        return"/teacherhistory.xhtml?faces-redirect=true";
    }
}
