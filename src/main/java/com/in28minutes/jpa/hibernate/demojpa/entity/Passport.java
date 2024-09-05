package com.in28minutes.jpa.hibernate.demojpa.entity;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="number", nullable = false)
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    protected Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport {" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
