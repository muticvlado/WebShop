package vlado.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private DataSource myDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(myDataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
		  
		  .antMatchers("/").permitAll()
		  .antMatchers("/user-form-registration").permitAll()
		  //.antMatchers("/resources").permitAll() 
		  
		  .antMatchers("/catalog").hasAnyRole("kupac", "admin")
		  .antMatchers("/cart").hasAnyRole("kupac", "admin")
		  .antMatchers("/product-add-to-cart").hasAnyRole("kupac", "admin")
		  .antMatchers("/add-one").hasAnyRole("kupac", "admin")
		  .antMatchers("/remove-one").hasAnyRole("kupac", "admin")
		  .antMatchers("/delete-item").hasAnyRole("kupac", "admin")
		  .antMatchers("/order-save").hasAnyRole("kupac", "admin")
		  .antMatchers("/user-invoice-list").hasAnyRole("kupac", "admin") 
		  .antMatchers("/invoice-details").hasAnyRole("kupac", "admin") 
		  .antMatchers("/user-save-profile").hasAnyRole("kupac", "admin") 
		  .antMatchers("/user-form-profile").hasAnyRole("kupac", "admin") 
		  .antMatchers("/user-change-password-form").hasAnyRole("kupac", "admin") 
		  .antMatchers("/user-change-password").hasAnyRole("kupac", "admin") 
		 
		  .antMatchers("/*").hasRole("admin")		  
		  
		  .and()
		  .formLogin()
		  .loginProcessingUrl("/authenticateTheUser").permitAll()
		  .and()
		  .logout().permitAll()
		  .and()
		  .exceptionHandling().accessDeniedPage("/access-deneid");
	}
}
