package com.accenture.accounting_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WorkHourReq.WorkHourReqBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkHourReq {
    private int count;
    private int days;

    public WorkHourReq() {
    }

    public WorkHourReq(WorkHourReqBuilder builder) {
        this.count = builder.count;
        this.days = builder.days;
    }

    public int getCount() {
        return count;
    }

    public int getDays() {
        return days;
    }


    @JsonPOJOBuilder(withPrefix = "set")
    public static class WorkHourReqBuilder {
        protected int count;
        protected int days;

        public WorkHourReqBuilder setCount(int count) {
            this.count = count;
            return this;
        }

        public WorkHourReqBuilder setDays(int days) {
            this.days = days;
            return this;
        }

        public WorkHourReq build() {
            return new WorkHourReq(this);
        }
    }
}