package com.example.addressbookapps12controllerservice.service;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import com.example.addressbookapps12controllerservice.dao.LoginDTO;
import com.example.addressbookapps12controllerservice.dao.Status;
import com.example.addressbookapps12controllerservice.exception.AddressbookException;
import com.example.addressbookapps12controllerservice.model.AddressbookData;
import com.example.addressbookapps12controllerservice.repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressbookServiceImpl implements IAddressbookService{

    @Autowired
    AddressbookRepository addressbookRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    /***
     * Service method for Getting All Addressbook Data from DM
     * @return List<AddressbookData>
     **/
    @Override
    public List<AddressbookData> getAddressbookData() {
        return addressbookRepository.findAll();
    }

    /***
     * Service method for Getting Addressbook Data by ID
     * @param id
     * @return addressbookData
     */
    @Override
    public AddressbookData getAddressbookDataById(long id) {
        return addressbookRepository.findById(id).orElseThrow(() -> new AddressbookException("Employee with ID :"+id+" not found."));
    }

    /***
     * Service method to Add / Create Addressbook Data in DB
     * @param addressbookDTO
     * @return addressbookData
     */
    @Override
    public Status createAddressbookData(AddressbookDTO addressbookDTO) {

        AddressbookData addressbookData = new AddressbookData(addressbookDTO);

        boolean isExist = this.getAddressbookData().stream().filter(data -> data.getEmail().equalsIgnoreCase(addressbookDTO.getEmail())).findFirst().isPresent();

        if(isExist) {
            return Status.USER_ALREADY_EXISTS;
        } else {
            addressbookRepository.save(addressbookData);
            return Status.SUCCESS;
        }
    }

    /***
     * Service method for Updating Addressbook Data By ID
     * @param addressbookDTO
     * @param id
     * @return addressbookData
     */
    @Override
    public AddressbookData updateAddressbookDataById(AddressbookDTO addressbookDTO, long id) {
        AddressbookData addressbookData = this.getAddressbookDataById(id);
        addressbookData.updateAddressbookData(addressbookDTO);
        return addressbookRepository.save(addressbookData);
    }

    /***
     * Service method to Delete Addressbook by ID
     * @param id
     */
    @Override
    public void deleteAddressbookDataById(long id) {
        AddressbookData addressbookData = this.getAddressbookDataById(id);
        addressbookRepository.delete(addressbookData);
    }

    /***
     * Custom Service method to get addressbook data by City
     * @param city
     * @return
     */
    @Override
    public List<AddressbookData> addressBookDataByCity(String city) {
        return addressbookRepository.findAddressbookDataByCity(city);
    }

    /***
     * Custom Service method to get addressbook data by State
     * @param state
     * @return
     */
    @Override
    public List<AddressbookData> addressbookDataByState(String state) {
        return addressbookRepository.findAddressbookDataByState(state);
    }

    @Override
    public Status loginUser(String email,String password) {
        if(addressbookRepository.existsByEmailAndPassword(email,password)) {
            return Status.SUCCESS;
        } else {
            return Status.FAILURE;
        }
    }

}