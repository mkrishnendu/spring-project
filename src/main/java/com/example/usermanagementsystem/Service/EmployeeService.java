package com.example.usermanagementsystem.Service;

import com.example.usermanagementsystem.Dto.EmployeeDTO;
import com.example.usermanagementsystem.Dto.LoginDTO;
import com.example.usermanagementsystem.response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTo);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
