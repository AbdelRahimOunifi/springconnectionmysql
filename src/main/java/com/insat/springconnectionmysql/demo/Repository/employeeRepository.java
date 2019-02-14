package com.insat.springconnectionmysql.demo.Repository;

import com.insat.springconnectionmysql.demo.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<employee,Long> {
}
