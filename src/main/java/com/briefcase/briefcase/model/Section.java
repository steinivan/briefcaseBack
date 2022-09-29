
package com.briefcase.briefcase.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="sections")
public class Section {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany (mappedBy = "section",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<imageSection> listImage;
}
