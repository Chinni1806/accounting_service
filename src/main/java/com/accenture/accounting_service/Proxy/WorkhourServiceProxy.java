package com.accenture.accounting_service.Proxy;

import com.accenture.accounting_service.Model.WorkHourReq;
import com.accenture.accounting_service.Model.Workhour;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name="Workhour-service")
public interface WorkhourServiceProxy {
    @GetMapping("/req")
    public Optional<Workhour> getEmployeeLeaveByEmpIdAndYearMonth(@RequestBody WorkHourReq workhourreq);


}
