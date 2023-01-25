package com.accenture.accounting_service.Controller;

//import com.accenture.accounting_service.FeignConsumer.EmployeeRequest;
//import com.accenture.accounting_service.FeignConsumer.WorkhourRequest;
import com.accenture.accounting_service.Model.Salary;
import com.accenture.accounting_service.Model.SalaryReq;
import com.accenture.accounting_service.Model.WorkHourReq;
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
    private AccountingService accountingService;
    Logger logger = LoggerFactory.getLogger(AccountingController.class);
    @GetMapping("/salary/{empId}/{yearMonth}")
    @CircuitBreaker(name = "BreakPoint", fallbackMethod = "BreakPointFallBack")
    public Salary calculateSalary(@PathVariable String empId,@PathVariable int yearMonth){


        return accountingService.calculateSalary(empId,yearMonth);
    }
    public Salary BreakPointFallBack(String empId, int yearMonth, Exception ex){
        logger.info("Service is Down....Please try again....))) ");
        logger.info(ex.getMessage());
        Number baseSalary = 20000;
        Salary salary = new Salary.SalaryBuilder()
                .setEmpId(empId)
                .setYearMonth(yearMonth)
                .setAmount(baseSalary)
                .build();

        return salary;
    }
}
