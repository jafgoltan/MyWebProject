package com.cms.languageclassmanagement.dao;

import com.cms.languageclassmanagement.model.Language;

import java.util.List;

public interface LanguageDao {
    List<Language> getAllLanguage();
     Language findLanguageByName(String name);
     void saveLanguage(Language language);
}
