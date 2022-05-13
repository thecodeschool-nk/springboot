package com.thecodeschool.springbatch.repository;

import com.thecodeschool.springbatch.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
