package com.Oranium.EmployeeCrud.EmployeeCRUD.Service;

import com.Oranium.EmployeeCrud.EmployeeCRUD.model.Employee;

import java.util.List;

public interface ServiceDAO {
    List<Employee> findAll();
    Employee findById(int Id);

    Employee save(Employee theEmp);

    void deleteById(int Id);

}
