package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.repository.UserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}

	@Override
	public Optional<User> findUserById(int orderId) {
		// TODO Auto-generated method stub
		return userRepository.findById(orderId);
		
	}

	@Override
	public User createUser(User o) {
		// TODO Auto-generated method stub
		return userRepository.save(o);
		
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		try{
			userRepository.deleteById(id);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public User update(User o) {
		// TODO Auto-generated method stub
		return userRepository.save(o);
		
	}

}
