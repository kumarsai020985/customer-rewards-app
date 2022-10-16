package com.customer.rewards.customerrewardsapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.rewards.customerrewardsapp.entity.TransactionsEntity;

@Repository
public interface TransactionsRepo extends JpaRepository<TransactionsEntity, Long> {

	@Query("SELECT T   FROM TransactionsEntity T WHERE customer_id= :custId")
	List<TransactionsEntity> findByCustomerId(@Param("custId") long custId);

}
