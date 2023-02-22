package com.abhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhi.globalException.PaymentException;
import com.abhi.model.Payment;
import com.abhi.model.User;
import com.abhi.repository.PaymentRepo;
import com.abhi.repository.UserRepo;

public class PaymentServiceImpl implements PaymentService{
     @Autowired
     private PaymentRepo pRepo;

	
	@Override
	public Payment savePayment(Payment payment) {
		   return pRepo.save(payment);
	}

         
}
