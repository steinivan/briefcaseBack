
package com.briefcase.briefcase.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="types")

public class Type {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;
    
    @OneToMany (mappedBy = "type",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Language> listLanguage;
    public Type() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Language> getListLanguage() {
        return listLanguage;
    }

    public void setListLanguage(List<Language> listLanguage) {
        this.listLanguage = listLanguage;
    }

 
    
    
}
