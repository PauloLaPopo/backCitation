package com.example.backcitation.bootstrap;

import com.example.backcitation.dto.UserDto;
import com.example.backcitation.model.Role;
import com.example.backcitation.model.RoleEnum;
import com.example.backcitation.model.User;
import com.example.backcitation.repository.authentication.UserRepository;
import com.example.backcitation.repository.role.RoleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public AdminSeeder(
            RoleRepository roleRepository,
            UserRepository  userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.createSuperAdministrator();
    }

    private void createSuperAdministrator() {
        UserDto userDto = new UserDto(
                "Super Admin",
                "super.admin@email.com",
                "123456"
        );

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.SUPER_ADMIN);
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalRole.isEmpty() || optionalUser.isPresent()) {
            return;
        }

        var user = new User(
                userDto.getUserName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                optionalRole.get()
        );

        userRepository.save(user);
    }
}
