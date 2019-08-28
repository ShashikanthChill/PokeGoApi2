package com.thehumblefool.pokégoapi2.models.entities.v1;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokégoapi2.models.entities;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
///**
// *
// * @author The_Humble_Fool
// */
//@Entity
//@Table(name = "users")
//public class UsersEntityModel implements Serializable
//{
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//    
//    @Column(name = "username")
//    private String username;
//    
//    @Column(name = "password")
//    private String password;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
//    private List<UserRolesEntityModel> userRolesList;
//
//    public UsersEntityModel()
//    {
//    }
//
//    public UsersEntityModel(Integer id)
//    {
//        this.id = id;
//    }
//
//    public UsersEntityModel(Integer id, String username, String password)
//    {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//    }
//
//    public Integer getId()
//    {
//        return id;
//    }
//
//    public void setId(Integer id)
//    {
//        this.id = id;
//    }
//
//    public String getUsername()
//    {
//        return username;
//    }
//
//    public void setUsername(String username)
//    {
//        this.username = username;
//    }
//
//    public String getPassword()
//    {
//        return password;
//    }
//
//    public void setPassword(String password)
//    {
//        this.password = password;
//    }
//
//    public List<UserRolesEntityModel> getUserRolesList()
//    {
//        return userRolesList;
//    }
//
//    public void setUserRolesList(List<UserRolesEntityModel> userRolesList)
//    {
//        this.userRolesList = userRolesList;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
//    }
//}
