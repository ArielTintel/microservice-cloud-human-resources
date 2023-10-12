package com.arieltintel.apipayroll.controller;

import com.arieltintel.apipayroll.entities.Payment;
import com.arieltintel.apipayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Log4j2
@RestController
@RequestMapping("v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/worker/{workerId}/days/{daysWorked}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPayment(@PathVariable(value = "workerId") Long workerId,
                              @PathVariable(value = "daysWorked")Integer daysWorked) {
        return paymentService.getPayment(workerId, daysWorked);
    }

    /**
     * Alternative implementation, dependent on the business rule.
     */
    public Payment getPaymentAlternative(Long workerId, Integer days) {
        log.info("################ Executed alternative method");
        return Payment.builder()
                .name("Ariel Tintel")
                .dailyIncome(new BigDecimal("2725.49"))
                .daysWorked(days)
                .build();
    }

}
