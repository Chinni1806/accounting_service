package com.accenture.accounting_service.Service;

import com.accenture.accounting_service.Model.Salary;
import com.accenture.accounting_service.Model.WorkHourReq;
import com.accenture.accounting_service.Model.Workhour;
import com.accenture.accounting_service.Proxy.EmployeeServiceProxy;
import com.accenture.accounting_service.Proxy.WorkhourServiceProxy;
import com.accenture.accounting_service.Repository.AccountingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountingService {
    @Autowired
    private EmployeeServiceProxy empProxy;
    @Autowired
    private WorkhourServiceProxy workhourProxy;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AccountingRepo accountingRepo;
    public Salary calculateSalary(WorkHourReq workHourReq){
        Salary salary;
        Number amount=null;
        try{
            Number baseSalary=empProxy.getEmployee(workHourReq.getEmployeeId()).getBaseSalary();
            Workhour leaves=restTemplate.postForObject("http://localhost:9002/api/Workhour/req",workHourReq,Workhour.class);
            if(leaves==null){
                amount=baseSalary;
            }
            else{
                Number leaveCount=leaves.getCount();
                Number daysInMonth=calculateDays(workHourReq.getYearMonth());
                amount=(baseSalary.intValue())*(daysInMonth.intValue()-leaveCount.intValue())/daysInMonth.intValue();

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        salary=new Salary.SalaryBuilder()
                .setEmpId(workHourReq.getEmployeeId())
                .setYearMonth(workHourReq.getYearMonth())
                .setAmount(amount)
                .build();
        return salary;
    }

    private Number calculateDays(Number yearMonth) {
        int year=Integer.parseInt((""+yearMonth.intValue()).substring(0,4));
        int month=yearMonth.intValue()%100;
        return getNoOfDays(year,month);
    }

    private Number getNoOfDays(int year, int month) {
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }
        else if(month==2){
            if((year%4==0 && year%100!=0)||year%400==0)
                return 29;
            else
                return 28;
        }
        return 30;
    }


}
