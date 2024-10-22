package com.supervisor.authms.auth;

import com.supervisor.authms.enums.Area;
import com.supervisor.authms.repositories.RoleRepository;
import com.supervisor.authms.repositories.UserRepository;
import com.supervisor.authms.role.Role;
import com.supervisor.authms.security.JwtService;
import com.supervisor.authms.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void register(RegistrationRequest request){

        var userRole = roleRepository.findByName(request.getRoles().get(0))
                .orElseThrow(() -> new IllegalArgumentException("Role was not initialized"));

        var user= User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
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

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var claims = new HashMap<String, Object>();
        var user = ((User) auth.getPrincipal());
        claims.put("fullName", user.fullName());
        var jwtToken = jwtService.generateToken(claims, user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(UserResponse.builder()
                        .fullName(user.fullName())
                        .email(user.getEmail())
                        .area(user.getArea())
                        .position(user.getPosition())
                        .roles(user.getRoles().stream().map(m -> m.getName()).toList())
                        .build())
                .build();

    }


}
