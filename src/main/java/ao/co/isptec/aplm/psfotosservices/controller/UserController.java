/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.co.isptec.aplm.psfotosservices.controller;

import ao.co.isptec.aplm.psfotosservices.service.UserService;
import ao.co.isptec.aplm.psfotosservices.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/users")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @GetMapping("")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return service.getSingleUser(id);
    }
    
    @PostMapping("")
    public String register(@RequestBody User user){
        service.registerUser(user);
        return "New student is added";
    }
    
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id)
    {
        return service.updateUser(user, id);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id)
    {
        service.destroyUser(id);
        return "O usuário com o id "+id+" foi excluído";
    }
}
