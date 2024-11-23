package com.example.titleapi.models;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ADMIN"),
    WORKER("WORKER"),
    USER("USER");
    private final String vale;
    @Override
    public String getAuthority(){
        return vale;
    }
}
