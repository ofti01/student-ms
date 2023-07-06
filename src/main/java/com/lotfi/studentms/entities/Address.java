package com.lotfi.studentms.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Builder
public class Address {
    private String street;
    private String town;
    private String pays;
    private String postCode;

}
