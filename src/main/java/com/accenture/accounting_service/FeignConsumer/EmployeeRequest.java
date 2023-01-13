package com.accenture.accounting_service.FeignConsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
@FeignClient(name="Employee-service",url="localhost:9001/api/employee")
public interface EmployeeRequest {
    @GetMapping("/{id}")
    public int getEmpBaseSalaryById(@PathVariable("id") String Id);

}
