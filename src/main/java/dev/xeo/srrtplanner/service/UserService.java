package dev.xeo.srrtplanner.service;


import dev.xeo.srrtplanner.dto.UserDto;
import dev.xeo.srrtplanner.entity.ApplicationUser;

public interface UserService {
    ApplicationUser createUser(UserDto userDto);
    ApplicationUser findByUsername(String username);
}
