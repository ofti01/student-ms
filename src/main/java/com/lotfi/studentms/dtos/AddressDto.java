package com.lotfi.studentms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AddressDto {

    private String street;
    private String town;
    private String pays;
    private String postCode;

}
