package com.example.addressbookapps12controllerservice.service;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import com.example.addressbookapps12controllerservice.dao.LoginDTO;
import com.example.addressbookapps12controllerservice.dao.Status;
import com.example.addressbookapps12controllerservice.model.AddressbookData;

import java.util.List;

public interface IAddressbookService {

    /***
     *
     * @return List<AddressbookData>
     */
    List<AddressbookData> getAddressbookData();

    /***
     *
     * @param id
     * @return AddressbookData
     */
    AddressbookData getAddressbookDataById(long id);

    /***
     *
     * @param addressbookDTO
     * @return AddressbookData
     */
    //AddressbookData createAddressbookData(AddressbookDTO addressbookDTO);
    Status createAddressbookData(AddressbookDTO addressbookDTO);

    /***
     *
     * @param addressbookDTO
     * @param id
     * @return AddressbookData
     */
    AddressbookData updateAddressbookDataById(AddressbookDTO addressbookDTO,long id);

    /***
     *
     * @param id
     */
    void deleteAddressbookDataById(long id);

    /***
     *
     * @param city
     * @return
     */
    List<AddressbookData> addressBookDataByCity(String city);

    /***
     *
     * @param state
     * @return
     */
    List<AddressbookData> addressbookDataByState(String state);

    Status loginUser(String email,String password);
}
