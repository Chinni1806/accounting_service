package com.accenture.accounting_service.Controller;

//import com.accenture.accounting_service.FeignConsumer.EmployeeRequest;
//import com.accenture.accounting_service.FeignConsumer.WorkhourRequest;
import com.accenture.accounting_service.Model.EmployeeSalary;
import com.accenture.accounting_service.Model.Salary;
import com.accenture.accounting_service.Service.AccountingService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounting")
public class AccountingController {
    @Autowired
    AccountingService accountingService;
    Logger logger = LoggerFactory.getLogger(AccountingController.class);
    @PostMapping("/calSalary")
    @CircuitBreaker(name = "BreakPoint", fallbackMethod = "BreakPointFallBack")
    public Salary calculateSalary(@RequestBody EmployeeSalary emp){


        return accountingService.calculateSalary(emp);
    }
    public Salary BreakPointFallBack(Exception ex){
        logger.info("Service is Down....Please try again....))) ");
        logger.info(ex.getMessage());
        return new Salary
                .SalaryBuilder()
                .setYearMonth(000000)
                .setAmount(-1)
                .build();
    }
}
