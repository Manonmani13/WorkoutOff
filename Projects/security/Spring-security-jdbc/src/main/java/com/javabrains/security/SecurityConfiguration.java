package com.javabrains.security;
import javax.sql.DataSource;

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
	@Autowired
	DataSource  dataSource;
	
protected void  configure(AuthenticationManagerBuilder auth)throws Exception
{
	auth.jdbcAuthentication()
	.dataSource(dataSource)
	.usersByUsernameQuery("select username,password,enable"+"from users"+"where username=?")
	.authoritiesByUsernameQuery("select  username,authority"+"from authorities"+"where username=?");
	}
protected void  configure(HttpSecurity http) throws Exception
{
	http.authorizeRequests()
	.antMatchers("/admin").hasRole("ADMIN")
	.antMatchers("/user").hasAnyRole("ADMIN","USER")
	.antMatchers("/").permitAll()
	.and().formLogin();
	
}
@Bean
public  PasswordEncoder getPasswordEncoder()
{
	return NoOpPasswordEncoder.getInstance();
}
}
/*.withDefaultSchema()
.withUser(
		User.withUsername("user")
		.password("pass")
		.roles("USER")
		)
withUser(
		User.withUsername("name")
		.password("pass")
		.roles("ADMIN")
		);*/ 
/*.dataSource(dataSource)
.usersByUsernameQuery("select username,password,enabled"
		+"from users"
		+"where username=?")
.authoritiesByUsernameQuery("select  username,authority"
		+"from authorities"
		+"where username=?");
*/
