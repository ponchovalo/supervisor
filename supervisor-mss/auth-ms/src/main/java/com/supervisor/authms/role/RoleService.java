package com.supervisor.authms.role;

import com.supervisor.authms.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void register(RoleRequest request){
        var role = Role.builder()
                .name(request.getName())
                .createdDate(LocalDateTime.now())
                .build();
        roleRepository.save(role);
    }
}
