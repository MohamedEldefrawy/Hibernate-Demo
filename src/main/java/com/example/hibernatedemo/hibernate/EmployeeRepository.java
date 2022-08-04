package com.example.hibernatedemo.hibernate;

import com.example.hibernatedemo.contracts.RepositoryInterface;
import com.example.hibernatedemo.dto.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements RepositoryInterface<Employee> {


    @Override
    public void create(Employee entity) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction();

        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            sessionFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.close();
        }
    }

    @Override
    public Employee get(int id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            var selectedEmployee = session.get(Employee.class, id);
            session.getTransaction().commit();
            sessionFactory.close();
            return selectedEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.close();
            return null;
        }
    }

    @Override
    public List<Employee> get() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            var employees = session.createQuery("from Employee").list();
            session.getTransaction().commit();
            sessionFactory.close();
            return employees;

        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.close();
            return null;
        }
    }

    @Override
    public void update(int id, Employee entity) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            var selectedEmployee = session.get(Employee.class, id);
            selectedEmployee.setName(entity.getName());
            session.getTransaction().commit();
            sessionFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.close();
        }
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            var selectedEmployee = session.get(Employee.class, id);
            session.delete(selectedEmployee);
            session.getTransaction().commit();
            sessionFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.close();
        }
    }
}
