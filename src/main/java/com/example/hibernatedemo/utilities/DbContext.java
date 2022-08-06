package com.example.hibernatedemo.utilities;

import com.example.hibernatedemo.dto.Department;
import com.example.hibernatedemo.dto.Employee;
import com.example.hibernatedemo.dto.EmployeeDetail;
import com.example.hibernatedemo.dto.Team;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class DbContext {
    public static Session getSession() {
        var sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeDetail.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Team.class)
                .buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
