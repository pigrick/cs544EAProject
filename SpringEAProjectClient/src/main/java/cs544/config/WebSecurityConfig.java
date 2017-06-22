package cs544.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
    private CustomAuthenticationProvider authProvider;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
         	.antMatchers("/product/add", "/producut/{id}").hasRole("ADMIN")
         	.antMatchers("/**").permitAll()
             .and()
             .formLogin().loginPage("/login")
             .and()
             .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logoutsuccess");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
		.withUser("yeerick").password("$2a$10$DiaKX27bqzGpDSDQDzONzeR4mp/8QYwtr9l9hXmZ4TM.O3ctTkmB6").roles("ADMIN");
		auth.authenticationProvider(authProvider);
		
	}
}
