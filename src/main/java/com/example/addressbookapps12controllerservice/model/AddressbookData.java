package com.example.addressbookapps12controllerservice.model;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressbookData {
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String password;

    /***
     *
     * @param id
     * @param addressbookDTO
     */
    public AddressbookData(long id, AddressbookDTO addressbookDTO){
        this.id = id;
        this.firstname = addressbookDTO.getFirstname();
        this.lastname = addressbookDTO.getLastname();
        this.address = addressbookDTO.getAddress();
        this.city = addressbookDTO.getCity();
        this.state = addressbookDTO.getState();
        this.zip = addressbookDTO.getZip();
        this.phone = addressbookDTO.getPhone();
        this.email = addressbookDTO.getEmail();
        this.password = addressbookDTO.getPassword();
    }
}
