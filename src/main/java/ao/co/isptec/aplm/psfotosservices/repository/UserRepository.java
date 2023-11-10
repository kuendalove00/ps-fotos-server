/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ao.co.isptec.aplm.psfotosservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ao.co.isptec.aplm.psfotosservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
