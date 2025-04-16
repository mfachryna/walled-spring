package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.TopupRequest;
import id.co.bsi.walled.dto.request.TransactionsRequest;
import id.co.bsi.walled.dto.request.TransferRequest;
import id.co.bsi.walled.dto.response.*;
import id.co.bsi.walled.model.Account;
import id.co.bsi.walled.model.Transaction;
import id.co.bsi.walled.model.TransactionType;
import id.co.bsi.walled.repository.AccountRepository;
import id.co.bsi.walled.repository.TransactionRepository;
import id.co.bsi.walled.repository.TransactionTypeRepository;
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

    @GetMapping("")
    public ResponseEntity<TransactionsResponse> getTransactions() {
        List<Transaction> data = this.transactionRepository.findAll();

        TransactionsResponse transactionsResponse = new TransactionsResponse(data);
        transactionsResponse.setMessage("Transaction data retrieved!");
        transactionsResponse.setSuccess();

        return ResponseEntity.ok(transactionsResponse);
    }

    @PostMapping("/{type}")
    public ResponseEntity<?> transfer(@RequestBody TransactionsRequest req, @PathVariable(name = "type") String type) {
        TransactionType data = transactionTypeRepository.findByTitle(type);
        if (data == null) {
            Response res = new Response();
            res.setMessage("Transaction type not found!");
            res.setFailure();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(res);
        }
        List<String> error = checkTransactionsBody(req);

        if (!error.isEmpty()) {
            Response res = new Response();
            res.setMessage(error.toString());
            res.setFailure();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(res);
        }


        Optional<Account> accountQuery = this.accountRepository.findById(1);
        if (accountQuery.isPresent()) {
            Account account = accountQuery.get();
            if (req.getAmount() > account.getBalance()) {
                Response res = new Response();
                res.setMessage("Not enough balance!");
                res.setFailure();

                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(res);
            }
            account.setBalance(account.getBalance() - req.getAmount());
            this.accountRepository.save(account);
        }

        Transaction transaction = new Transaction();

        transaction.setAmount(req.getAmount());
        transaction.setRecipientAccount(req.getRecipientAccount());
        transaction.setSenderAccount("asdasdasdas");
        transaction.setTransactionType(data);
        transaction.setNotes(req.getNotes());


        this.transactionRepository.save(transaction);
        req.setType(data.getId());
        CreateTransactionResponse res = new CreateTransactionResponse(req);
        res.setSuccess();
        res.setMessage("Success creating top up transaction!");
        return ResponseEntity.status(HttpStatus.CREATED).

                body(res);
    }

    private static List<String> checkTransactionsBody(TransactionsRequest req) {
        List<String> error = new ArrayList<String>();
        if (req.getAmount() <= 0) {
            error.add("Amount must be set or its value should be positive!");
        }
//        if (req.getNotes() == null) {
//            error.add("Notes not set, please set it to body!");
//        }
        if (req.getRecipientAccount() == null && req.getMethod() == 0) {
            error.add("Recipient Account|Method not set, please set it to body!");
        }
        return error;
    }

    @GetMapping("/type")
    public ResponseEntity<TypeResponse> typeResponse() {
        TypeResponse typeResponse = new TypeResponse(1, "transfer");
        return ResponseEntity.ok(typeResponse);
    }

    @GetMapping("/method")
    public ResponseEntity<MethodResponse> methodResponse() {
        MethodResponse methodResponse = new MethodResponse(1, "credit");
        return ResponseEntity.ok(methodResponse);
    }
}
