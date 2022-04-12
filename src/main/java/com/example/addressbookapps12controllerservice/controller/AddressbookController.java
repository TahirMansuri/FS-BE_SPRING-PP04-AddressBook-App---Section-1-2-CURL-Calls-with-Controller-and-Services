package com.example.addressbookapps12controllerservice.controller;

import com.example.addressbookapps12controllerservice.dao.AddressBookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookservice")
public class AddressbookController {

    /***
     *
     * @return ResponseEntity<String>
     */
    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<String> getAddressbookData() {
        return new ResponseEntity<String>("Get Call to Addressbook Success.",HttpStatus.OK);
    }

    /***
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @GetMapping(value={"/getbyid/{id}"})
    public ResponseEntity<String> getAddressbookDataById(@PathVariable long id) {
        return new ResponseEntity<String>("Get Call to Addressbook for ID : "+id,HttpStatus.OK);
    }

    /***
     *
     * @param addressBookDTO
     * @return ResponseEntity<String>
     */
    @PostMapping("/create")
    public ResponseEntity<String> createAddressbookData(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<String>("Create Call for Addressbook Success. "+addressBookDTO,HttpStatus.OK);
    }

    /***
     *
     * @param addressBookDTO
     * @return ResponseEntity<String>
     */
    @PutMapping("/update")
    public ResponseEntity<String> updateAddressbookData(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<String>("Update Call for Addressbook Success. "+addressBookDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAddressbookById(@PathVariable("id") long id) {
        return new ResponseEntity<String>("Update Call for Addressbook By ID :"+id,HttpStatus.OK);
    }

    /***
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressbookData(@PathVariable("id") long id) {
        return new ResponseEntity<String>("Delete Call for Addressbook Success. "+id,HttpStatus.OK);
    }
}
