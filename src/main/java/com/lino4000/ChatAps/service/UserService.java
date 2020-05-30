package com.lino4000.ChatAps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino4000.ChatAps.model.Login;
import com.lino4000.ChatAps.model.User;
import com.lino4000.ChatAps.repository.UserRepository;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    private Argon2 argon2;
    
    public UserService() {
    	argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
    }
    
    public void save(User user) {
        user = User.builder()
        	.username(user.getUsername())
        	.password(argon2.hash(10, 65536, 1, user.getPassword().toCharArray() ))
        	.isLogged(false)
        	.isActive(true)
        	.build();
        userRepository.save(user);
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public Boolean verifyPassword(Login login) {
    	User persistence = userRepository.findByUsername(login.getUsername());
    	Boolean bool;
    	try {
    		bool = argon2.verify( persistence.getPassword(), login.getPassword().toCharArray() );
    	}finally {
        	argon2.wipeArray(login.getPassword().toCharArray());
    	}
    	System.out.println(bool);
    	return bool;
    }
   
    public void hash() {
    	System.out.println(argon2.hash(10, 65536, 1, "123456".toCharArray() ));
    }
}