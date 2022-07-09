package com.artplansoftware.secondtask.service;

import com.artplansoftware.secondtask.entity.Role;
import com.artplansoftware.secondtask.entity.User;
import com.artplansoftware.secondtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SecurityService implements UserDetailsService {

    private UserRepository usersRepository;

    @Autowired
    public SecurityService(UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

    User user = findByName(name);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", name));
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    public User findByName(String name) {
        return usersRepository.findByName(name.toLowerCase());
    }

    private Collection <? extends GrantedAuthority> mapRolesToAuthorities (Collection <Role> roles) {
        return roles.stream().map( role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    }

}
