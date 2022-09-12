
package com.briefcase.briefcase.controll;

import com.briefcase.briefcase.model.Type;
import com.briefcase.briefcase.model.TypeDTO;
import com.briefcase.briefcase.service.IBriefcaseServiceType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class controllType {
    @Autowired
    private IBriefcaseServiceType service;
    @GetMapping
    public List<TypeDTO> selectAlll(){
    return service.selectAll();
    }
    @GetMapping("/{id}")
    public TypeDTO select(@PathVariable Long id){
        TypeDTO dto = service.select(id);
        return dto;
    }
    @PostMapping("/create")
    public void create(@RequestBody Type type){
        service.create(type);
    }
    @DeleteMapping("/delete/{id}")
    public TypeDTO delete(@PathVariable Long id){
        return service.delete(id);
    }
    @PutMapping("/edit/{id}")
    public TypeDTO edit(@RequestBody Type type,@PathVariable Long id){
        return service.edit(type, id);
    }
}
