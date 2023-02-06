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

    private Number amount;
    private Number yearMonth;

    public Salary() {
    }
    public Salary(SalaryBuilder builder){
        this.amount=builder.amount;

        this.yearMonth=builder.yearMonth;
    }



    public Number getAmount() {
        return amount;
    }

    public Number getYearMonth() {
        return yearMonth;
    }


    @JsonPOJOBuilder(withPrefix = "set")
    public static class SalaryBuilder {

        protected Number yearMonth;
        protected Number amount;


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
