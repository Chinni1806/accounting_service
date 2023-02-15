package com.accenture.accounting_service.Service;

import com.accenture.accounting_service.Model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AccountingConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountingConsumer.class);

    @KafkaListener(topics={"${spring.kafka.topic1}"} ,
            groupId = "${spring.kafka.consumer.group-id}", containerFactory = "EmployeeListener")
    public void consumeEmployee(Employee employee){
        LOGGER.info(String.format("employee Event consumed:  => %s",employee));
    }

}
