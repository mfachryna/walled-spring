package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.TopupRequest;
import id.co.bsi.walled.dto.request.TransferRequest;
import id.co.bsi.walled.dto.response.CreateTransactionResponse;
import id.co.bsi.walled.dto.response.TransactionResponse;
import id.co.bsi.walled.dto.response.TransactionsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/transactions")
public class TransactionsController {
    @GetMapping("")
    public ResponseEntity<TransactionsResponse> getTransactions() {
        List<TransactionResponse> data = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            TransactionResponse transaction = new TransactionResponse();
            transaction.setAmount(i * 1010);
            transaction.setDate("25 desember 2001");
            transaction.setType("topup");
            transaction.setNotes("oiii");
            transaction.setFromTo("kucing");
            data.add(transaction);
        }

        TransactionsResponse transactionsResponse = new TransactionsResponse(data);
        transactionsResponse.setMessage("Transaction data retrieved!");
        transactionsResponse.setSuccess();

        return ResponseEntity.ok(transactionsResponse);
    }

    @PostMapping("/transfer")
    public ResponseEntity<CreateTransactionResponse> transfer(@RequestBody TransferRequest req) {
        req.setType("transfer");
        CreateTransactionResponse res = new CreateTransactionResponse(req);

        res.setSuccess();
        res.setMessage("Success creating top up transaction!");
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/topup")
    public ResponseEntity<CreateTransactionResponse> topup(@RequestBody TopupRequest req) {
        req.setType("topup");
        CreateTransactionResponse res = new CreateTransactionResponse(req);

        res.setSuccess();
        res.setMessage("Success creating transfer transaction!");
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
