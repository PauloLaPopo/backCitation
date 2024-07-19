package com.example.backcitation.service.authentication;

import com.example.backcitation.dto.LoginDto;
import com.example.backcitation.dto.UserDto;
import com.example.backcitation.model.Role;
import com.example.backcitation.model.RoleEnum;
import com.example.backcitation.model.User;
import com.example.backcitation.repository.authentication.UserRepository;
import com.example.backcitation.repository.role.RoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User signup(UserDto userDto) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if(optionalRole.isEmpty()) {
            return null;
        }
        User user = new User(
                userDto.getUserName(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword()),
                optionalRole.get()
        );
        System.out.println("On est ici" + user.getId());
        return userRepository.save(user);
    }

    public User authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}