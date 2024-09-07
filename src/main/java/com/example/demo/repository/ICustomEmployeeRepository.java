package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.response.EmployeeDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomEmployeeRepository {
    @Query(
            nativeQuery = true,
            value
                    = "SELECT emp.empid, emp.address, emp.ename FROM employee_tbl emp")
    public List<Employee> listarTodosEmpleado();
}
