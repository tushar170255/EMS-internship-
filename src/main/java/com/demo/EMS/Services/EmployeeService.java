package com.demo.EMS.Services;

import com.demo.EMS.DTO.AddEmployeeRequest;
import com.demo.EMS.DTO.UpdateEmployeeRequest;
import com.demo.EMS.Entity.Emp;

import java.util.List;

public interface EmployeeService {

   // fetching all employee
   List<Emp> getAllEmployees();

    // fetching employee by id
    Emp getEmployee(int id);

    // inserting employee
    Emp addEmployee(AddEmployeeRequest e) ;

    // updating employee by id
    Emp updateEmployee(UpdateEmployeeRequest emp, int id);

    // deleting all employees
     Long deleteAllEmployees();

    // deleting employee by id
    Boolean deleteEmployeeByID(Long  id);

}
