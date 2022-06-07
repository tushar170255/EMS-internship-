package com.demo.EMS.DTO;

import com.demo.EMS.Entity.Emp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeResponse {

    private Emp employee;
    private String message;



}
