
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.exception.NotFoundException;
import ao.co.isptec.aplm.psfotosservices.model.Slice;
import ao.co.isptec.aplm.psfotosservices.repository.SliceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SliceServiceImpl implements SliceService{
    @Autowired
    private SliceRepository sliceRepository;
    
    @Override
    public Slice addSlice(Slice slice) {
        return sliceRepository.save(slice);
    } 
    
    @Override
    public List<Slice> getAllSlices()
    {
        return sliceRepository.findAll();
    }
    
    @Override
    public Slice getSingleSlice(Integer id)
    {
        return sliceRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public Slice updateSlice(Slice newSlice, Integer id)
    {
        return sliceRepository.findById(id).map(slice -> {
            slice.setAlbum_id(newSlice.getAlbum_id());
            slice.setUser_id(newSlice.getUser_id());
            slice.setUrl(newSlice.getUrl());
            return sliceRepository.save(slice);
        }).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public void destroySlice(Integer id)
    {
        if(!sliceRepository.existsById(id))
        {
            throw new NotFoundException(id);
        }
        
        sliceRepository.deleteById(id);   
    }
}
