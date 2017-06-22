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
import org.springframework.stereotype.Component;

import cs544.domain.User;
import cs544.restclient.UserRestClient;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UserRestClient userRestClient;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRestClient.getUser(name);
        if(user != null){
        	if(user.getPassword().equals(password)){
        		List<GrantedAuthority> grantedAuths = new ArrayList<>();
        		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        		Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
        		return auth;
        	}
        }
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
