package com.accenture.accounting_service.Proxy;

import com.accenture.accounting_service.Model.WorkHourReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Workhour-service",url = "http://localhost:9003/api/Workhour")
public interface WorkhourServiceProxy {
    @GetMapping("/{empId}/{yearMonth}")
    WorkHourReq getEmployeeLeaveByEmpIdAndYearMonth(@PathVariable String empId, int yearMonth);

}
