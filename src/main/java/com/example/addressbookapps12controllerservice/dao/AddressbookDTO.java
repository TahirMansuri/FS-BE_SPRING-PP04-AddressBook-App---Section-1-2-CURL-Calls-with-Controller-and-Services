package com.example.addressbookapps12controllerservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressbookDTO {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
}
