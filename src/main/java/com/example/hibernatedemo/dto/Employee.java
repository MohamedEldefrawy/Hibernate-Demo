package com.example.hibernatedemo.dto;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_details_id")
    private EmployeeDetail employeeDetail;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public Employee(String name, EmployeeDetail employeeDetail, Department department) {
        this.name = name;
        this.employeeDetail = employeeDetail;
        this.department = department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public Employee(String name, EmployeeDetail employeeDetail) {
        this.name = name;
        this.employeeDetail = employeeDetail;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
