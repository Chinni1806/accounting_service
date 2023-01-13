package com.accenture.accounting_service.Entity;

import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;

public class Workhour {
    @Id
    private String empId;
    private Number yearMonth;
    private Number count;

    public Workhour() {
    }

    public Workhour(String empId, Number yearMonth, Number count) {
        super();
        this.empId = empId;
        this.yearMonth = yearMonth;
        this.count = count;
    }

    public Workhour(WorkhourBuilder workhourBuilder) {
    }

    public String getEmpId() {
        return empId;
    }

    public Number getYearMonth() {
        return yearMonth;
    }

    public Number getCount() {
        return count;
    }
    @JsonPOJOBuilder(withPrefix = "set")
    public static class WorkhourBuilder {

        protected String empId;
        protected Number yearMonth;
        protected Number count;


        public WorkhourBuilder setEmployeeId(String empId) {
            this.empId = empId;
            return this;
        }

        public WorkhourBuilder setYearMonth(Number yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public WorkhourBuilder setCount(Number count) {
            this.count = count;
            return this;
        }


        public Workhour build() {
            return new Workhour(this);
        }
    }
}
