package com.example.userservice.user;

import com.example.userservice.user.client.PointClient;
import com.example.userservice.user.dto.AddActivityScoreRequestDto;
import com.example.userservice.user.dto.UserDto;
import com.example.userservice.user.dto.UserResponseDto;
import com.example.userservice.user.event.UserSignedUpEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PointClient pointClient;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserService(UserRepository userRepository,
                       PointClient pointClient,
                       KafkaTemplate<String, String> kafkaTemplate) {
        this.userRepository = userRepository;
        this.pointClient = pointClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public void signUp(UserDto signUpRequestDto) {
        User user = new User(
                signUpRequestDto.getEmail(),
                signUpRequestDto.getName(),
                signUpRequestDto.getPassword()
        );

        User savedUser = this.userRepository.save(user);

        // 회원가입하면 포인트 1000점 적립
        pointClient.addPoints(savedUser.getUserId(), 1000);

        // '회원가입 완료' 이벤트 발행
        UserSignedUpEvent userSignedUpEvent = new UserSignedUpEvent(
                savedUser.getUserId(),
                savedUser.getName()
        );
        this.kafkaTemplate.send(
                "user.signed-up",
                toJsonString(userSignedUpEvent)
        );
    }

    public UserResponseDto getUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return new UserResponseDto(
                user.getUserId(),
                user.getEmail(),
                user.getName()
        );
    }

    public List<UserResponseDto> getUsersByIds(List<Long> ids){
        List<User> users = userRepository.findAllById(ids);
        return users.stream()
                .map(user -> new UserResponseDto(
                      user.getUserId(),
                      user.getEmail(),
                      user.getName()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addActivityScore(
            AddActivityScoreRequestDto addActivityScoreRequestDto
    ) {
        User user = userRepository.findById(addActivityScoreRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        user.addActivityScore(addActivityScoreRequestDto.getScore());

        userRepository.save(user);
    }

    // 객체를 Json 형태의 String으로 만들어주는 메서드
    // (클래스로 분리하면 더 좋지만 편의를 위해 메서드로만 분리)
    private String toJsonString(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String message = objectMapper.writeValueAsString(object);
            return message;
        } catch (Exception e) {
            throw new RuntimeException("Json 직렬화 실패");
        }
    }

}