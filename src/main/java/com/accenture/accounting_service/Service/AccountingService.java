package com.accenture.accounting_service.Service;

import com.accenture.accounting_service.Model.Employee;
import com.accenture.accounting_service.Model.Salary;
import com.accenture.accounting_service.Model.SalaryReq;
import com.accenture.accounting_service.Model.WorkHourReq;
import com.accenture.accounting_service.Proxy.EmployeeServiceProxy;
import com.accenture.accounting_service.Proxy.WorkhourServiceProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AccountingService {
    @Autowired
    private EmployeeServiceProxy empProxy;
    @Autowired
    private WorkhourServiceProxy workhourProxy;

    public Salary calculateSalary(String empId,int yearMonth) {
        int amount=0;
        Number baseSalary=empProxy.getEmployee(empId).getBaseSalary();
        int leaveCount=workhourProxy.getEmployeeLeaveByEmpIdAndYearMonth(empId,yearMonth).getCount();
        int noOfDays=workhourProxy.getEmployeeLeaveByEmpIdAndYearMonth(empId,yearMonth).getDays();
        if(leaveCount==0){
            amount=baseSalary.intValue();
        }
        else{
            amount=(baseSalary.intValue())*(noOfDays-leaveCount)/noOfDays;

        }
        return new Salary
                .SalaryBuilder()
                .setEmpId(empId)
                .setAmount(amount)
                .setYearMonth(yearMonth)
                .build();
    }


}
