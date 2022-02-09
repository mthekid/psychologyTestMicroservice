package com.starlab.demo.psychology.controller;

import com.starlab.demo.psychology.dto.ResponseDTO;
import com.starlab.demo.psychology.dto.UserDTO;
import com.starlab.demo.psychology.model.User;
import com.starlab.demo.psychology.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psychology-test/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            User user = User.builder()
                    .name(userDTO.getName())
                    .email(userDTO.getEmail())
                    .build();

            User registeredUser = userService.createUser(user);

            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error(e.getMessage())
                    .build();

            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }
}
