package com.supervisor.authms.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Username is mandatory")
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotEmpty(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password should be 8 characters min")
    private String password;

    @NotEmpty(message = "Firstname is mandatory")
    @NotBlank(message = "Firstname is mandatory")
    private String firstName;
    @NotEmpty(message = "Lastname is mandatory")
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    @NotEmpty(message = "Lastname is mandatory")
    @NotBlank(message = "Lastname is mandatory")
    @Email(message = "Email is not formatted")
    private String email;

    @NotEmpty(message = "Area is mandatory")
    @NotBlank(message = "Area is mandatory")
    private String area;
    @NotEmpty(message = "Position is mandatory")
    @NotBlank(message = "Position is mandatory")
    private String position;
    @NotEmpty(message = "Shift is mandatory")
    @NotBlank(message = "Shift is mandatory")
    private String shift;

    @NotEmpty(message = "Roles is mandatory")
    @NotBlank(message = "Roles is mandatory")
    private List<String> roles;

}
