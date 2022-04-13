package com.example.addressbookapps12controllerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AddressBookAppS12ControllerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppS12ControllerServiceApplication.class, args);
        log.info("Addressbook App Service is Started.");
    }

}
