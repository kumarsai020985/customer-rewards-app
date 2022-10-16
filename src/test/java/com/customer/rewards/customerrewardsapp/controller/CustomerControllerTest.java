package com.customer.rewards.customerrewardsapp.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.customer.rewards.customerrewardsapp.forms.CustomerResponseForm;
import com.customer.rewards.customerrewardsapp.forms.TransactionForm;
import com.customer.rewards.customerrewardsapp.service.CustomerRewardsServiceImpl;

@ExtendWith(SpringExtension.class)
public class CustomerControllerTest {
	
	
	@InjectMocks
	private CustomerController customerController;
	
	@Mock
	private CustomerRewardsServiceImpl customerRewardsServiceImpl;
	
	
	@Test
	public void tes_getCustomerTransactionAndRewardsInfo_Success() {
		
		List<TransactionForm> transactionsFormList = new ArrayList<TransactionForm>();
		TransactionForm transForm = new TransactionForm();
		transForm.setTransactionAmt(123);
		transForm.setTransactionId(1);
		transForm.setRewardsPoints(90);

		transactionsFormList.add(transForm);
		
		
		CustomerResponseForm customeForm = new CustomerResponseForm();
		customeForm.setCustomerId(1);
		customeForm.setCustomerName("Customr");
		customeForm.setTrasactionsForm(transactionsFormList);
		customeForm.setTotalRewardsPoints(90);
		
		Mockito.when(customerRewardsServiceImpl.findByCusotmerId(1)).thenReturn(customeForm);
		
		ResponseEntity<?> response  =   customerController.getCustomerTransactionAndRewardsInfo(1L);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

}
