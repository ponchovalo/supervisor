package com.supervisor.authms.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request){
        authService.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
