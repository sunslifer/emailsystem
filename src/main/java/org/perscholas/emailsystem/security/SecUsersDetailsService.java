package org.perscholas.emailsystem.security;

import org.perscholas.emailsystem.dao.UsersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecUsersDetailsService implements UserDetailsService {

    private UsersRepo usersRepo;

    public SecUsersDetailsService(UsersRepo usersRepo){
        this.usersRepo = usersRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
