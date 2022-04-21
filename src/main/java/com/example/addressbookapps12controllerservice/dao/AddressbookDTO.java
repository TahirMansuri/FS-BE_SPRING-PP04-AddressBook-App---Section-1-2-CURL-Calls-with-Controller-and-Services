package com.example.addressbookapps12controllerservice.dao;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//@Data
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressbookDTO {

//    @Autowired
//    PasswordEncoder passwordEncoder;

    /***
     * @NotNull - firstname must be entered
     * @Pattern - regex for First Letter Capital and must contain 3 letter
     */
    @NotEmpty(message = "First Name may not be empty.")
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{2,}$",message = "First Name must be Start with Capital Letter and Contain atleast 3 Characters")
    private String firstname;

    @NotEmpty(message = "Last Name may not be empty.")
    private String lastname;

    @NotEmpty(message = "Address can not be empty.")
    private String address;

    @NotEmpty(message = "City can not be empty.")
    private String city;

    /***
     * @Pattern - regex for Specifying state must be Maharashtra or Gujrat Only
     */
    @Pattern(regexp = "Maharashtra|Gujrat", message = "State Must be within Maharashtra or Gujrat")
    private String state;

    /***
     * @Pattern - regex for Validating zipcode must be of 6 digit
     */
    @Pattern(regexp = "^[0-9]{6}$",message = "Zipcode must be only 6 Digits.")
    private String zip;

    /***
     * @Pattern - regex for Validating Phone no contain country code and 10 digit
     */
    @Pattern(regexp = "^[0-9\\s]{2}[0-9]{10}$",message = "Phone Number must contain Country Code and having 10 Digits only.")
    private String phone;

    /***
     * @Pattern - regex for Validating Email ID
     */
    @Pattern(regexp = "^[a-zA-Z0-9]+([+_.-][a-zA-Z0-9]+)*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$",message = "EMail ID is Invalid.")
    private String email;

    /***
     * @Pattern - regex for Validating Password
     */
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()<>]).{8,}$",message = "Password must contain 1 Uppercase, 1 Lowercase letter along with Special Symbol and atleast 8 character")
    private String password;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}