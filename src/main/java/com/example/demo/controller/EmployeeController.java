package com.example.demo.controller;

import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.EmployeeDTO;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {
    @Autowired
    private IEmployeeService empoyeeService;

    @GetMapping(value = "/employees")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<EmployeeDTO> employees() {
        return empoyeeService.getAllEmployees();
    }

    @GetMapping(value = "/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    public EmployeeDTO employee(@PathVariable(value = "id") Integer empId) {
        return empoyeeService.getEmployee(empId);
    }

    @PostMapping(value = "/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO save(@RequestBody EmployeeRequest emp) {
        return empoyeeService.create(emp);
    }

    @DeleteMapping(value = "/employees")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAll() {
        return empoyeeService.deleteAll();
    }

    @DeleteMapping(value = "/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value = "id") Integer empId) {
        return empoyeeService.delete(empId);
    }

    @PutMapping(value = "/employees")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO update(@RequestBody EmployeeRequest emp) {
        return empoyeeService.update(emp);
    }
}
