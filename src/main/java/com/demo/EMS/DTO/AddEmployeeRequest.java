package com.demo.EMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddEmployeeRequest {

    private String firstName;
    private String LastName;
    private String email;
}
