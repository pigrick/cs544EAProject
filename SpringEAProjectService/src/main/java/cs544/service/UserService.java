package cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.domain.User;
import cs544.repository.UserRepository;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(String username){
		return userRepository.findByUsername(username);
	}
	
	public User save(User user){
		return userRepository.save(user);
	}
	
	public void delete(int id){
		userRepository.deleteById(id);
	}
}
