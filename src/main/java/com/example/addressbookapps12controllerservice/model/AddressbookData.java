package com.example.addressbookapps12controllerservice.model;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Addressbook")
//@Document(collation = "addressbook")
public class AddressbookData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * @param addressbookDTO
     */
    public void updateAddressbookData(AddressbookDTO addressbookDTO){
        this.firstname = addressbookDTO.getFirstname();
        this.lastname = addressbookDTO.getLastname();
        this.address = addressbookDTO.getAddress();
        this.city = addressbookDTO.getCity();
        this.state = addressbookDTO.getState();
        this.zip = addressbookDTO.getZip();
        this.phone = addressbookDTO.getPhone();
        this.email = addressbookDTO.getEmail();
        this.password =  addressbookDTO.getPassword();
    }

    /***
     * 
     * @param addressbookDTO
     */
    public AddressbookData(AddressbookDTO addressbookDTO){
        this.updateAddressbookData(addressbookDTO);
    }
}
