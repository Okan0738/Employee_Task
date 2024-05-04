package com.okan.contoroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class EmployeeController {

    @GetMapping("employee")
    public String createEmployee(){
        return "employee/employee-create";
    }
}
