/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.models.dtos;

import com.thehumblefool.pokégoapi2.models.entities.AdminUserEntityModel;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author TheHumbleFool
 */
public class AdminUserDetails implements UserDetails {

    private final AdminUserEntityModel entityModel;

    public AdminUserDetails(AdminUserEntityModel entityModel) {
        this.entityModel = entityModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority[]{new SimpleGrantedAuthority("ADMIN")});
    }

    @Override
    public String getPassword() {
        return entityModel.getPassword();
    }

    @Override
    public String getUsername() {
        return entityModel.getUserName();
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
