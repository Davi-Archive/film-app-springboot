package io.davi.film.services;

import io.davi.film.dto.UserDTO;
import io.davi.film.entities.User;
import io.davi.film.repositories.UserRepository;
import io.davi.film.services.exceptions.ResourceNotFoundException;
import io.davi.film.services.exceptions.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository repository;
    @Autowired
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id);
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() ->
                new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if (user == null) {
            logger.error("User not found:  " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        return user;
    }

    public UserDTO findByUser() {
        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        if(username == null){
            throw new UnauthorizedException("User not found");
        }
        User entity = repository.findByEmail(username);
        return new UserDTO(entity);
    }
}
