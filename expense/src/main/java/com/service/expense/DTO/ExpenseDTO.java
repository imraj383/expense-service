package com.service.expense.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private String category;
    private String paymentMethod;
}

