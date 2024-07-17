package com.example.backcitation.controller;

import com.example.backcitation.dto.LoginDto;
import com.example.backcitation.dto.UserDto;
import com.example.backcitation.exception.UserExistsException;
import com.example.backcitation.service.UserService;
import com.example.backcitation.utils.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        try {
            String username = userService.addUser(userDto);
            return ResponseEntity.ok("Utilisateur créé avec succès: " + username);
        } catch (UserExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la création de l'utilisateur.");
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        LoginMessage loginMessage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);
    }
}
