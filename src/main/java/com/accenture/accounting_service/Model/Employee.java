package com.accenture.accounting_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
@JsonDeserialize(builder = Employee.EmployeeBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    private String id;
    private String name;
    private String deptName;
    private String address;
    //private LocalDate joiningDate;
    private int baseSalary;
    public Employee() {
    }
    public Employee(EmployeeBuilder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.deptName=builder.deptName;
        this.address=builder.address;
        this.baseSalary=builder.baseSalary;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDeptName() {
        return deptName;
    }

    public String getAddress() {
        return address;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", address='" + address + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
    @JsonPOJOBuilder(withPrefix = "set")
    public static class EmployeeBuilder {
        protected String id;
        protected String name;
        protected String deptName;
        protected String address;
        protected int baseSalary;

        public EmployeeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setBaseSalary(int baseSalary) {
            this.baseSalary = baseSalary;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}