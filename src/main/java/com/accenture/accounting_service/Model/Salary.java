package com.accenture.accounting_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@JsonDeserialize(builder = Salary.SalaryBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class Salary {
    @Id
    private String empId;
    private Number amount;
    private Number yearMonth;

    public Salary() {
    }
    public Salary(SalaryBuilder builder){
        this.amount=builder.amount;
        this.empId=builder.empId;
        this.yearMonth=builder.yearMonth;
    }

    public String getEmpId() {
        return empId;
    }

    public Number getAmount() {
        return amount;
    }

    public Number getYearMonth() {
        return yearMonth;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "empId='" + empId + '\'' +
                ", amount=" + amount +
                ", yearMonth=" + yearMonth +
                '}';
    }
    @JsonPOJOBuilder(withPrefix = "set")
    public static class SalaryBuilder {
        protected String empId;
        protected Number yearMonth;
        protected Number amount;

        public SalaryBuilder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public SalaryBuilder setYearMonth(Number yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public SalaryBuilder setAmount(Number amount) {
            this.amount = amount;
            return this;
        }

        public Salary build() {
            return new Salary(this);
        }
    }

}
