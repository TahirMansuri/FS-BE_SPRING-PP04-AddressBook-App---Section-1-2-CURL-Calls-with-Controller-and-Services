package com.example.addressbookapps12controllerservice.controller;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import com.example.addressbookapps12controllerservice.dao.ResponseDTO;
import com.example.addressbookapps12controllerservice.model.AddressbookData;
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
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(1,new AddressbookDTO("Tahir","Mansuri"));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Addressbook App.",addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @GetMapping(value={"/getbyid/{id}"})
    public ResponseEntity<ResponseDTO> getAddressbookDataById(@PathVariable long id) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(id,new AddressbookDTO("Sandesh","Marathe"));
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Addrressbook by ID "+id,addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param addressBookDTO
     * @return ResponseEntity<String>
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressbookData(@RequestBody AddressbookDTO addressBookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(1,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Post Call for Addressbook Success.",addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param addressBookDTO
     * @return ResponseEntity<String>
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@RequestBody AddressbookDTO addressBookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(1,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Put Call for Addressbook Success.",addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/updatebyid/{id}")
    public ResponseEntity<ResponseDTO> updateAddressbookById(@RequestBody AddressbookDTO addressbookDTO,@PathVariable("id") long id) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(id,addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update by ID call for Addressbook Success.",addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("id") long id) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(id,new AddressbookDTO("Tahir","Mansuri"));
        ResponseDTO responseDTO = new ResponseDTO("Delete Call for Addressbook Success for ID :"+id,addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
