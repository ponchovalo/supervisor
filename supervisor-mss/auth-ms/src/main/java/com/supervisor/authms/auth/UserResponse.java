package com.supervisor.authms.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserResponse {

    private String fullName;
    private String email;
    private String area;
    private String position;
    private List<String> roles;

}
