
package com.briefcase.briefcase.model;

import lombok.Data;

@Data
public class LanguageDTO {
    private Long id;
    private String name;
    private String type;

    public LanguageDTO() {
    }
}
