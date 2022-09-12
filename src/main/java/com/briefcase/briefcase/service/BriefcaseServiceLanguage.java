
package com.briefcase.briefcase.service;

import com.briefcase.briefcase.exceptions.ResourceNotFoundException;
import com.briefcase.briefcase.model.Language;
import com.briefcase.briefcase.model.LanguageDTO;
import com.briefcase.briefcase.repository.repoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briefcase.briefcase.repository.repoLanguage;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BriefcaseServiceLanguage implements IBriefcaseServiceLanguage {
    @Autowired
    private repoLanguage RIdiom;
    @Autowired
    private repoType RType;
    
    
    @Override
    public List<LanguageDTO> view(){
        List<Language> list = RIdiom.findAll();
        return list.stream().map(element->mappingDTO(element)).collect(Collectors.toList());
    }
    
    @Override
    public LanguageDTO viewSelect(Long id){
        Language language = RIdiom.findById(id).orElseThrow(()-> new ResourceNotFoundException("lenguaje de programacion","id",id));
        return mappingDTO(language);
    }
    
    @Override
    public LanguageDTO create(Language idiom, Long typeId){
        idiom.setType(RType.findById(typeId).get());
        RIdiom.save(idiom);
        return mappingDTO(idiom);
    }
    
    @Override
    public void delete(Long id){
        RIdiom.deleteById(id);
    }
    @Override
    public LanguageDTO edit(Language idiom,Long id){
        Language element = RIdiom.findById(id).get();
        element.setName(idiom.getName());
        RIdiom.save(element);
        return mappingDTO(element);
    }
    
    public LanguageDTO mappingDTO(Language i){
        LanguageDTO iDTO = new LanguageDTO();
        iDTO.setId(i.getId());
        iDTO.setName(i.getName());
        iDTO.setType(i.getType().getName());
        return iDTO;
    }
}
