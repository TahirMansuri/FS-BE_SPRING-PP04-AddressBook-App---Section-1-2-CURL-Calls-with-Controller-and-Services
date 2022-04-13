package com.example.addressbookapps12controllerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookAppS12ControllerServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(AddressBookAppS12ControllerServiceApplication.class, args);
        /***
         * Getting Active Logging Profile using context
         */
        log.info("Addressbook App Service is Started in {} Environment.",context.getEnvironment().getActiveProfiles());

        /***
         * Getting DB Username using Environment
         */
        log.info("Addressbook App Database User is {}.",context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
