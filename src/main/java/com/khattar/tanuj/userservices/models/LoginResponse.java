package com.khattar.tanuj.userservices.models;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean isLoggedIn;
    private String reason;
}
