package com.supervisor.authms.auth;

import com.supervisor.authms.enums.Area;
import com.supervisor.authms.repositories.RoleRepository;
import com.supervisor.authms.repositories.UserRepository;
import com.supervisor.authms.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegistrationRequest request){

        var userRole = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new IllegalArgumentException("Role was not initialized"));

        var user= User.builder()
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
                .createdDate(LocalDateTime.now())
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);
    }
}
