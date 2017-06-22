package cs544.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
    private CustomAuthenticationProvider authProvider;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
             .antMatchers("/**").permitAll()
             .and()
             .formLogin().loginPage("/login")
             .and()
             .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logoutsuccess");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("yeerick").password("123asd").roles("ADMIN")
		.and().withUser("orlando").password("123asd").roles("USER");
		auth.authenticationProvider(authProvider);
		
	}
}
