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

    public void register(RegistrationRequest request){

//        var user = User.builder()
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .email(request.getEmail())
//                .area(Area.REDES_INFORMATICA)
//                .build();
        System.out.println(request);
    }
}
