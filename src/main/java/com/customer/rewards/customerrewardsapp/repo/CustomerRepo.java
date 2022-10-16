package com.customer.rewards.customerrewardsapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.rewards.customerrewardsapp.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

	public CustomerEntity findByCustomerId(long customerId);

}
