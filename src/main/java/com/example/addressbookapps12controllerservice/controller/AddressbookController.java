package com.example.addressbookapps12controllerservice.controller;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import com.example.addressbookapps12controllerservice.dao.ResponseDTO;
import com.example.addressbookapps12controllerservice.model.AddressbookData;
import com.example.addressbookapps12controllerservice.service.IAddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        List<AddressbookData> addressbookDataList = null;
        addressbookDataList = addressbookService.getAddressbookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Addressbook App.",addressbookDataList);
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
        addressbookData = addressbookService.getAddressbookDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Addressbook by ID "+id,addressbookData);
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
        addressbookData = addressbookService.createAddressbookData(addressBookDTO);
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
        addressbookData = addressbookService.updateAddressbookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Put Call for Addressbook Success.",addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/updatebyid/{id}")
    public ResponseEntity<ResponseDTO> updateAddressbookById(@RequestBody AddressbookDTO addressbookDTO,@PathVariable("id") long id) {
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
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("id") long id) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(id,new AddressbookDTO("Tahir","Mansuri","Siddhi Vinayak Nagar","Shahada","MH","425409","7030820545","tahir@gmail.com"));
        ResponseDTO responseDTO = new ResponseDTO("Delete Call for Addressbook Success for ID :"+id,addressbookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
