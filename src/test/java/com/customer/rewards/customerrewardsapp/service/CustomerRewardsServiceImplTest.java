package com.customer.rewards.customerrewardsapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.customer.rewards.customerrewardsapp.entity.CustomerEntity;
import com.customer.rewards.customerrewardsapp.entity.TransactionsEntity;
import com.customer.rewards.customerrewardsapp.forms.CustomerResponseForm;
import com.customer.rewards.customerrewardsapp.forms.TransactionForm;
import com.customer.rewards.customerrewardsapp.repo.CustomerRepo;
import com.customer.rewards.customerrewardsapp.repo.TransactionsRepo;

@ExtendWith(SpringExtension.class)
public class CustomerRewardsServiceImplTest {

	@InjectMocks
	private CustomerRewardsServiceImpl customerRewardsServiceImpl;

	@Mock
	private CustomerRepo customerRepo;

	@Mock
	private TransactionsRepo transactionRepo;

	@Test
	public void test_findByCusotmerId_sucess() {

		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(1);
		customerEntity.setCustomerName("customer1");

		TransactionsEntity transactionEntity = new TransactionsEntity();
		transactionEntity.setTransactionId(1);
		transactionEntity.setRewardsPoints(90);
		transactionEntity.setTransactionAmount(120);
		transactionEntity.setTransactionDate(LocalDateTime.now());
		List<TransactionsEntity> transactionsList = new ArrayList<TransactionsEntity>();
		transactionsList.add(transactionEntity);

		customerEntity.setTransactionsList(transactionsList);

		Mockito.when(customerRepo.findByCustomerId(1)).thenReturn(customerEntity);

		Mockito.when(transactionRepo.findByCustomerId(1)).thenReturn(transactionsList);

		List<TransactionForm> transactionsFormList = new ArrayList<TransactionForm>();
		TransactionForm transForm = new TransactionForm();
		transForm.setTransactionAmt(transactionEntity.getTransactionAmount());
		transForm.setTransactionId(transactionEntity.getTransactionId());
		transForm.setRewardsPoints(transactionEntity.getRewardsPoints());

		transactionsFormList.add(transForm);

		CustomerResponseForm customeForm = new CustomerResponseForm();
		customeForm.setCustomerId(customerEntity.getCustomerId());
		customeForm.setCustomerName(customerEntity.getCustomerName());
		customeForm.setTrasactionsForm(transactionsFormList);
		customeForm.setTotalRewardsPoints(90);
		
		CustomerResponseForm  response =  customerRewardsServiceImpl.findByCusotmerId(1);
		assertThat(response);
		Assertions.assertEquals(1, response.getCustomerId());

	}

}
