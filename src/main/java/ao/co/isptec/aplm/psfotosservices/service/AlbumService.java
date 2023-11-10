
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.model.Album;
import java.util.List;

public interface AlbumService {
    
    public List<Album> getAllAlbums();
    
    public Album getSingleAlbum(Integer id);
    
    public Album createAlbum(Album album);
    
    public Album updateAlbum(Album album, Integer id);
    
    public void destroyAlbum(Integer id);
}
