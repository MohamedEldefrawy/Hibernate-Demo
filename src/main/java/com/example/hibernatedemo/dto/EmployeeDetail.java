package com.example.hibernatedemo.dto;

import javax.persistence.*;

@Entity
@Table(name = "employeeDetails")
public class EmployeeDetail {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "credit_card")
    private String creditCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
