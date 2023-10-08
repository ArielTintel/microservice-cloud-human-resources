package com.arieltintel.apipayroll.service;

import com.arieltintel.apipayroll.dto.WorkerDto;
import com.arieltintel.apipayroll.entities.Payment;
import com.arieltintel.apipayroll.exception.WorkerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${url.api-worker}")
    private String urlApiWorker;

    private final RestTemplate restTemplate;

    public Payment getPayment(Long workerId, Integer daysWorked) {
        try {
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("id", workerId.toString());

            WorkerDto workerDto = restTemplate.getForObject(urlApiWorker + "/{id}", WorkerDto.class, pathParams);

            return Payment.builder()
                    .name(workerDto.getName())
                    .dailyIncome(workerDto.getDailyIncome())
                    .daysWorked(daysWorked)
                    .build();
        } catch (HttpClientErrorException.NotFound e) {
            throw new WorkerNotFoundException("Trabalhador não encontrado");
        }
    }

}
