
package com.briefcase.briefcase.service.section;

import com.briefcase.briefcase.model.Section;
import com.briefcase.briefcase.repository.repoImage;
import com.briefcase.briefcase.repository.repoSection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BriefcaseServiceSection implements IBriefcaseServiceSection{
    @Autowired
    private repoSection repository;
    @Autowired
    private repoImage repositoryImage;
    
    @Override
    public void create(Section section){
        
    }

}
