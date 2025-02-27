package com.finance.personal_finance.Controllers;

import com.finance.personal_finance.Models.TransactionModel;
import com.finance.personal_finance.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FinanceController {

    @Autowired
    private TransactionRepo transactionRepo;

    @PostMapping("/addTransaction")
    public ResponseEntity<Map<String, String>> addTransaction(@RequestBody TransactionModel t){
        TransactionModel tob = transactionRepo.save(t);
        Map<String, String> response = new HashMap<>();
        if(tob.getId()!=0){
            response.put("Status", "Transaction Added Successfully");
        }
        else{
            response.put("Status", "Transaction failed");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/fetchAll")
    public ResponseEntity<List<Map<String,String>>> fetchAllTransactions() {
        List<Map<String,String>> fob = transactionRepo.fetchAllTransaction();
        return ResponseEntity.ok(fob);
    }

    @PostMapping("/fetchMyTransactions")
    public ResponseEntity<List<Map<String,String>>> fetchMyPost(@RequestBody TransactionModel t)
    {
        List<Map<String,String>> mob=transactionRepo.fetchMyTransaction(t.getUserId());
        return ResponseEntity.ok(mob);
    }
}
