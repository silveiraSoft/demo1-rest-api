package com.example.demo.util;

import com.example.demo.entity.Employee;
import com.example.demo.response.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

@Slf4j
public class Utility {
    private Utility() {
    }

    public static NoSuchElementException notFound(Integer empId) {
        log.error("Employee with id=" + empId + " not found.");
        return new NoSuchElementException("Employee with id=" + empId + " not found.");
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee emp) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder().id(emp.getId()).name(emp.getName()).address(emp.getAddress())
                .build();

        log.info("Employee details : {}", employeeDTO);
        return employeeDTO;
    }

}
