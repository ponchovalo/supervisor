package com.supervisor.authms.auth;


import com.supervisor.authms.user.User;
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
    public RegistrationRequest register(@RequestBody RegistrationRequest request){
        return request;
    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String registerTest(
            //@RequestBody RegistrationRequest request
    ){
        return "request";

    }

}
