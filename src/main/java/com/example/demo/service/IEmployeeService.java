package com.example.demo.service;

import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeDTO> getAllEmployees();
    public EmployeeDTO create(EmployeeRequest emp);
    String delete(Integer empId);
    public EmployeeDTO update(EmployeeRequest emp);
    public EmployeeDTO getEmployee(Integer empId);
    public String deleteAll();
}
