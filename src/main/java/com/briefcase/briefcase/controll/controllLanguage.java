
package com.briefcase.briefcase.controll;

import com.briefcase.briefcase.model.Language;
import com.briefcase.briefcase.model.LanguageDTO;
import com.briefcase.briefcase.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.briefcase.briefcase.service.IBriefcaseServiceLanguage;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/language")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllLanguage {
    @Autowired
    private IBriefcaseServiceLanguage service;
    
    @GetMapping
    public List<LanguageDTO> view(){
    return service.view();
    }
    @GetMapping("/{id}")
    public LanguageDTO viewSelect(@PathVariable Long id){
        return service.viewSelect(id);
    }
    @PostMapping("/create/{languageId}")
    public LanguageDTO create(@RequestBody Language idiom,@PathVariable Long languageId){
        System.out.println(idiom);
        return service.create(idiom,languageId);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
    @PutMapping("/edit/{id}")
    public LanguageDTO edit(@RequestBody Language idiom,@PathVariable Long id){
        LanguageDTO dto = service.edit(idiom, id);
        return dto;
    }
    
}
