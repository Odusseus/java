package org.odusseus.Defteros;

import java.util.List;

import org.odusseus.Defteros.entity.Users;
import org.odusseus.Defteros.logic.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    @Autowired
      UserLogic userLogic = new UserLogic();  

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    protected InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails admin = User
                .withUsername("admin")
                .password("$2a$10$c5518mi.469TuB/.P6xJq.lp1poY8N/l7U0FiQoJURdwy.CkgsZXi")
                .roles("ADMIN")
                .build();	
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(admin);
        
        Users users = userLogic.getUsers();
        List<org.odusseus.Defteros.entity.User> userList = users.getList();

        breakLoop:
            for(org.odusseus.Defteros.entity.User user : userList)
            {
                if (user == null) break breakLoop; 
                UserDetails userDetails = User.withUsername(user.getName())
                                        .password(user.getPasswordEncrypted())
                                        .roles(user.getRoleType().toString())
                                        .build();

                inMemoryUserDetailsManager.createUser(userDetails);
            };	
            
        return inMemoryUserDetailsManager;
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
