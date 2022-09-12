
package com.briefcase.briefcase.model;

import java.util.List;
import lombok.Data;

@Data
public class TypeDTO {
    private Long id;
    private String name;
    private List<Language> listLanguage;
}
