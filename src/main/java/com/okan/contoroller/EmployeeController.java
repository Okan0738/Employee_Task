package com.okan.contoroller;

import com.okan.bootstrap.DataGenerator;
import com.okan.model.Employee;
import com.okan.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employee")
    public String createEmployee(Model model){

        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "employee/employee-create";
    }
    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";
        }

        employeeService.saveEmployee(employee);
        model.addAttribute("employeeList", employeeService.readAllEmployees());

    return "employee/employee-list";

    }
    @GetMapping("/list")
    public String listEmployee(Model model){
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "employee/employee-list";
    }
}
