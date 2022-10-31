package com.khattar.tanuj.userservices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String password;
    private String age;
    private String email;
    private String city;
    private boolean isLoggedIn;

}
