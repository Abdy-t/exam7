package com.example.exam7.model;

import com.example.exam7.util.GenerateData;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document(collection = "clients")
@Data
public class Client implements UserDetails {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String password;

    public static Client randomClient() {
        return builder()
                .name(GenerateData.randomPersonName())
                .email(GenerateData.randomEmail())
                .password(new BCryptPasswordEncoder().encode("123"))
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority>
    getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

//    @Override
//    public String getPassword() {
//        return getPassword();
//    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
