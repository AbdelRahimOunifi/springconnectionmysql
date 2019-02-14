package com.insat.springconnectionmysql.demo.Data;

import com.insat.springconnectionmysql.demo.Repository.employeeRepository;
import com.insat.springconnectionmysql.demo.model.employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadData {


    @Bean
    CommandLineRunner initDataBase(employeeRepository repository){
        return args -> {
            log.info("Preloading"+ repository.save( new employee(" AbdelRahim","ounifi")));
            log.info("Preloading"+ repository.save( new employee(" Wissem","Khaskousi")));
        };
    }
}
