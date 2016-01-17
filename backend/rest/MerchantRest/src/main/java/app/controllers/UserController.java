package app.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.User;
import app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createUser(@RequestBody User user) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();

		if (user != null) {
			userService.create(user);
			response.put("message", "User created successfully");
			response.put("user", user);
		}else
		{
			response.put("message", "User is null");
				
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return (List<User>) userService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	public User getUserDetails(@PathVariable("userId") String userId) {
		return userService.findById(userId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
	public String removeUser(@PathVariable("userId") String userId) {
		userService.remove(userId);
		return "removed";
	}
	
}
