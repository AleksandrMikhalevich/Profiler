package by.itacademy.profiler.api.controllers;


import by.itacademy.profiler.usecasses.UserProfileService;
import by.itacademy.profiler.usecasses.dto.UserProfileDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
@Slf4j
public class UserProfileRestController {

    private final UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity<UserProfileDto> saveUserProfile(@RequestBody @Valid UserProfileDto userProfile) {
        log.debug("Input data for creating profile: {} ", userProfile);
        UserProfileDto profile = userProfileService.saveUserProfile(userProfile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }
}