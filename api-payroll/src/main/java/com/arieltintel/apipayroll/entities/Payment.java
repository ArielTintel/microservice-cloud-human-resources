package com.arieltintel.apipayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String name;
    private BigDecimal dailyIncome;
    private Integer daysWorked;

    public BigDecimal getTotal() {
        return dailyIncome.multiply(BigDecimal.valueOf(daysWorked));
    }
}
