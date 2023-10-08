package com.arieltintel.apipayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {

    private Long id;
    private String name;
    private BigDecimal dailyIncome;

}
