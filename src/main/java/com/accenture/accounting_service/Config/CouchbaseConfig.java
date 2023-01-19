package com.accenture.accounting_service.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "test2";
    }

    @Override
    public String getPassword() {
        return "root123";
    }

    @Override
    public String getBucketName() {
        return "Accounting";
    }
}
