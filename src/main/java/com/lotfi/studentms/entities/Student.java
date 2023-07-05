package com.lotfi.studentms.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends AbstractEntity{


    private String name;

    private String phone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
