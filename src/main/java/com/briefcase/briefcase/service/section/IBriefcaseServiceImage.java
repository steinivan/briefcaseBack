
package com.briefcase.briefcase.service.section;

import com.briefcase.briefcase.model.Language;
import com.briefcase.briefcase.model.LanguageDTO;
import com.briefcase.briefcase.model.Section;
import com.briefcase.briefcase.model.imageSection;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface IBriefcaseServiceImage {
//    public List<LanguageDTO> view();
    public void init();
    public void deleteAll();
    public String deleteFile(String filename);
    public String create(Section section,MultipartFile file );
    public Resource findImage(String section);
    public Stream<Path> loadAll();
//    public void delete(Long id);
}
