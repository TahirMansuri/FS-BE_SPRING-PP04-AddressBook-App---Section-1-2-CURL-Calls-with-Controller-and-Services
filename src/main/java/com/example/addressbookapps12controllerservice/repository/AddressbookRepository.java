package com.example.addressbookapps12controllerservice.repository;

import com.example.addressbookapps12controllerservice.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressbookRepository extends JpaRepository<AddressbookData, Long> {

    /***
     * Custom Query to get addressbook data by city
     * @param city
     * @return
     */
    @Query(value = "select * from addressbook where city = :city",nativeQuery = true)
    List<AddressbookData> findAddressbookDataByCity(String city);

    /***
     * Custom Query to get addressbook data by state
     * @param state
     * @return
     */
    @Query(value = "select * from addressbook where state = :state",nativeQuery = true)
    List<AddressbookData> findAddressbookDataByState(String state);
}
