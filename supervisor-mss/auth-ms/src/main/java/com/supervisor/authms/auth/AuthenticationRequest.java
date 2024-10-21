package com.supervisor.authms.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {

    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    private String password;

}
