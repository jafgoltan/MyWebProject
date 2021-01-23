package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.dao.TeacherDaoImpl;
import com.cms.languageclassmanagement.model.Period;
import com.cms.languageclassmanagement.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service

public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDaoImpl teacherDao;
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public void saveTeacher(String teachername,String phonenumber, String educationlevel,String language ,int age) {
        Teacher teacher = new Teacher();
        teacher.setTeachrname(teachername);
        teacher.setLanguage(language);
        teacher.setPhonenumber(phonenumber);
        teacher.setEducationlevel(educationlevel);
        teacher.setAge(age);
teacherDao.saveTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByName(String teachername) {
        return teacherDao.findTeacherByName(teachername);
    }

    @Override
    public void setPeriodforTeacher(long teacherid, Set<Period> periodSet) {


    }
}
