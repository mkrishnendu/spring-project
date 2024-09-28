package com.example.usermanagementsystem.Service.impl;

import com.example.usermanagementsystem.Dto.EmployeeDTO;
import com.example.usermanagementsystem.Dto.LoginDTO;
import com.example.usermanagementsystem.Entity.Employee;
import com.example.usermanagementsystem.Repo.EmployeeRepo;
import com.example.usermanagementsystem.Service.EmployeeService;
import com.example.usermanagementsystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Add this annotation to register as a Spring bean
public class EmployeeImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public String addEmployee(EmployeeDTO employeeDTo) {

        if (employeeDTo.getPassword() == null || employeeDTo.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        Employee employee = new Employee(
                employeeDTo.getEmployeeId(),
                employeeDTo.getEmployeeName(),
                employeeDTo.getEmail(),
                this.passwordEncoder.encode(employeeDTo.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());

        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password does not match", false);
            }
        } else {
            return new LoginResponse("Email does not exist", false);
        }
    }

}
