package com.supervisor.authms.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ){
        return ResponseEntity.accepted().build();

    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String registerTest(
            @RequestBody RegistrationRequest request
    ){
        return "request";

    }

}
