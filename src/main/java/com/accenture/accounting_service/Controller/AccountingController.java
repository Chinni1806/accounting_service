package com.accenture.accounting_service.Controller;

import com.accenture.accounting_service.FeignConsumer.EmployeeRequest;
import com.accenture.accounting_service.FeignConsumer.WorkhourRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountingController {
    @Autowired
    EmployeeRequest employeeRequest;
    @Autowired
    WorkhourRequest workhourRequest;
    @GetMapping("/{id}")
    public int getEmpBaseSalary(@PathVariable("id") String Id){
        return employeeRequest.getEmpBaseSalaryById(Id);
    }
    @GetMapping("/work/{id}")
    public Number getEmpCount(@PathVariable("empId") String empId){
        return workhourRequest.getEmpCountById(empId);
    }

}
