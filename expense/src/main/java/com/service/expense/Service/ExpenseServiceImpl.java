package com.service.expense.Service;

import com.service.expense.DTO.ExpenseDTO;
import com.service.expense.Model.Expense;
import com.service.expense.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Expense> getUserExpenses(String name) {
        return expenseRepository.findByUserEmail(name);
    }

    @Override
    public Expense updateExpense(Long id, ExpenseDTO dto, String name) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        if (!expense.getUserEmail().equals(name)) {
            throw new RuntimeException("Unauthorized to update this expense");
        }

        expense.setDescription(dto.getDescription());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setCategory(dto.getCategory());
        expense.setPaymentMethod(dto.getPaymentMethod());

        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id, String name) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        if (!expense.getUserEmail().equals(name)) {
            throw new RuntimeException("Unauthorized to delete this expense");
        }

        expenseRepository.delete(expense);
    }
}
