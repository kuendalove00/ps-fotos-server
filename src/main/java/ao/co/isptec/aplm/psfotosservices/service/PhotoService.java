
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.model.Photo;
import java.util.List;

public interface PhotoService {
    public List<Photo> getAllPhotos();
    
    public Photo getSinglePhoto(Integer id);
    
    public Photo addPhoto(Photo photo);
    
    public Photo updatePhoto(Photo photo, Integer id);
    
    public void destroyPhoto(Integer id);
}
