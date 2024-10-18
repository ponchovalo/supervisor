package com.supervisor.authms.role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class RoleRequest {
    @NotNull(message = "Role name is mandatory")
    @NotBlank(message = "Role name is mandatory")
    private String name;
}
