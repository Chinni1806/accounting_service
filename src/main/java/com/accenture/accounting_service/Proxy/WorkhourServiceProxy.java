package com.accenture.accounting_service.Proxy;

import com.accenture.accounting_service.Model.WorkHourReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="WORKHOUR-SERVICE")
public interface WorkhourServiceProxy {
    @GetMapping("/api/Workhour/{empId}/{yearMonth}")
    WorkHourReq getEmployeeLeaveByEmpIdAndYearMonth(@PathVariable("empId") String empId,@PathVariable("yearMonth") int yearMonth);

}
