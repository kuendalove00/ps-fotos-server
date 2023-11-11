/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.co.isptec.aplm.psfotosservices.controller;

import ao.co.isptec.aplm.psfotosservices.model.Photo;
import ao.co.isptec.aplm.psfotosservices.service.PhotoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/photos")
public class PhotoController {
    @Autowired
    private PhotoService service;
    
    @GetMapping("")
    public List<Photo> getAllPhotos(){
        return service.getAllPhotos();
    }
    
    @GetMapping("/{id}")
    public Photo getPhoto(@PathVariable Integer id){
        return service.getSinglePhoto(id);
    }
    
    @PostMapping("")
    public String createPhoto(@RequestBody Photo photo){
        service.addPhoto(photo);
        return "uma nova foto foi adicionada ao álbum";
    }
    
    @PutMapping("/{id}")
    public Photo updatePhoto(@RequestBody Photo photo, @PathVariable Integer id)
    {
        return service.updatePhoto(photo, id);
    }
    
    @DeleteMapping("/{id}")
    public String deletePhoto(@PathVariable Integer id)
    {
        service.destroyPhoto(id);
        return "A foto "+id+" foi excluída";
    }
}
