package com.example.hibernatedemo;

import com.example.hibernatedemo.contracts.RepositoryInterface;
import com.example.hibernatedemo.dto.Employee;
import com.example.hibernatedemo.dto.EmployeeDetail;
import com.example.hibernatedemo.hibernate.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication {

    public static void main(String[] args) {
        RepositoryInterface<Employee> employeeRepository = new EmployeeRepository();
        var employeeDetails = new EmployeeDetail();
        employeeDetails.setCreditCard("ABC");
        employeeRepository.create(new Employee("Dafro", employeeDetails));
        Employee selectedEmployee = employeeRepository.get(1);
        System.out.println(selectedEmployee.getId());
        System.out.println(selectedEmployee.getName());
        var employees = employeeRepository.get();
        for (var employee :
                employees) {
            System.out.println(employee.getId());
        }

        employeeRepository.update(2, new Employee("Ahmed"));
        employeeRepository.delete(3);

        SpringApplication.run(HibernateDemoApplication.class, args);

    }

}
