package com.thecodeschool.springbatch.batch;

import com.thecodeschool.springbatch.model.Customer;
import com.thecodeschool.springbatch.repository.CustomerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Customer> {

    private CustomerRepository customerRepository;

    @Autowired
    public DBWriter (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void write(List<? extends Customer> customers) throws Exception{
        System.out.println("Data Saved for Customers: " + customers);
        customerRepository.saveAll(customers);
    }
}
