/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.exception.NotFoundException;
import ao.co.isptec.aplm.psfotosservices.model.Photo;
import ao.co.isptec.aplm.psfotosservices.model.Photo;
import ao.co.isptec.aplm.psfotosservices.repository.PhotoRepository;
import ao.co.isptec.aplm.psfotosservices.repository.PhotoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    private PhotoRepository albumRepository;
    
    @Override
    public Photo addPhoto(Photo album) {
        return albumRepository.save(album);
    } 
    
    @Override
    public List<Photo> getAllPhotos()
    {
        return albumRepository.findAll();
    }
    
    @Override
    public Photo getSinglePhoto(Integer id)
    {
        return albumRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public Photo updatePhoto(Photo newPhoto, Integer id)
    {
        return albumRepository.findById(id).map(album -> {
            album.setSlice_id(newPhoto.getSlice_id());
            album.setUrl(newPhoto.getUrl());
            return albumRepository.save(album);
        }).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public void destroyPhoto(Integer id)
    {
        if(!albumRepository.existsById(id))
        {
            throw new NotFoundException(id);
        }
        
        albumRepository.deleteById(id);   
    }
}
