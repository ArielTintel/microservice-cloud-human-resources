package com.arieltintel.apipayroll.service;

import com.arieltintel.apipayroll.client.WorkerFeingClient;
import com.arieltintel.apipayroll.dto.WorkerDto;
import com.arieltintel.apipayroll.entities.Payment;
import com.arieltintel.apipayroll.exception.WorkerNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeingClient workerFeingClient;

    public Payment getPayment(Long workerId, Integer daysWorked) {
        try {
            WorkerDto workerDto = workerFeingClient.findById(workerId);

            return Payment.builder()
                    .name(workerDto.getName())
                    .dailyIncome(workerDto.getDailyIncome())
                    .daysWorked(daysWorked)
                    .build();
        } catch (FeignException.NotFound e) {
            throw new WorkerNotFoundException("Trabalhador não encontrado");
        }
    }

}
