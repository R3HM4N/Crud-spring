package com.orient.springcrud.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@AllArgsConstructor
//@Data
//@NoArgsConstructor
//@ToString
public class AccountLm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
