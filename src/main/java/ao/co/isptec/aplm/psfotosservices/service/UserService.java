
package ao.co.isptec.aplm.psfotosservices.service;

import ao.co.isptec.aplm.psfotosservices.model.User;
import java.util.List;

public interface UserService {
    
    public List<User> getAllUsers();
    
    public User getSingleUser(Integer id);
    
    public User registerUser(User user);
    
    public User updateUser(User user, Integer id);
    
    public void destroyUser(Integer id);
}
