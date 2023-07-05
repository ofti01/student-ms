package com.lotfi.studentms.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractEntity{

    private String name;
    private String phone;
    private Address address;
    private Gender gender;
}
