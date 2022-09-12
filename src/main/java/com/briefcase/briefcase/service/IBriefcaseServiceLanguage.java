
package com.briefcase.briefcase.service;

import com.briefcase.briefcase.model.Language;
import com.briefcase.briefcase.model.LanguageDTO;
import java.util.List;


public interface IBriefcaseServiceLanguage {
    public List<LanguageDTO> view();
    public LanguageDTO viewSelect(Long id);
    public LanguageDTO create(Language idiom,Long languageId);
    public LanguageDTO edit(Language idiom,Long id);
    public void delete(Long id);
}
