package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.model.Lession;
import com.cms.languageclassmanagement.model.Period;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface PeriodService {
    void savePeriod(Date startdate,String second,int houer,int number, Date enddate, String teachername, Set<Lession> lessionSet, String language);
    void delPeriod(long id);
    Period findPeriodById(long id);

    List<Period> getAllPeriod();
}
