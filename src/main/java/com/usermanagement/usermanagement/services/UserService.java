package com.usermanagement.usermanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.usermanagement.entity.UserEntity;
import com.usermanagement.usermanagement.repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    //create method 
    public String create(UserEntity entity)
    {
        UserEntity savedEntity = this.userRepo.save(entity);
        return "user saved successfully!!";
    }

    // update method 
   public String update(UserEntity entity)
    {   
        Optional<UserEntity> existingEntity = userRepo.findById(entity.getId());
        if(existingEntity.isPresent())
        {

            UserEntity savedEntity = this.userRepo.save(entity);
            return "user updated successfully!!";
        }
        else
        {

            return "user not found!!";
        }
    }

    public UserEntity get(long id)
    {
        Optional<UserEntity> user = this.userRepo.findById(id);
        return user.get();
    }

    public String delete(long id)
    {
        this.userRepo.deleteById(id);
        return "user deleted successfully!!";
    }
}