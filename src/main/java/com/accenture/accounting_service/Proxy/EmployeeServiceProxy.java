package com.accenture.accounting_service.Proxy;

import com.accenture.accounting_service.Model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Employee-service",url = "http://localhost:9001/api/employee")
public interface EmployeeServiceProxy {
    @GetMapping("/api/employee/{id}")
    Employee getEmployee(@PathVariable String id);

}
