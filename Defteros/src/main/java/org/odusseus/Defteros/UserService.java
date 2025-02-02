package org.odusseus.Defteros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(InMemoryUserDetailsManager inMemoryUserDetailsManager, PasswordEncoder passwordEncoder) {
         this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
         this.passwordEncoder = passwordEncoder;
     }

    // @Autowired
    // public UserService(InMemoryUserDetailsManager inMemoryUserDetailsManager, ) {
    //     this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    // }


    public void addUser(String username, String passwordEncrypted, String role) {
        UserDetails newUser = User
                .withUsername(username)
                .password(passwordEncrypted)
                .roles(role)
                .build();
        inMemoryUserDetailsManager.createUser(newUser);
    }

    public void updateUser(String username, String passwordEncrypted, String role) {
        inMemoryUserDetailsManager.deleteUser(username);
        UserDetails newUser = User
                .withUsername(username)
                .password(passwordEncrypted)
                .roles(role)
                .build();
        inMemoryUserDetailsManager.createUser(newUser);
    }

}
