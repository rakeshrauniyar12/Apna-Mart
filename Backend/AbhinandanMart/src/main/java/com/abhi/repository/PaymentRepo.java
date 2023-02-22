package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
