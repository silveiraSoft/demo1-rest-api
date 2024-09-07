package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.EmployeeDTO;
import com.example.demo.service.IEmployeeService;
import com.example.demo.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository repository;

    /**
     *
     * @return
     */
    public List<EmployeeDTO> getAllEmployees() {
        return repository.listarTodosEmpleado().stream().map(Utility::mapToEmployeeDTO).toList();
        //return repository.findAll().stream().map(Utility::mapToEmployeeDTO).toList();
    }

    /**
     *
     * @param emp
     * @return
     */
    public EmployeeDTO create(EmployeeRequest emp) {
        Employee employee = Employee.builder().name(emp.getName()).address(emp.getAddress()).build();
		return Utility.mapToEmployeeDTO(repository.save(employee));
    }

    /**
     *
     * @param empId
     * @return
     */
    public String delete(Integer empId) {
        Employee employee = repository.findById(empId).orElseThrow(() -> Utility.notFound(empId));
        repository.delete(employee);
        return "Employee with id=" + empId + " removed";
    }

    /**
     *
     * @return
     */
    public String deleteAll() {
        List<Employee> employees = repository.findAll();
        if (employees.isEmpty())
            return "No employees available";
        repository.deleteAll();
        return "All employees are removed.";
    }

    /**
     *
     * @param empId
     * @return
     */
    public EmployeeDTO getEmployee(Integer empId) {
		Employee employee = repository.findById(empId).orElseThrow(() -> Utility.notFound(empId));
		return Utility.mapToEmployeeDTO(employee);
    }

    /**
     *
     * @param emp
     * @return
     */
    public EmployeeDTO update(EmployeeRequest emp) {
        Employee employee = repository.findById(emp.getId()).orElseThrow(() -> Utility.notFound(emp.getId()));
        employee.setId(emp.getId());
        employee.setName(emp.getName());
        employee.setAddress(emp.getAddress());
		return Utility.mapToEmployeeDTO(repository.save(employee));
    }
}
