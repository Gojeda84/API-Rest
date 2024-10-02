package com.nisum.apirest.controller;

import com.nisum.apirest.model.User;
import com.nisum.apirest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.emailExists(user.getEmail())) {
            return new ResponseEntity<>("El correo ya registrado", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

}
