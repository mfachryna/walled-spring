package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.TopupRequest;
import id.co.bsi.walled.dto.request.TransactionsRequest;
import id.co.bsi.walled.dto.request.TransferRequest;
import id.co.bsi.walled.dto.response.*;
import id.co.bsi.walled.model.Account;
import id.co.bsi.walled.model.PaymentMethod;
import id.co.bsi.walled.model.Transaction;
import id.co.bsi.walled.model.TransactionType;
import id.co.bsi.walled.repository.AccountRepository;
import id.co.bsi.walled.repository.TransactionRepository;
import id.co.bsi.walled.repository.TransactionTypeRepository;
import id.co.bsi.walled.service.PaymentMethodService;
import id.co.bsi.walled.service.TransactionService;
import id.co.bsi.walled.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/transactions")
public class TransactionsController {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private TransactionTypeService transactionTypeService;

    @Autowired
    private TransactionService transactionService;


    @GetMapping("")
    public ResponseEntity<TransactionsResponse> getTransactions() {
        List<Transaction> data = this.transactionService.getAllTransactions();

        TransactionsResponse transactionsResponse = new TransactionsResponse(data);
        transactionsResponse.setMessage("Transaction data retrieved!");
        transactionsResponse.setSuccess();

        return ResponseEntity.ok(transactionsResponse);
    }

    @PostMapping("/{type}")
    public ResponseEntity<?> transfer(@RequestBody TransactionsRequest req,
                                      @PathVariable(name = "type") String type) {
        Response response = transactionService.transfer(req, type);

        if (!response.isStatus()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/types")
    public ResponseEntity<List<TransactionType>> getAllTypes(){
        List<TransactionType> types = transactionTypeService.getAllType();
        return ResponseEntity.ok(types);
    }

    @GetMapping("/methods")
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods() {
        List<PaymentMethod> methods = this.paymentMethodService.getAllMethods();
        return ResponseEntity.ok(methods);
    }
}
