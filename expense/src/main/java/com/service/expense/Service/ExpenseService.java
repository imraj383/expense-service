package com.service.expense.Service;

import com.service.expense.DTO.ExpenseDTO;
import com.service.expense.Model.Expense;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ExpenseService {
    Expense addExpense(Expense expense, String name);

    List<Expense> getUserExpenses(String name);

    Expense updateExpense(Long id, ExpenseDTO dto, String name);

    void deleteExpense(Long id, String name);
}
