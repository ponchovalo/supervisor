package com.supervisor.authms.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    private String password;

    private String firstName;
    private String lastName;
    private String email;

    private String area;
    private String position;
    private String shift;
}
