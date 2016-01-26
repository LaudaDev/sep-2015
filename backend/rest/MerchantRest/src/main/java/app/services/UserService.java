package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repository.UserRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = Logger.getLogger(UserService.class);

	public Map<String, Object> create(User user) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		userRepository.save(user);
		response.put("message", "User successfully created");
		response.put("user", user);	
		logger.info("User successfully created");

		return response;
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public User findById(String id) {

		if (id == null) {
			throw new BadRequestException("user id is null");
		}
		User user = userRepository.findOne(id);
		if (user == null) {
			throw new NotFoundException("User with id " + id + " doesn't exist.");
		}
		return user;
	}

	public String remove(String id) {

		if (id == null) {
			throw new BadRequestException("user id is null");
		}
		logger.info("Removing user with id: " + id);
		userRepository.delete(id);
		return "removed";
	}
	
	public Map<String, Object> edit(User user) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		userRepository.save(user);
		response.put("message", "User successfully updated");
		response.put("user", user);	
		logger.info("User successfully updated");

		return response;
	}
}
