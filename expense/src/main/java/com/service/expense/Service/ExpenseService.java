package com.service.expense.Service;

import com.service.expense.Model.Expense;
import org.springframework.stereotype.Service;


public interface ExpenseService {
    Expense addExpense(Expense expense, String name);
}
