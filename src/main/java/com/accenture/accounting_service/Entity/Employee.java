package com.accenture.accounting_service.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    @Id
    private String id;
    private String name;
    private String deptName;
    private String address;
    //private LocalDate joiningDate;
    private int baseSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Employee() {
        super();
    }

    public Employee(String id, String name, String deptName, String address, int baseSalary) {
        super();
        this.id = id;
        this.name = name;
        this.deptName = deptName;
        this.address = address;
        this.baseSalary = baseSalary;
    }

}
