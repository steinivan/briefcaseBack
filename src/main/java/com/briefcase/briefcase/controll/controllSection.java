
package com.briefcase.briefcase.controll;

import com.briefcase.briefcase.model.FileModel;
import com.briefcase.briefcase.model.Language;
import com.briefcase.briefcase.model.LanguageDTO;
import com.briefcase.briefcase.model.Section;
import com.briefcase.briefcase.model.imageSection;
import com.briefcase.briefcase.service.section.IBriefcaseServiceImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.briefcase.briefcase.service.section.IBriefcaseServiceSection;
import org.springframework.http.HttpStatus;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllSection {
    @Autowired
    private IBriefcaseServiceImage serviceImg;
//    @Autowired
//    private IBriefcaseServiceSection service;

    @PostMapping("/image/upload")
    public void createImage(@RequestParam("file") MultipartFile multiPartFile,@RequestParam("section") String section){
        Gson gson = new Gson();
        Section sectionName = gson.fromJson(section, Section.class);
        Path directoryImage = Paths.get("src//main//resources//static/image/" + sectionName.getName());
        String absolutePath = directoryImage.toFile().getAbsolutePath();
//        byte[] byteImg;
//        try {
//            byteImg = multiPartFile.getBytes();
//            Path completePath = Paths.get(absolutePath + "//" + multiPartFile.getOriginalFilename());
//            String nameFileBD = 
        serviceImg.create(sectionName,multiPartFile);
//            Path deletePath = Paths.get(absolutePath + "//" + nameFileBD);
//            cleanImages(deletePath);
//            Files.write(completePath, byteImg);
//        } catch (IOException ex) {
//            System.out.println("fail");
//            Logger.getLogger(controllSection.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    @GetMapping("/image/find/{section}")
    public ResponseEntity<Resource> findImage(@PathVariable String section) throws IOException{
        Resource img = serviceImg.findImage(section);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + img.getFilename() + "\"").body(img);
    }
    @GetMapping("/image/find")
    public ResponseEntity<List<FileModel>> getFiles(){
        List<FileModel> fileInfos = serviceImg.loadAll().map(path -> {
          String filename = path.getFileName().toString();
          String url = MvcUriComponentsBuilder.fromMethodName(controllSection.class, "getFile",
                  path.getFileName().toString()).build().toString();
          return new FileModel(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = serviceImg.findImage(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+file.getFilename() + "\"").body(file);
    }

    public void cleanImages(Path completePath){
        try {
        Files.delete(completePath);
        } catch (Exception e) {
            System.out.println("fail delete path");
            Logger.getLogger(controllSection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
}
