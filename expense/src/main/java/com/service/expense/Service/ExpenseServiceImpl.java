package com.service.expense.Service;

import com.service.expense.Model.Expense;
import com.service.expense.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Expense expense, String email) {
        Expense expense1 = new Expense();
        expense1.setAmount(expense.getAmount());
        expense1.setDate(expense.getDate());
        expense1.setCategory(expense.getCategory());
        expense1.setDescription(expense.getDescription());
        expense1.setPaymentMethod(expense.getPaymentMethod());
        expense1.setUserEmail(email);
        System.out.println(expense1.getUserEmail());
        return expenseRepository.save(expense1);
    }
}
