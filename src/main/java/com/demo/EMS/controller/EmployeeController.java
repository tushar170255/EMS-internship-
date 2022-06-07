package com.demo.EMS.controller;

import com.demo.EMS.DTO.*;
import com.demo.EMS.Services.EmployeeService;
import com.demo.EMS.Entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //display all employees
    @GetMapping("/employees")
    public ResponseEntity<GetAllEmployeeResponse> getAllEmployee(){

        List<Emp> allEmployees= employeeService.getAllEmployees();
        GetAllEmployeeResponse getAllEmployeeResponse=new GetAllEmployeeResponse(allEmployees,"this is the List of all the currently working employee");
        return ResponseEntity.ok(getAllEmployeeResponse);

    }

    //display employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<GetEmployeeByIdResponse> getEmployee(@PathVariable int id){
        Emp employee=employeeService.getEmployee(id);
        if(employee==null)
        {
            GetEmployeeByIdResponse getEmployeeByIdResponse=new GetEmployeeByIdResponse(employee,"No employee found for this Id");
            return ResponseEntity.ok(getEmployeeByIdResponse);
        }
        else{

            GetEmployeeByIdResponse getEmployeeByIdResponse=new GetEmployeeByIdResponse(employee,"this is the information of particular Employee");
            return ResponseEntity.ok(getEmployeeByIdResponse);

        }


    }

    //insert into employee
    @PostMapping("/employees")
    public ResponseEntity<AddEmployeeResponse> addEmployees(@RequestBody AddEmployeeRequest e){
       Emp E=employeeService.addEmployee(e);
       AddEmployeeResponse addEmployeeResponse=new AddEmployeeResponse("employee added successfully",E.getId());
       return ResponseEntity.ok(addEmployeeResponse);
    }

    //updating employee by id
    @PutMapping("/employees/{id}")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployees(@RequestBody UpdateEmployeeRequest updateEmployeeRequest, @PathVariable int id){



       Emp employee= employeeService.updateEmployee(updateEmployeeRequest,id);
        UpdateEmployeeResponse updateEmployeeResponse;
       if(employee==null)
       {
          updateEmployeeResponse=new UpdateEmployeeResponse(null,"no employee found for this id");

       }
       else{
            updateEmployeeResponse=new UpdateEmployeeResponse(employee,"employee updated successfully");
       }
      return ResponseEntity.ok(updateEmployeeResponse);
    }

    //delete all employee
    @DeleteMapping("/employees")
    public ResponseEntity<DeleteAllEmployeeResponse> deleteAllEmployees(){

        Long count=employeeService.deleteAllEmployees();
        DeleteAllEmployeeResponse deleteAllEmployeeResponse;
        if(count==0)
        {
            deleteAllEmployeeResponse=new DeleteAllEmployeeResponse(count,"Employee Table is already empty");
        }
        else{

            deleteAllEmployeeResponse=new DeleteAllEmployeeResponse(count,"all records are successfully deleted");
        }
        return ResponseEntity.ok(deleteAllEmployeeResponse);
    }

    //delete by employee id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<DeleteEmployeeByIdResponse> deleteEmployeeByID(@PathVariable Long id){
       DeleteEmployeeByIdResponse deleteEmployeeByIdResponse;
      if( employeeService.deleteEmployeeByID(id) )
      {
          deleteEmployeeByIdResponse =new DeleteEmployeeByIdResponse(" employee is successfully deleted");
      }
      else{
          deleteEmployeeByIdResponse =new DeleteEmployeeByIdResponse(" employee Not Found with given id");
      }
      return ResponseEntity.ok(deleteEmployeeByIdResponse);
    }
}
