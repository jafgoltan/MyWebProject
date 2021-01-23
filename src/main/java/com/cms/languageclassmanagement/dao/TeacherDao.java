package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Teacher;
import com.cms.languageclassmanagement.model.User;

import java.util.List;

public interface TeacherDao {
    public void saveTeacher(Teacher teacher);
    public Teacher findTeacherByName(String teachername);
    public List<Teacher> getAllTeacher();

}
