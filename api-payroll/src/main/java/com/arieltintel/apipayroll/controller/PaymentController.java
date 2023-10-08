package com.arieltintel.apipayroll.controller;

import com.arieltintel.apipayroll.entities.Payment;
import com.arieltintel.apipayroll.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{workerId}/days/{daysWorked}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPayment(@PathVariable(value = "workerId") Long workerId,
                              @PathVariable(value = "daysWorked")Integer daysWorked) {
        return paymentService.getPayment(workerId, daysWorked);
    }

}
