
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.model.Slice;
import java.util.List;

public interface SliceService {
    public List<Slice> getAllSlices();
    
    public Slice getSingleSlice(Integer id);
    
    public Slice addSlice(Slice slice);
    
    public Slice updateSlice(Slice slice, Integer id);
    
    public void destroySlice(Integer id);
}
