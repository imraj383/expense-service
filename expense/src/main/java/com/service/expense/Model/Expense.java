package com.service.expense.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Short description of expense
    @Column(nullable = false)
    private String description;

    // Expense amount
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    // Expense date (when it occurred)
    @Column(nullable = false)
    private LocalDate date;

    // Optional category for filtering: e.g. FOOD, TRAVEL, UTILITIES
    private String category;

    // Payment method (optional): CASH, CARD, UPI, BANK_TRANSFER, etc.
    private String paymentMethod;

    // Link to user via email or userId from JWT (no DB relation to keep microservices independent)
    @Column(nullable = false)
    private String userEmail;

    // Audit fields
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

