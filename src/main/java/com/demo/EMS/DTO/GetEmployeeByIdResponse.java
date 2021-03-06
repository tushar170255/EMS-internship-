package com.demo.EMS.DTO;

import com.demo.EMS.Entity.Emp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeByIdResponse {
    private Emp employee;
    private String message;
}
