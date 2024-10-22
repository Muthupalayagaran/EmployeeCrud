package com.Oranium.EmployeeCrud.EmployeeCRUD.DAO;

import com.Oranium.EmployeeCrud.EmployeeCRUD.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int Id);

    Employee save(Employee theEmployee);

    void deleteById(int Id);

}
