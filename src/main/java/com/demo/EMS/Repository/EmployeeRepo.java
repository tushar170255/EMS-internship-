package com.demo.EMS.Repository;

import com.demo.EMS.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Emp,Integer> {

    List<Emp> findAllByFirstName(String name);





}
