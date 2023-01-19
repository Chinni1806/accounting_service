package com.accenture.accounting_service.Controller;

//import com.accenture.accounting_service.FeignConsumer.EmployeeRequest;
//import com.accenture.accounting_service.FeignConsumer.WorkhourRequest;
import com.accenture.accounting_service.Model.Salary;
import com.accenture.accounting_service.Model.WorkHourReq;
import com.accenture.accounting_service.Service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounting")
public class AccountingController {
    @Autowired
    private AccountingService accountingService;
    public Salary calculateSalary(@RequestBody WorkHourReq workHourReq){
        return this.accountingService.calculateSalary(workHourReq);
    }
}
