package dev.xeo.srrtplanner.service.impl;


import dev.xeo.srrtplanner.dto.UserDto;
import dev.xeo.srrtplanner.entity.ApplicationUser;
import dev.xeo.srrtplanner.repository.UserRepository;
import dev.xeo.srrtplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApplicationUser createUser(UserDto userDto) {
       ApplicationUser applicationUser = new ApplicationUser();
       applicationUser.setFirstName(userDto.getFirstName());
       applicationUser.setLastName(userDto.getLastName());
       applicationUser.setEmail(userDto.getEmail());
       applicationUser.setUsername(userDto.getUsername());
       applicationUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

       return userRepository.save(applicationUser);
    }

    public ApplicationUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
