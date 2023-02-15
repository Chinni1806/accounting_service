package com.accenture.accounting_service.Config;

import com.accenture.accounting_service.Model.Employee;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
@EnableKafka
@Configuration
public class KafkaConfig {
    @Bean
    public ConsumerFactory<String, Employee> EmployeeConsumer()
    {

        // Creating a Map of string-object pairs
        Map<String, Object> config = new HashMap<>();

        // Adding the Configuration
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,
                "group_id");
        config.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        config.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES,"com.accenture.Employee_Service.model.Employee");
        config.put(JsonDeserializer.TYPE_MAPPINGS,"com.accenture.Employee_Service.model.Employee:com.accenture.accounting_service.Model.Employee");

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Employee.class));
    }

    // Creating a Listener
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Employee> EmployeeListener()
    {
        ConcurrentKafkaListenerContainerFactory<String, Employee> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(EmployeeConsumer());
        return factory;
    }
}
