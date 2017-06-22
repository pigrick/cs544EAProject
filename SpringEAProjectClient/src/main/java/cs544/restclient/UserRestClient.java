package cs544.restclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import cs544.domain.User;


@Controller
public class UserRestClient {
	
	private static final String URL = "http://localhost:7775/rs/user/";
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public List<User> getUsers(){
		return Arrays.asList(restTemplate.getForObject(URL + "/all", User[].class));
	}
	
	public User getUser(String username){
		return restTemplate.getForObject(URL + username, User.class);
	}
	
	public void createUser(User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		restTemplate.postForObject(URL + "add", user, User.class);
	}
	
	public void updateUser(User user){
		if(user.getPassword().length() < 30){
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		restTemplate.put(URL + "update", user, User.class);
	}
	
	public void removeUser(User user){
		restTemplate.delete(URL + "delete/" + user.getId());
	}
	
	
}
