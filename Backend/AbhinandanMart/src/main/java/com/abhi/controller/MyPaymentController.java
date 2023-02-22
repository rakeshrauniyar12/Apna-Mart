package com.abhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.model.Payment;
import com.abhi.service.PaymentService;

@RestController
public class MyPaymentController {

	@Autowired
	private PaymentService pService;
	
	@PostMapping("/savepayment")
	public ResponseEntity<Payment> savePayementHandler(@RequestBody Payment payment){
		   Payment paym= pService.savePayment(payment);
		   return new ResponseEntity<Payment>(paym,HttpStatus.ACCEPTED);
	}
	
	
}
