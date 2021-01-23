package com.cms.languageclassmanagement.service;

import com.cms.languageclassmanagement.model.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAllLanguage();
    void saveLanguage(Language language);
}
