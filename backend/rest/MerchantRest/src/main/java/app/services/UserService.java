package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repository.local.UserRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = Logger.getLogger(UserService.class);

	public Map<String, Object> create(User user) {

		Map<String, Object> response;

		if (user == null) {
			throw new BadRequestException();
		}

		response = new LinkedHashMap<String, Object>();
		userRepository.save(user);
		response.put("message", "User created successfully");
		response.put("region", user);

		logger.info("User created successfully");

		return response;
	}

	public List<User> findAll() {

		logger.info("List all users");
		return (List<User>) userRepository.findAll();
	}

	public User findById(String id) {

		if (id == null) {
			throw new BadRequestException();
		}
		logger.info("Find user with id: " + id);
		User user = userRepository.findOne(id);

		if (user == null) {
			throw new NotFoundException();
		}
		return user;
	}

	public String remove(String id) {

		if (id == null) {
			throw new BadRequestException();
		}
		logger.info("Removing user with id: " + id);
		userRepository.delete(id);
		return "removed";
	}
}
