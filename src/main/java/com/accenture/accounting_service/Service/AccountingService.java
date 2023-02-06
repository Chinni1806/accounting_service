package com.accenture.accounting_service.Service;

import com.accenture.accounting_service.Model.Employee;
import com.accenture.accounting_service.Model.EmployeeSalary;
import com.accenture.accounting_service.Model.Salary;
import com.accenture.accounting_service.Model.WorkHourReq;
import com.accenture.accounting_service.Proxy.EmployeeServiceProxy;
import com.accenture.accounting_service.Proxy.WorkhourServiceProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountingService {
    @Autowired
    EmployeeServiceProxy empProxy;
    @Autowired
    WorkhourServiceProxy workhourProxy;

    public Salary calculateSalary(EmployeeSalary emp) {
        Optional<Employee> employee=empProxy.getEmployee(emp.getEmpId());
        WorkHourReq empLeave=workhourProxy.getEmployeeLeaveByEmpIdAndYearMonth(emp.getEmpId(),emp.getYearMonth());
        int baseSalary=employee.orElseThrow().getBaseSalary();
        int leaveCount= empLeave.getCount();
        int noOfDays=empLeave.getDays();
        int salary=baseSalary*(noOfDays-leaveCount)/noOfDays;
        return new Salary
                .SalaryBuilder()
                .setYearMonth(emp.getYearMonth())
                .setAmount(salary)
                .build();
    }


}
