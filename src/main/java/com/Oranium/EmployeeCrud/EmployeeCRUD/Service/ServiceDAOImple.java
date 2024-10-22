package com.Oranium.EmployeeCrud.EmployeeCRUD.Service;

import com.Oranium.EmployeeCrud.EmployeeCRUD.DAO.EmployeeDAO;
import com.Oranium.EmployeeCrud.EmployeeCRUD.model.Employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDAOImple implements ServiceDAO{

    private EmployeeDAO employeeDAO;

    @Autowired
    public ServiceDAOImple(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int Id) {
        return employeeDAO.findById(Id);
    }


    @Transactional
    @Override
    public Employee save(Employee theEmp) {
        return employeeDAO.save(theEmp);
    }



    @Transactional
    @Override
    public void deleteById(int Id) {
        employeeDAO.deleteById(Id);
    }

}
