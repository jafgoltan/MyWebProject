package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.dao.LanguageDao;
import com.cms.languageclassmanagement.dao.LessionDao;
import com.cms.languageclassmanagement.dao.PeriodDao;
import com.cms.languageclassmanagement.dao.TeacherDao;
import com.cms.languageclassmanagement.model.Lession;
import com.cms.languageclassmanagement.model.Period;
import com.cms.languageclassmanagement.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service

public class PeriodServiceImpl implements PeriodService{
     @Autowired
     private PeriodDao periodDao;
     @Autowired
     private LanguageDao langDao;
     @Autowired
     private TeacherService teacherDao;
   /*  @Autowired
     private LessionDao lessionDao;*/
     @Override
     public void savePeriod(Date startdate, String second, int houer,int number, Date enddate, String teachername, Set<Lession> lessionSet, String language) {
       if(lessionSet !=null || lessionSet.size() !=0) {
           Period period = new Period();
           Teacher teacher1 = teacherDao.findTeacherByName(teachername);
           if (teacher1 != null) {

               period.setTeacher(teacher1);
           } else {
    /*        Teacher teacher = new Teacher();
            teacher.setTeachrname(teachername);
            period.setTeacher(teacher);*/
           }


           period.setEnddate(enddate);
           period.setStartdate(startdate);
           period.setLanguage(langDao.findLanguageByName(language));
           period.setMaxstudent(number);

           period.setSeconddayinweek(second);
           period.setHour(houer);
           Set<Lession> lessionSet1 = new HashSet<>();
           for (Lession lession : lessionSet) {
               // Lession lession1=  lessionDao.findLessionByName(lession.getSubject());
               System.out.println("parsa:" + lession.getSubject());

               lession.setPeriod(period);
               lessionSet1.add(lession);

           }
           period.setLession(lessionSet1);

           periodDao.savePeriod(period);
       }
     }



    @Override
    public void delPeriod(long id) {
        Period period = new Period();
period.setId(id);

        periodDao.delPeriod(period);
    }

    @Override
    public Period findPeriodById(long id) {
        return periodDao.findPeriodById(id);
    }

    @Override
     public List<Period> getAllPeriod() {

   return periodDao.getAllPeriod();
     }
}
