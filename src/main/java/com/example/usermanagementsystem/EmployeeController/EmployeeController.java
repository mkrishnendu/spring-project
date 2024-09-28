package com.example.usermanagementsystem.EmployeeController;

import com.example.usermanagementsystem.Dto.EmployeeDTO;
import com.example.usermanagementsystem.Dto.LoginDTO;
import com.example.usermanagementsystem.Service.EmployeeService;
import com.example.usermanagementsystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        String id = employeeService.addEmployee(employeeDTO);
        System.out.println(id);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);

        return ResponseEntity.ok(loginResponse);  // Return the actual login response
    }





}