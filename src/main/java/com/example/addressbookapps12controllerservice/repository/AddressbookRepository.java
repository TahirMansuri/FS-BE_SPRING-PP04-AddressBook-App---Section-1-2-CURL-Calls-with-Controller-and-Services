package com.example.addressbookapps12controllerservice.repository;

import com.example.addressbookapps12controllerservice.dao.LoginDTO;
import com.example.addressbookapps12controllerservice.dao.Status;
import com.example.addressbookapps12controllerservice.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressbookRepository extends JpaRepository<AddressbookData, Long> {
//    public interface AddressbookRepository extends MongoRepository<AddressbookData, Long> {

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

    @Query(value = "select * from addressbook where email = :email and password = :password",nativeQuery = true)
    Status findUserLogin(String email, String password);

    boolean existsByEmailAndPassword(String email,String password);
}
