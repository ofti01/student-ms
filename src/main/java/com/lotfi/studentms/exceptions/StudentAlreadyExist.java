package com.lotfi.studentms.exceptions;


public class StudentAlreadyExist extends RuntimeException {

    public StudentAlreadyExist(String message) {
        super(message);
    }
}
