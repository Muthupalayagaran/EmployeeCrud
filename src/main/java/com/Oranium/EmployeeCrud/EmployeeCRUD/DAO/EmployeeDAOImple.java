package com.Oranium.EmployeeCrud.EmployeeCRUD.DAO;

import com.Oranium.EmployeeCrud.EmployeeCRUD.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImple implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee>  Emp=entityManager.createQuery("FROM Employee", Employee.class);
        return Emp.getResultList();
    }

    @Override
    public Employee findById(int Id) {
        return entityManager.find(Employee.class,Id);
    }

    @Override
    public Employee save(Employee theEmployee)
    {

        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int Id) {

        Employee theEmp=entityManager.find(Employee.class,Id);

        entityManager.remove(theEmp);

    }


}
