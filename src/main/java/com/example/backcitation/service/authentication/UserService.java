package com.example.backcitation.service.authentication;

import com.example.backcitation.dto.UserDto;
import com.example.backcitation.model.Role;
import com.example.backcitation.model.RoleEnum;
import com.example.backcitation.model.User;
import com.example.backcitation.repository.authentication.UserRepository;
import com.example.backcitation.repository.role.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User createAdministrator(UserDto userDto) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()) {
            return null;
        }

        var user = new User(
                userDto.getUserName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                optionalRole.get()
        );

        return userRepository.save(user);
    }
}
