package com.example.addressbookapps12controllerservice.controller;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import com.example.addressbookapps12controllerservice.dao.LoginDTO;
import com.example.addressbookapps12controllerservice.dao.ResponseDTO;
import com.example.addressbookapps12controllerservice.dao.Status;
import com.example.addressbookapps12controllerservice.model.AddressbookData;
import com.example.addressbookapps12controllerservice.service.IAddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbookservice")
public class AddressbookController {

    @Autowired
    IAddressbookService addressbookService;

    /***
     *
     * @return ResponseEntity<String>
     */
    @RequestMapping(value={"/get"})
    public ResponseEntity<?> getAddressbookData() {
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressbookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Addressbook App.",addressbookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        //return ResponseEntity.ok(addressbookDataList);
    }

    /***
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @GetMapping(value={"/getbyid/{id}"})
    public ResponseEntity<ResponseDTO> getAddressbookDataById(@PathVariable long id) {
        AddressbookData addressbookData = null;
        addressbookData = addressbookService.getAddressbookDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Addressbook by ID "+id,addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param addressBookDTO
     * @return ResponseEntity<String>
     */
//    @PostMapping("/user/register")
//    public ResponseEntity<?> createAddressbookData(@Valid @RequestBody AddressbookDTO addressBookDTO) {
//        AddressbookData addressbookData = null;
//        addressbookData = addressbookService.createAddressbookData(addressBookDTO);
//        ResponseDTO responseDTO = new ResponseDTO("Post Call for Addressbook Success.",addressbookData);
//        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
//    }

    @PostMapping("/user/register")
    public ResponseEntity<?> createAddressbookData(@Valid @RequestBody AddressbookDTO addressBookDTO) {
        Status status = addressbookService.createAddressbookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Post Call for Register : ",status);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        Status status = addressbookService.loginUser(loginDTO.getEmail(),loginDTO.getPassword());
        ResponseDTO responseDTO = new ResponseDTO("Call for User Login : ",status);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/updatebyid/{id}")
    public ResponseEntity<ResponseDTO> updateAddressbookById(@Valid @RequestBody AddressbookDTO addressbookDTO,@PathVariable("id") long id) {
        AddressbookData addressbookData = null;
        addressbookData = addressbookService.updateAddressbookDataById(addressbookDTO,id);
        ResponseDTO responseDTO = new ResponseDTO("Update by ID call for Addressbook Success.",addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressbookData(@PathVariable("id") long id) {
        addressbookService.deleteAddressbookDataById(id);
        return new ResponseEntity<String>("Address Book with ID "+id+" is Deleted",HttpStatus.OK);
    }

    /***
     *
     * @param city
     * @return
     */
    @GetMapping("/getbycity/{city}")
    public ResponseEntity<ResponseDTO> getAddressbookByCity(@PathVariable("city") String city) {
        List<AddressbookData> addressbookDataList = addressbookService.addressBookDataByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Call for Get by City Success",addressbookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     * 
     * @param state
     * @return
     */
    @GetMapping("/getbystate/{state}")
    public ResponseEntity<ResponseDTO> getAddressbookByState(@PathVariable("state") String state) {
        List<AddressbookData> addressbookDataList = addressbookService.addressbookDataByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Call for Get By State Success",addressbookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/tokenlogin")
    public ResponseEntity<ResponseDTO> loginWithToken(@RequestBody LoginDTO loginDTO){
        ResponseDTO response = new ResponseDTO( addressbookService.loginWithToken(loginDTO.getEmail(),loginDTO.getPassword()),"OTP Sent to your Email ID");
        return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
    }
}