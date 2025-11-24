package com.example.userservice.user;

import com.example.userservice.user.dto.AddActivityScoreRequestDto;
import com.example.userservice.user.dto.UserDto;
import com.example.userservice.user.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/users") // 내부용 api
public class UserInternalController {
    private final UserService userService;

    public UserInternalController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 단건 조회
    @GetMapping("{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        return ResponseEntity.ok(userResponseDto);
    }

    // 사용자 목록 조회
    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getUsersByIds(
            @RequestParam List<Long> ids
    ) {
        List<UserResponseDto> userResponseDtos = userService.getUsersByIds(ids);
        return ResponseEntity.ok(userResponseDtos);

    }

    // 활동 점수 추가
    @PostMapping("activity-score/add")
    public ResponseEntity<Void> addActivityScore(
            @RequestBody AddActivityScoreRequestDto addActivityScoreRequestDto
    ) {
        userService.addActivityScore(addActivityScoreRequestDto);
        return ResponseEntity.noContent().build();
    }
}