package com.customer.rewards.customerrewardsapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.customerrewardsapp.entity.CustomerEntity;
import com.customer.rewards.customerrewardsapp.entity.TransactionsEntity;
import com.customer.rewards.customerrewardsapp.exceptions.CustomerIdNotFounException;
import com.customer.rewards.customerrewardsapp.forms.CustomerRequestForm;
import com.customer.rewards.customerrewardsapp.forms.CustomerResponseForm;
import com.customer.rewards.customerrewardsapp.forms.TransactionForm;
import com.customer.rewards.customerrewardsapp.repo.CustomerRepo;
import com.customer.rewards.customerrewardsapp.repo.TransactionsRepo;

@Service
public class CustomerRewardsServiceImpl implements CustomerRewardsService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	TransactionsRepo transactionRepo;

	@Override
	public void saveCustomer(CustomerRequestForm customerForm) {

		double rewardsPoints = 0;
		List<TransactionsEntity> transactionsList = new ArrayList<>();

		CustomerEntity customer = new CustomerEntity();
		customer.setCustomerId(customerForm.getCustomerId());
		customer.setCustomerName(customerForm.getCustomerName());

		double amount = customerForm.getItemPrices().stream().mapToDouble(Double::doubleValue).sum();

		if (amount > 50 && amount < 100) {
			rewardsPoints = 50 * 1;
		} else if (amount > 100) {
			rewardsPoints = ((amount - 100) * 2 + (50 * 1));

		}

		TransactionsEntity transactionsEntity = new TransactionsEntity();
		transactionsEntity.setRewardsPoints((int) Math.round(rewardsPoints));
		transactionsEntity.setTransactionAmount(amount);
		transactionsEntity.setTransactionDate(LocalDateTime.now());
		

		transactionsEntity.setCustomer(customer);
		

		transactionsList.add(transactionsEntity);

		customer.setTransactionsList(transactionsList);

		customerRepo.save(customer);
		
	}

	@Override
	public CustomerResponseForm findByCusotmerId(long customerId) {

		CustomerEntity customer = customerRepo.findByCustomerId(customerId);
		if (customer == null) {
			throw new CustomerIdNotFounException();
		}
		List<TransactionsEntity> transactionEntityList;
		List<TransactionForm> transactionsList = new ArrayList<TransactionForm>();
		if (customer != null) {
			transactionEntityList = transactionRepo.findByCustomerId(customer.getCustomerId());

			transactionsList = transactionEntityList.stream().map(transaction -> {
				TransactionForm transForm = new TransactionForm();
				transForm.setTransactionAmt(transaction.getTransactionAmount());
				transForm.setTransactionId(transaction.getTransactionId());
				transForm.setRewardsPoints(transaction.getRewardsPoints());
				return transForm;
			}).collect(Collectors.toList());

		}

		CustomerResponseForm customeForm = new CustomerResponseForm();
		customeForm.setCustomerId(customer.getCustomerId());
		customeForm.setCustomerName(customer.getCustomerName());
		customeForm.setTrasactionsForm(transactionsList);
		customeForm.setTotalRewardsPoints(transactionsList.stream().mapToInt(TransactionForm::getRewardsPoints).sum());

		return customeForm;
	}

}
