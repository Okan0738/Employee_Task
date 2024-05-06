package com.okan.contoroller;

import com.okan.bootstrap.DataGenerator;
import com.okan.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class EmployeeController {

    @GetMapping("employee")
    public String createEmployee(Model model){

        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "employee/employee-create";
    }
    @PostMapping("/insert")
    public String insertEmployee(){

    }
}
