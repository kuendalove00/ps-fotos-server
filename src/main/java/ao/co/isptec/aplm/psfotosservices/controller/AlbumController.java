/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.co.isptec.aplm.psfotosservices.controller;

import ao.co.isptec.aplm.psfotosservices.model.Album;
import ao.co.isptec.aplm.psfotosservices.service.AlbumService;

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
@RequestMapping(path = "/albums")
public class AlbumController {
    @Autowired
    private AlbumService service;
    
    @GetMapping("")
    public List<Album> getAllAlbums(){
        return service.getAllAlbums();
    }
    
    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable Integer id){
        return service.getSingleAlbum(id);
    }
    
    @PostMapping("")
    public String createAlbum(@RequestBody Album album){
        service.createAlbum(album);
        return "New student is added";
    }
    
    @PutMapping("/{id}")
    public Album updateAlbum(@RequestBody Album album, @PathVariable Integer id)
    {
        return service.updateAlbum(album, id);
    }
    
    @DeleteMapping("/{id}")
    public String deleteAlbum(@PathVariable Integer id)
    {
        service.destroyAlbum(id);
        return "O usuário com o id "+id+" foi excluído";
    }
}
