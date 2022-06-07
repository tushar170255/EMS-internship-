package com.demo.EMS.DTO;

import com.demo.EMS.Entity.Emp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEmployeeResponse {
  private List<Emp> allEmployees ;
  private String message;

}
