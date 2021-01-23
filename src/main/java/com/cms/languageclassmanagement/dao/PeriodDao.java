package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Period;

import java.util.List;

public interface PeriodDao {
     void savePeriod(Period pr);
     void delPeriod(Period pr);
     Period findPeriodById(Long pr);
     List<Period> getAllPeriod();

}
