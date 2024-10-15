package com.supervisor.authms.auth;

import com.supervisor.authms.enums.Area;
import com.supervisor.authms.repositories.UserRepository;
import com.supervisor.authms.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegistrationRequest request){
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .accountLocked(false)
                .enabled(true)
                .area(request.getArea())
                .position(request.getPosition())
                .shift(request.getShift())
                .build();
    }
}
