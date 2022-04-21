package com.example.addressbookapps12controllerservice.dao;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {

    @NotEmpty(message = "Please Enter the Username.")
    private String email;

    @NotEmpty(message = "Please Enter the Password.")
    private String password;

}
