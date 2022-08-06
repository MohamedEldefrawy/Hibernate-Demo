package com.example.hibernatedemo.hibernate;

import com.example.hibernatedemo.contracts.RepositoryInterface;
import com.example.hibernatedemo.dto.Department;
import com.example.hibernatedemo.dto.Employee;
import com.example.hibernatedemo.dto.EmployeeDetail;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DepartmentRepository implements RepositoryInterface<Department> {
    @Override
    public void create(Department entity) {
        Session session = getSession();
        session.getTransaction();

        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
    }

    @Override
    public Department get(int id) {
        return null;
    }

    @Override
    public List<Department> get() {
        return null;
    }

    @Override
    public void update(int id, Department entity) {

    }

    @Override
    public void delete(int id) {

    }

    private static Session getSession() {
        var sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeDetail.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
}
