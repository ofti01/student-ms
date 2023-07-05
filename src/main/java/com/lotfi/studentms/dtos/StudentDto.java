package com.lotfi.studentms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentDto {

    private long id;

    private String name;

    private String phone;

    private AddressDto addressDto;

    private String gender;
}
