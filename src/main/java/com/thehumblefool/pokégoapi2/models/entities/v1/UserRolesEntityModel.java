package com.thehumblefool.pokégoapi2.models.entities.v1;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokégoapi2.models.entities;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
///**
// *
// * @author The_Humble_Fool
// */
//@Entity
//@Table(name = "user_roles")
//public class UserRolesEntityModel implements Serializable
//{
//
//    private static final long serialVersionUID = 1L;
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//    
//    @Column(name = "user_role")
//    private String userRole;
//    
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    private UsersEntityModel userId;
//
//    public UserRolesEntityModel()
//    {
//    }
//
//    public UserRolesEntityModel(Integer id)
//    {
//        this.id = id;
//    }
//
//    public UserRolesEntityModel(Integer id, String userRole)
//    {
//        this.id = id;
//        this.userRole = userRole;
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
//    public String getUserRole()
//    {
//        return userRole;
//    }
//
//    public void setUserRole(String userRole)
//    {
//        this.userRole = userRole;
//    }
//
//    public UsersEntityModel getUserId()
//    {
//        return userId;
//    }
//
//    public void setUserId(UsersEntityModel userId)
//    {
//        this.userId = userId;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "UserRoles: {" + "id=" + id + ", userRole=" + userRole + ", userId=" + userId + '}';
//    }
//
//    
//    
//}
