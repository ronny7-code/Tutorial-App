package com.itn.TutorialApp.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class AdminDetail implements UserDetails {

    private final String username;
    private final String password;
    private final String role;

    public AdminDetail(Admin admin) {
        this.username = admin.getUsername();
        this.password = admin.getPassword();
        this.role = (admin.getAdminRole() != null) ? admin.getAdminRole().getRole() : "ADMIN";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}