package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.model.Period;
import com.cms.languageclassmanagement.model.Teacher;

import java.util.List;
import java.util.Set;

public interface TeacherService {
     List<Teacher> getAllTeacher();
     void saveTeacher(String teachername,String phonenumber, String educationlevel,String language ,int age);
    Teacher findTeacherByName(String teachername);
    void setPeriodforTeacher(long teacherid, Set<Period> periodSet);

}
