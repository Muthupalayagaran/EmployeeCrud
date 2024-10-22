package com.Oranium.EmployeeCrud.EmployeeCRUD.controller;


import com.Oranium.EmployeeCrud.EmployeeCRUD.Service.ServiceDAO;
import com.Oranium.EmployeeCrud.EmployeeCRUD.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private ServiceDAO serviceDAO;

    public EmployeeController(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @GetMapping("/list")
    public String listEmp(Model themodel)
    {
        List<Employee> theEmp=serviceDAO.findAll();

        themodel.addAttribute("employees",theEmp);
        return "list-employee";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model)
    {
        Employee emp=new Employee();

        model.addAttribute("employee",emp);

        return "employee-form";

    }

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("employeeId") int theId,Model themodel )
    {
        Employee theEmployee=serviceDAO.findById(theId);

        themodel.addAttribute("employee",theEmployee);

        return "employee-form";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee theemp)
    {
       serviceDAO.save(theemp);

       return "redirect:/employees/list";

    }

    @GetMapping("/showFormForDelete")
    public String Delete(@RequestParam("employeeId") int theId)
    {
        serviceDAO.deleteById(theId);

        return "redirect:/employees/list";
    }





}
