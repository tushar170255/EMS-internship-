package com.demo.EMS.ServiceImpl;

import com.demo.EMS.DTO.AddEmployeeRequest;
import com.demo.EMS.DTO.UpdateEmployeeRequest;
import com.demo.EMS.Repository.EmployeeRepo;
import com.demo.EMS.Services.EmployeeService;
import com.demo.EMS.Entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Emp> getAllEmployees() {
        List<Emp> emps = (List<Emp>) employeeRepo.findAll();
        return emps;
    }
    public Emp getEmployee(int id){

        return employeeRepo.findById(id).orElse(null) ;
    }

    public Emp addEmployee(AddEmployeeRequest e){

     Emp x= new Emp(e.getFirstName(),e.getLastName(),e.getEmail());
     return employeeRepo.save(x);

    }

    public Emp updateEmployee(UpdateEmployeeRequest emp , int id ) {

        employeeRepo.findById(id).ifPresent(user -> user.setFirstName(emp.getFirstName()));
        employeeRepo.findById(id).ifPresent(user -> user.setLastName(emp.getLastName()));
        employeeRepo.findById(id).ifPresent(user -> user.setEmail(emp.getEmail()));
        return employeeRepo.findById(id).orElse(null);





//      Optional<Emp> employee= employeeRepo.findById(id);
//    if(employee==null){
//        return  employee;
//    }
//    else{
//
//
//        employee.setFirstName()
//
//    }

    }

    public Long deleteAllEmployees(){
        Long count=employeeRepo.count();
        employeeRepo.deleteAll();
        return count;
    }

    public Boolean deleteEmployeeByID(Long id){
        Optional<Emp> e=employeeRepo.findById(Math.toIntExact(id));
        if(e==null)
        {

            return false;
        }
        else{
            employeeRepo.deleteById(Math.toIntExact(id));
            return true;
        }

    }
}
