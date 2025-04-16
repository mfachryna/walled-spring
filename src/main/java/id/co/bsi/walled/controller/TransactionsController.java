package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.LoginRequest;
import id.co.bsi.walled.dto.request.TransactionsRequest;
import id.co.bsi.walled.dto.response.LoginResponse;
import id.co.bsi.walled.dto.response.TransactionResponse;
import id.co.bsi.walled.dto.response.TransactionsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/transaction")
public class TransactionsController {
    @GetMapping("")
    public ResponseEntity<TransactionsResponse> getTransactions(@RequestBody TransactionsRequest login) {
        TransactionResponse transaction1 = new TransactionResponse();
        transaction1.setAmount(1000);
        transaction1.setDate("25 desember 2001");
        transaction1.setType("topup");
        transaction1.setNotes("oiii");
        transaction1.setFromTo("kucing");

        List<TransactionResponse> data = new ArrayList<>(List.of(transaction1));
        TransactionsResponse transactionsResponse = new TransactionsResponse(data);
        transactionsResponse.setMessage("Transaction data retrieved!");
        return ResponseEntity.ok(transactionsResponse);


    }
}
