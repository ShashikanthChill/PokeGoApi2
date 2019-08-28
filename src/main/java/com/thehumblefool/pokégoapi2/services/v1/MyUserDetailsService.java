package com.thehumblefool.pokégoapi2.services.v1;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokegoapi2.services;
//
//import com.the_humble_fool.PokeGoApi.UserDetailsImpl;
//import com.the_humble_fool.PokeGoApi.jparepositories.UsersRepo;
//import com.thehumblefool.pokegoapi2.models.entitymodels.UsersEntityModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author The_Humble_Fool
// */
//@Service
//public class MyUserDetailsService implements UserDetailsService
//{
//
//    @Autowired
//    UsersRepo repo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//    {
//        UsersEntityModel user = repo.findByUsername(username);
//
//        if (user == null) {
//            System.out.println("User not found");
//            throw new UsernameNotFoundException("User with name: " + username + " not found.");
//        }
//
//        return new UserDetailsImpl(user);
//    }
//
//}
