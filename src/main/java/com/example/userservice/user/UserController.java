package com.example.userservice.user;

import com.example.userservice.user.dto.AddActivityScoreRequestDto;
import com.example.userservice.user.dto.UserDto;
import com.example.userservice.user.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // 외부 api
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("sign-up")
    public ResponseEntity<Void> signUp(
            @RequestBody UserDto signUpRequestDto
    ) {
        userService.signUp(signUpRequestDto);
        return ResponseEntity.noContent().build();
    }

}