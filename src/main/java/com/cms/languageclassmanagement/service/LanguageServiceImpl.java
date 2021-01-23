package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.dao.LanguageDao;
import com.cms.languageclassmanagement.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageDao languageDao;
    @Override
    public List<Language> getAllLanguage() {
        return languageDao.getAllLanguage();
    }

    @Override
    public void saveLanguage(Language language) {
        languageDao.saveLanguage(language);

    }
}
