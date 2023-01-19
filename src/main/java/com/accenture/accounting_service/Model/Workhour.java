package com.accenture.accounting_service.Model;

import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.annotation.Id;
@JsonDeserialize(builder = Workhour.WorkhourBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workhour {
    @Id
    private String empId;
    private Number yearMonth;
    private Number count;

    public Workhour() {
    }

    public Workhour(WorkhourBuilder builder) {

        this.empId = builder.empId;
        this.yearMonth = builder.yearMonth;
        this.count =builder.count;
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
