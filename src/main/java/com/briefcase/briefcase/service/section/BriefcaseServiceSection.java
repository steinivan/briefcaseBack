
package com.briefcase.briefcase.service.section;

import com.briefcase.briefcase.model.Section;
import com.briefcase.briefcase.model.Type;
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
//    @Override
//    public List<TypeDTO> selectAll(){
//        List<Type> list = RType.findAll();
//        return list.stream().map( element -> mappingDTO(element)).collect(Collectors.toList());
//    }
//    @Override
//    public TypeDTO select(Long id){
//        Type type = RType.findById(id).get();
//        return mappingDTO(type);
//    }
//    @Override
//    public TypeDTO edit(Type type,Long id){
//        Type element = RType.findById(id).get();
//        element.setId(id);
//        element.setName(type.getName());
//        return mappingDTO(element);
//    }
//    @Override
//    public TypeDTO delete(Long id){
//        Type type = RType.findById(id).get();
//        RType.deleteById(id);
//        return mappingDTO(type);
//    }
//    
//    
//    public TypeDTO mappingDTO(Type t){
//        TypeDTO tDTO = new TypeDTO();
//        tDTO.setId(t.getId());
//        tDTO.setName(t.getName());
//        tDTO.setListLanguage(t.getListLanguage());
//        return tDTO;
//    }
}
