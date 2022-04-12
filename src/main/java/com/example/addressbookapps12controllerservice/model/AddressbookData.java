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

    /***
     *
     * @param id
     * @param addressbookDTO
     */
    public AddressbookData(long id, AddressbookDTO addressbookDTO){
        this.id = id;
        this.firstname = addressbookDTO.getFirstname();
        this.lastname = addressbookDTO.getLastname();
    }
}
