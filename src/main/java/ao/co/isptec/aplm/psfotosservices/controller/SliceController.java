/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.co.isptec.aplm.psfotosservices.controller;

import ao.co.isptec.aplm.psfotosservices.model.Slice;
import ao.co.isptec.aplm.psfotosservices.service.SliceService;

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
@RequestMapping(path = "/slices")
public class SliceController {
    @Autowired
    private SliceService service;
    
    @GetMapping("")
    public List<Slice> getAllSlices(){
        return service.getAllSlices();
    }
    
    @GetMapping("/{id}")
    public Slice getSlice(@PathVariable Integer id){
        return service.getSingleSlice(id);
    }
    
    @PostMapping("")
    public String createSlice(@RequestBody Slice slice){
        service.addSlice(slice);
        return "New student is added";
    }
    
    @PutMapping("/{id}")
    public Slice updateSlice(@RequestBody Slice slice, @PathVariable Integer id)
    {
        return service.updateSlice(slice, id);
    }
    
    @DeleteMapping("/{id}")
    public String deleteSlice(@PathVariable Integer id)
    {
        service.destroySlice(id);
        return "O usuário com o id "+id+" foi excluído";
    }
}
