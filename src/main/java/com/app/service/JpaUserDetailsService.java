package com.app.service;

import com.app.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    public JpaUserDetailsService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return
                personRepository.findByEmail(username)
                        .map(SecurityUser::new).orElseThrow(()-> new UsernameNotFoundException("user not found " + username));
    }
}
