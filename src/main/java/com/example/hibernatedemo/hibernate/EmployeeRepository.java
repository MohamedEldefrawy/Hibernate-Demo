package com.example.hibernatedemo.hibernate;

import com.example.hibernatedemo.contracts.RepositoryInterface;
import com.example.hibernatedemo.dto.Department;
import com.example.hibernatedemo.dto.Employee;
import com.example.hibernatedemo.dto.EmployeeDetail;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements RepositoryInterface<Employee> {


    @Override
    public void create(Employee entity) {
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
    public Employee get(int id) {
        Session session = getSession();
        try {
            session.beginTransaction();
            var selectedEmployee = session.get(Employee.class, id);
            session.getTransaction().commit();
            session.close();
            return selectedEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        }
    }

    @Override
    public List<Employee> get() {
        Session session = getSession();
        try {
            session.beginTransaction();
            var employees = session.createQuery("from Employee").list();
            session.getTransaction().commit();
            session.close();
            return employees;

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        }
    }

    @Override
    public void update(int id, Employee entity) {
        Session session = getSession();
        try {
            session.beginTransaction();
            var selectedEmployee = session.get(Employee.class, id);
            selectedEmployee.setName(entity.getName());
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = getSession();
        try {
            session.beginTransaction();
            var selectedEmployee = session.get(Employee.class, id);
            session.delete(selectedEmployee);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
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
