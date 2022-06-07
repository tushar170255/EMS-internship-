package com.demo.EMS.Repository;

import com.demo.EMS.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Emp,Integer> {
}
