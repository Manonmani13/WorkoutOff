package com.javabrains;



import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
protected void  configure(AuthenticationManagerBuilder auth)throws Exception
{
	auth.inMemoryAuthentication()
	.withUser("mano")
	.password("man")
	.roles("USER")
	.and()
	.withUser("foo")
	.password("foo")
	.roles("ADMIN");
	
}
protected void  configure(HttpSecurity http) throws Exception
{
	http.authorizeRequests()
	.antMatchers("/user").hasRole("USER")
	.antMatchers("/").permitAll()
	.antMatchers("/admin").hasAnyRole("ADMIN","USER")
	.and().formLogin();
	
}
@Bean
public  PasswordEncoder getPasswordEncoder()
{
	return NoOpPasswordEncoder.getInstance();
}
}
