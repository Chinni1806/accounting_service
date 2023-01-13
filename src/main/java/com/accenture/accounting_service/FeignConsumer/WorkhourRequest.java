package com.accenture.accounting_service.FeignConsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
@FeignClient(name = "Workhour-service",url="localhost:9002/api/Workhour")
public interface WorkhourRequest {
    @GetMapping("/{empId}")

    public Number getEmpCountById(@PathVariable("empId") String empId);

}
