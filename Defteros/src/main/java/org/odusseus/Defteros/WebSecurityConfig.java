package org.odusseus.Defteros;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails user1 = User
				.withUsername("pascal")
				.password("$2a$10$70xm5GBxf73pnuEjRPlvmOycEYHdcVlktIsrLKw8wAzDd9UrWmYvG")
				.roles("USER")
				.build();
		UserDetails user2 = User
				.withUsername("admin")
				.password("$2a$10$rKPuJYPAo9blKNud3T6L1e2AUvI8Fbg0QqzBd/KWbMW0Rq3hrD/S.")
				.roles("ADMIN")
				.build();		
		
		return new InMemoryUserDetailsManager(user1, user2);
	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// 	http
	// 		.authorizeRequests().antMatchers("/", "/home").permitAll()
	// 		.mvcMatchers("/cpanel").hasRole("ADMIN")
	// 		.anyRequest().authenticated()
	// 		.and()
	// 		.formLogin()
	// 			.loginPage("/login")		
	// 			.usernameParameter("u").passwordParameter("p")				
	// 			.permitAll()
	// 			.failureUrl("/loginerror")
	// 			.defaultSuccessUrl("/loginsuccess")
	// 			.and()
	// 		.logout().permitAll()
	// 		.logoutSuccessUrl("/logoutsuccess")
	// 		.and()
	// 		.exceptionHandling().accessDeniedPage("/403");
		
	// }

	@Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                    auth -> auth.requestMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(
                login -> login.loginPage("/login")      
                            .usernameParameter("u").passwordParameter("p")             
                            .permitAll()
            )
            .logout(logout -> logout.permitAll());
         
        return http.build();
    }

}
