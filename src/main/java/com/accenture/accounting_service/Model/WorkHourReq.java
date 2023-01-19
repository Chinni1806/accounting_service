package com.accenture.accounting_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WorkHourReq.WorkHourReqBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkHourReq {
    private String empId;
    private Number yearMonth;
    public WorkHourReq() {
    }

    public WorkHourReq(WorkHourReqBuilder builder) {
        this.empId = builder.empId;
        this.yearMonth = builder.yearMonth;
    }

    public String getEmployeeId() {
        return empId;
    }

    public Number getYearMonth() {
        return yearMonth;
    }

    @Override
    public String toString() {
        return "WorkHourReq{" +
                "empId='" + empId + '\'' +
                ", yearMonth=" + yearMonth +
                '}';
    }
    @JsonPOJOBuilder(withPrefix = "set")
    public static class WorkHourReqBuilder{
        protected String empId;
        protected Number yearMonth;

        public WorkHourReq.WorkHourReqBuilder setEmployeeId(String empId) {
            this.empId = empId;
            return this;
        }

        public WorkHourReq.WorkHourReqBuilder setYearMonth(Number yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public WorkHourReq build() {
            return new WorkHourReq(this);
        }
    }

}
