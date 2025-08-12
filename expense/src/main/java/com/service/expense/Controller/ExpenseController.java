package com.service.expense.Controller;

import com.service.expense.DTO.ExpenseDTO;
import com.service.expense.Model.Expense;
import com.service.expense.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/addexpense")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense, Principal principal){
        Expense e = expenseService.addExpense(expense,principal.getName());
//        return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.ok(e);
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getUserExpenses(Principal principal) {
        List<Expense> expenses = expenseService.getUserExpenses(principal.getName());
        return ResponseEntity.ok(expenses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO dto, Principal principal) {
        Expense expense = expenseService.updateExpense(id, dto, principal.getName());
        return ResponseEntity.ok(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id, Principal principal) {
        expenseService.deleteExpense(id, principal.getName());
        return ResponseEntity.noContent().build();
    }

}

