package com.rafaelsouza.worshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelsouza.worshopmongo.domain.User;
import com.rafaelsouza.worshopmongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		List<User> user = userRepository.findAll();
		return user;
	}
}
