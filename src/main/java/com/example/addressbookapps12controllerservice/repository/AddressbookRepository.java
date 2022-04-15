package com.example.addressbookapps12controllerservice.repository;

import com.example.addressbookapps12controllerservice.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressbookRepository extends JpaRepository<AddressbookData, Long> {
}
