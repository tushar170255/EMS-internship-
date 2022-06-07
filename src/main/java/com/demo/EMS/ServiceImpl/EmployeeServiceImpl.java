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
//       System.out.println(e.getFirstName());
//        return e;
    }

    public Emp addEmployee(AddEmployeeRequest e){

     Emp x= new Emp(e.getFirstName(),e.getLastName(),e.getEmail());
     return employeeRepo.save(x);

    }

    public Emp updateEmployee(UpdateEmployeeRequest emp , int  id ) {

//        employeeRepo.findById(id).ifPresent(user -> user.setFirstName(emp.getFirstName()));
//        employeeRepo.findById(id).ifPresent(user -> user.setLastName(emp.getLastName()));
//        employeeRepo.findById(id).ifPresent(user -> user.setEmail(emp.getEmail()));
//        return employeeRepo.findById(id).orElse(null);





      Emp employee= employeeRepo.findById(id).orElse(null);
    if(employee==null){
        return  employee;
    }
    else{


        employee.setFirstName(emp.getFirstName());
        employee.setEmail(emp.getEmail());
        employee.setLastName(emp.getLastName());
        employeeRepo.save(employee);
        return employee;
    }

    }

    public int  deleteAllEmployees(){
        int  count= (int) employeeRepo.count();
        employeeRepo.deleteAll();
        return count;
    }

    public Boolean deleteEmployeeByID(int  id){
        Emp e=employeeRepo.findById(id).orElse(null);
        if(e==null)
        {

            return false;
        }
        else{
            employeeRepo.deleteById(id);
            return true;
        }

    }
    @Override
    public List<Emp> getAllEmployeeByName( String name)
    {
        List<Emp> e= employeeRepo.findAllByFirstName(name);
        return e;
    }
}
