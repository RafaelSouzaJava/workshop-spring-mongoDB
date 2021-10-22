package com.rafaelsouza.worshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelsouza.worshopmongo.domain.User;
import com.rafaelsouza.worshopmongo.repositories.UserRepository;
import com.rafaelsouza.worshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		List<User> user = userRepository.findAll();
		return user;
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado"));
	}
}
