package com.arieltintel.apipayroll.service;

import com.arieltintel.apipayroll.entities.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer daysWorked) {
        return Payment.builder()
                .name("Ariel")
                .dailyIncome(new BigDecimal("200"))
                .daysWorked(daysWorked)
                .build();
    }

}
