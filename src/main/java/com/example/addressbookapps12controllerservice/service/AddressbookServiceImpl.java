package com.example.addressbookapps12controllerservice.service;

import com.example.addressbookapps12controllerservice.dao.AddressbookDTO;
import com.example.addressbookapps12controllerservice.model.AddressbookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressbookServiceImpl implements IAddressbookService{

    /***
     *
     * @return List<AddressbookData>
     **/
    @Override
    public List<AddressbookData> getAddressbookData() {
        List<AddressbookData> addressbookDataList = new ArrayList<>();
        addressbookDataList.add(new AddressbookData(1,new AddressbookDTO("Tahir","Mansuri","Siddhi Vinayak Nagar","Shahada","MH","425409","7030820545","tahir@gmail.com")));
        return addressbookDataList;
    }

    /***
     *
     * @param id
     * @return addressbookData
     */
    @Override
    public AddressbookData getAddressbookDataById(long id) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(id,new AddressbookDTO("Tahir","Mansuri","Siddhi Vinayak Nagar","Shahada","MH","425409","7030820545","tahir@gmail.com"));
        return addressbookData;
    }

    /***
     *
     * @param addressbookDTO
     * @return addressbookData
     */
    @Override
    public AddressbookData createAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(1,addressbookDTO);
        return addressbookData;
    }

    /***
     *
     * @param addressbookDTO
     * @return addressbookData
     */
    @Override
    public AddressbookData updateAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(1,addressbookDTO);
        return addressbookData;
    }

    /***
     *
     * @param addressbookDTO
     * @param id
     * @return addressbookData
     */
    @Override
    public AddressbookData updateAddressbookDataById(AddressbookDTO addressbookDTO, long id) {
        AddressbookData addressbookData = null;
        addressbookData = new AddressbookData(id,addressbookDTO);
        return addressbookData;
    }

    @Override
    public void deleteAddressbookData() {

    }

    @Override
    public void deleteAddressbookDataById(long id) {

    }
}
