package com.example.User.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.Entity.User;
import com.example.User.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAll() {
        return userRepository.findAll();
    }
     
    public void save(User user) {
    	userRepository.save(user);
    }
     
    public User get(long id) {
        return userRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	userRepository.deleteById(id);
    }
}
