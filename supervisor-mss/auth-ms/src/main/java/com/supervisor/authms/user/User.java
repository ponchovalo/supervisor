package com.supervisor.authms.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supervisor.authms.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {


    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    @Column(unique=true)
    private String email;

    private boolean accountLocked;
    private boolean enabled;

    // Datos para la empresa
    private String area;
    private String position;
    private String shift;

    @ManyToMany(fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Role> roles;

    @CreatedDate
    @Column(nullable=false, updatable=false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable=false)
    private LocalDateTime lastModifiedDate;

    @Override
    public String getName() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String fullName(){
        return firstName + " " + lastName;
    }
}
