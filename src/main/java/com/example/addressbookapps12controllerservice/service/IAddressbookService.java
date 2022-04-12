package com.example.addressbookapps12controllerservice.service;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
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
    AddressbookData createAddressbookData(AddressbookDTO addressbookDTO);

    /***
     *
     * @param addressbookDTO
     * @return AddressbookData
     */
    AddressbookData updateAddressbookData(AddressbookDTO addressbookDTO);

    /***
     *
     * @param addressbookDTO
     * @param id
     * @return AddressbookData
     */
    AddressbookData updateAddressbookDataById(AddressbookDTO addressbookDTO,long id);

    void deleteAddressbookData();

    void deleteAddressbookDataById(long id);
}
