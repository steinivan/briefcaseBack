
package com.briefcase.briefcase.service;

import com.briefcase.briefcase.model.Language;
import com.briefcase.briefcase.model.LanguageDTO;
import com.briefcase.briefcase.model.Type;
import com.briefcase.briefcase.model.TypeDTO;
import com.briefcase.briefcase.repository.repoLanguage;
import com.briefcase.briefcase.repository.repoType;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BriefcaseServiceType implements IBriefcaseServiceType{
    @Autowired
    private repoLanguage RIdiom;
    @Autowired
    private repoType RType;
    
    @Override
    public void create(Type type){
        RType.save(type);
    }
    @Override
    public List<TypeDTO> selectAll(){
        List<Type> list = RType.findAll();
        return list.stream().map( element -> mappingDTO(element)).collect(Collectors.toList());
    }
    @Override
    public TypeDTO select(Long id){
        Type type = RType.findById(id).get();
        return mappingDTO(type);
    }
    @Override
    public TypeDTO edit(Type type,Long id){
        Type element = RType.findById(id).get();
        element.setId(id);
        element.setName(type.getName());
        return mappingDTO(element);
    }
    @Override
    public TypeDTO delete(Long id){
        Type type = RType.findById(id).get();
        RType.deleteById(id);
        return mappingDTO(type);
    }
    
    
    public TypeDTO mappingDTO(Type t){
        TypeDTO tDTO = new TypeDTO();
        tDTO.setId(t.getId());
        tDTO.setName(t.getName());
        tDTO.setListLanguage(t.getListLanguage());
        return tDTO;
    }
}
