package cs544.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cs544.domain.CreditCard;
import cs544.domain.User;
import cs544.service.UserService;

@RestController
@RequestMapping(value="/rs/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<User> getUsers(){
		
		return userService.getUsers();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public User getUser(@PathVariable("username") String username){
		return userService.getUser(username);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addUser(@RequestBody User user){
		userService.save(user);
	}
	
	@RequestMapping(value="update", method=RequestMethod.PUT)
	public void updateUser(@RequestBody User user){
		userService.save(user);
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id){
		userService.delete(id);
	}
	
	
}
