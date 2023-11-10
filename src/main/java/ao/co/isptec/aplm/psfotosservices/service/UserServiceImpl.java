
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.exception.NotFoundException;
import ao.co.isptec.aplm.psfotosservices.model.User;
import ao.co.isptec.aplm.psfotosservices.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    } 
    
    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    
    @Override
    public User getSingleUser(Integer id)
    {
        return userRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public User updateUser(User newUser, Integer id)
    {
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new NotFoundException(id));
    }
    
    @Override
    public void destroyUser(Integer id)
    {
        if(!userRepository.existsById(id))
        {
            throw new NotFoundException(id);
        }
        
        userRepository.deleteById(id);
        
    }
}
