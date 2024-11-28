package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.User;

public interface IUserService {
	public List<User> findAll();
	public Optional<User> findUserById(int orderId);
	public User createUser(User o);
	public boolean deleteUser(int id);
	public User update(User o);

}
