package com.example.backcitation.service;

import com.example.backcitation.dto.LoginDto;
import com.example.backcitation.dto.UserDto;
import com.example.backcitation.exception.UserExistsException;
import com.example.backcitation.model.User;
import com.example.backcitation.repository.UserRepository;
import com.example.backcitation.utils.ErrorTypes;
import com.example.backcitation.utils.LoginMessage;
import com.example.backcitation.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new UserExistsException(ErrorTypes.EMAIL_ALREADY_EXISTS.toString());
        } else if (userRepository.findByUserName(userDto.getUserName()) != null) {
            throw new UserExistsException(ErrorTypes.USER_NAME_ALREADY_EXISTS.toString());
        } else {
            User user = new User(
                    userDto.getUserName(),
                    userDto.getEmail(),
                    this.passwordEncoder.encode(userDto.getPassword()),
                    Role.USER
            );

            userRepository.save(user);

            return user.getUserName();
        }
    }

    public LoginMessage loginUser(LoginDto loginDto) {
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exits", false);
        }

    }
}
