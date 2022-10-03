
package com.briefcase.briefcase.service.section;

import com.briefcase.briefcase.model.Section;
import com.briefcase.briefcase.model.imageSection;
import com.briefcase.briefcase.repository.repoImage;
import org.springframework.beans.factory.annotation.Autowired;
import com.briefcase.briefcase.repository.repoSection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.util.stream.Stream;
import org.springframework.util.FileSystemUtils;
@Service
public class BriefcaseServiceImage implements IBriefcaseServiceImage {
    @Autowired
    private repoImage repositoryImage;
    @Autowired
    private repoSection repository;
    private final Path root = Paths.get("image");
    
    @Override
    public void init() {
        try {
            Files.createDirectory(root);
            
        } catch (IOException e) {
            throw new RuntimeException("No se puede inicializar la carpeta image");
        }
    }
     @Override
    public void deleteAll() {
         FileSystemUtils.deleteRecursively(root.toFile());
    }
    @Override
    public String deleteFile(String filename){
        try {
            Boolean delete = Files.deleteIfExists(this.root.resolve(filename));
                return "Borrado";
        }catch (IOException e){
            e.printStackTrace();
            return "Error Borrando ";
        }
    }
    @Override
    public String create(Section section,MultipartFile file){
        Section nameFile = findSection(section.getName());
        try {
            //copy (que queremos copiar, a donde queremos copiar)
            Files.copy(file.getInputStream(), 
                       root.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
        }
        imageSection newFile = new imageSection();
        newFile.setName(file.getOriginalFilename());
        newFile.setSection(nameFile);
        imageSection imageBefore = findImageBefore(nameFile);
        deleteFile(imageBefore.getName());
        repositoryImage.delete(imageBefore);
        repositoryImage.save(newFile);
        return imageBefore.getName();
    }
    @Override
    public Resource findImage(String section){
        try {
            Path file = root.resolve(section);
            Resource resource = new UrlResource(file.toUri());
            System.out.println(resource.getFilename());
            System.out.println(resource);
            System.out.println(resource.exists());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("No se puede leer el archivo ");
            }
        }catch (MalformedURLException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    @Override
    public Stream<Path> loadAll(){
        //Files.walk recorre nuestras carpetas (uploads) buscando los archivos
        // el 1 es la profundidad o nivel que queremos recorrer
        // :: Referencias a metodos
        // Relativize sirve para crear una ruta relativa entre la ruta dada y esta ruta
        try{
            return Files.walk(root,1).filter(path -> !path.equals(root))
                    .map(root::relativize);
        }catch (RuntimeException | IOException e){
            throw new RuntimeException("No se pueden cargar los archivos ");
        }
    }
    
    
    public Section findSection(String nameSection){
        List<Section> repo = repository.findAll();
        Section repositoryFilter = repo.stream().filter(x -> x.getName().equals(nameSection)).findFirst().get();
        return repositoryFilter;

    }
    public imageSection findImageBefore(Section section){
        List<imageSection> repo = repositoryImage.findAll();
        return repo.stream().filter(x -> x.getSection().equals(section)).findFirst().get();
    }
}
