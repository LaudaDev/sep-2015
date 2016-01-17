package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repository.local.UserLocalRepository;

@Service
public class UserService {

	@Autowired
	private UserLocalRepository userRepository;

	
	public User create(User user) {
	
		return userRepository.save(user);
	}

	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

	public User findById(String id) {
		return userRepository.findOne(id);
	}

	
	public void remove(String id) {
		userRepository.delete(id);		
	}

	public User update(User user) {
		return userRepository.save(user);
	}
}
