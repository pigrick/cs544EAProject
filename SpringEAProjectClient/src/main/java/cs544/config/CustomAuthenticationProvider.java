package cs544.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import cs544.domain.User;
import cs544.restclient.UserRestClient;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserRestClient userRestClient;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRestClient.getUser(name);
        if(user != null){
        	if(bCryptPasswordEncoder.matches(password, user.getPassword())){
        		List<GrantedAuthority> grantedAuths = new ArrayList<>();
        		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        		Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
        		return auth;
        	}
        }
        password = null;
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	/*public static void main(String[] args) {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.matches("12345", "$2a$10$K0QNiRL.y9SsdqHZt6zvZu2My3GeyFZmR.Sadfbu2Qw96AFxtQx1a"));
		System.out.println(b.encode("12345"));
		System.out.println(b.encode("12345"));
	}*/
}
