/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.services;

import com.thehumblefool.pokégoapi2.models.dtos.AdminUserDetails;
import com.thehumblefool.pokégoapi2.models.entities.AdminUserEntityModel;
import com.thehumblefool.pokégoapi2.repositories.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheHumbleFool
 */
@Service
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminUserRepository repo;

    @Autowired
    public AdminUserDetailsService(AdminUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUserEntityModel adminUserEntityModel = repo.findByUserName(username);

        if (adminUserEntityModel == null) {
            throw new UsernameNotFoundException("Admin user not found with username: '" + username + "'.");
        }

        return new AdminUserDetails(adminUserEntityModel);
    }

}
