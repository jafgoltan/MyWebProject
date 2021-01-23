package com.cms.languageclassmanagement.controller;

import com.cms.languageclassmanagement.model.Language;
import com.cms.languageclassmanagement.model.Teacher;
import com.cms.languageclassmanagement.service.LanguageService;
import com.cms.languageclassmanagement.service.TeacherService;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@Named(value = "addTeacherController")
@Join(path = "/addteacher", to = "/teacher.jsf")
public class AddTeacherControllerBean {
    @Autowired
    private LanguageService languageService;
   // @Inject
    @Autowired
    private TeacherService teacherService;
    List<Teacher> teacherList = new ArrayList<>();
private String error;
    public List<Teacher> getTeacherList() {
        this.teacherList = teacherService.getAllTeacher();

        return teacherList;
    }

    private String teachrname;
    private int age;

    private String educationlevel;

    private String language;

    private String phonenumber;

    public String getTeachrname() {
        return teachrname;
    }

    public void setTeachrname(String teachrname) {
        this.teachrname = teachrname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
boolean ok=false;
        for (Language lang : languageService.getAllLanguage()) {
            if (lang.getLangname().equalsIgnoreCase(language)) {
ok=true;
                this.language = language;
            }
        } if(!ok) setError("Language Not found");
    }


    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void submit() {

        teacherService.saveTeacher(teachrname,phonenumber,educationlevel,language,age);
        this.teacherList =         teacherService.getAllTeacher();

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
