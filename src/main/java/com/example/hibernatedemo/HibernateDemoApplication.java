package com.example.hibernatedemo;

import com.example.hibernatedemo.contracts.RepositoryInterface;
import com.example.hibernatedemo.dto.Department;
import com.example.hibernatedemo.dto.Employee;
import com.example.hibernatedemo.dto.EmployeeDetail;
import com.example.hibernatedemo.hibernate.DepartmentRepository;
import com.example.hibernatedemo.hibernate.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class HibernateDemoApplication {

    public static void main(String[] args) {
        RepositoryInterface<Employee> employeeRepository = new EmployeeRepository();
        RepositoryInterface<Department> departmentRepository = new DepartmentRepository();
        var employeeDetails = new EmployeeDetail();
        var employees = new ArrayList<Employee>();

        employeeDetails.setCreditCard("ABC");
        employees.add(new Employee("mo Dafro", employeeDetails));
        var department = new Department("HR", employees);
        departmentRepository.create(department);

        employeeRepository.create(new Employee("mo eldefrawy", employeeDetails, department));
//        Employee selectedEmployee = employeeRepository.get(1);
//        System.out.println(selectedEmployee.getId());
//        System.out.println(selectedEmployee.getName());
//        var employees = employeeRepository.get();
//        for (var employee :
//                employees) {
//            System.out.println(employee.getId());
//        }

//        employeeRepository.update(2, new Employee("Ahmed"));
//        employeeRepository.delete(3);

        SpringApplication.run(HibernateDemoApplication.class, args);

    }

}
