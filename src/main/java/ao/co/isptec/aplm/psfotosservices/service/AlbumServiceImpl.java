
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.exception.NotFoundException;
import ao.co.isptec.aplm.psfotosservices.model.Album;
import ao.co.isptec.aplm.psfotosservices.model.Album;
import ao.co.isptec.aplm.psfotosservices.repository.AlbumRepository;
import ao.co.isptec.aplm.psfotosservices.repository.AlbumRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService{
   @Autowired
    private AlbumRepository albumRepository;
    
    @Override
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    } 
    
    @Override
    public List<Album> getAllAlbums()
    {
        return albumRepository.findAll();
    }
    
    @Override
    public Album getSingleAlbum(Integer id)
    {
        return albumRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public Album updateAlbum(Album newAlbum, Integer id)
    {
        return albumRepository.findById(id).map(album -> {
            album.setName(newAlbum.getName());
            return albumRepository.save(album);
        }).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public void destroyAlbum(Integer id)
    {
        if(!albumRepository.existsById(id))
        {
            throw new NotFoundException(id);
        }
        
        albumRepository.deleteById(id);   
    }
}
