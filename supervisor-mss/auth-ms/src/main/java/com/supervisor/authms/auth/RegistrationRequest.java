package com.supervisor.authms.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @NotBlank(message = "FirstName is mandatory")
    @NotNull(message = "FirstName is mandatory")
    private String firstName;
    @NotBlank(message = "FirstName is mandatory")
    @NotNull(message = "FirstName is mandatory")
    private String lastName;
    @NotBlank(message = "FirstName is mandatory")
    @NotNull(message = "FirstName is mandatory")
    @Email(message = "Email is not")
    private String email;

    @NotBlank(message = "Area is mandatory")
    @NotNull(message = "Area is mandatory")
    private String area;
    @NotBlank(message = "Postition is mandatory")
    @NotNull(message = "Postition is mandatory")
    private String position;
    @NotBlank(message = "Shift is mandatory")
    @NotNull(message = "Shift is mandatory")
    private String shift;

    @NotBlank
    @NotNull
    private List<String> roles;
}
