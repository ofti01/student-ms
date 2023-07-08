package com.lotfi.studentms;

import com.lotfi.studentms.controller.StudentController;
import com.lotfi.studentms.dtos.AddressDto;
import com.lotfi.studentms.dtos.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMsApplication {

    @Autowired
    StudentController studentController;
    public static void main(String[] args) {
        SpringApplication.run(StudentMsApplication.class, args);
    }


}
