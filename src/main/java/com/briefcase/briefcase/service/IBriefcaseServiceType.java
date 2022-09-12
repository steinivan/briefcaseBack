
package com.briefcase.briefcase.service;

import com.briefcase.briefcase.model.Type;
import com.briefcase.briefcase.model.TypeDTO;
import java.util.List;


public interface IBriefcaseServiceType {
    public void create(Type type);
    public List<TypeDTO> selectAll();
    public TypeDTO select(Long id);
    public TypeDTO delete(Long id);
    public TypeDTO edit(Type type,Long id);
}
