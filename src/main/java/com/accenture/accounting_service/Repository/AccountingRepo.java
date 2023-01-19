package com.accenture.accounting_service.Repository;

import com.accenture.accounting_service.Model.Salary;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepo extends CouchbaseRepository<Salary,String> {
}
