package com.service.expense.Controller;

import com.service.expense.DTO.ExpenseDTO;
import com.service.expense.Model.Expense;
import com.service.expense.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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


}

