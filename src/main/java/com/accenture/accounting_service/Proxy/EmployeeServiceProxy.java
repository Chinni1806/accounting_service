package com.accenture.accounting_service.Proxy;

import com.accenture.accounting_service.Model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "Employee-service")
public interface EmployeeServiceProxy {
    @GetMapping("/api/employee/{id}")
    Optional<Employee> getEmployee(@PathVariable("id") String id);

}
