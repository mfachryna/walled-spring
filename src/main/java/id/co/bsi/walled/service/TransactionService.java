package id.co.bsi.walled.service;


import id.co.bsi.walled.dto.request.TransactionsRequest;
import id.co.bsi.walled.dto.response.CreateTransactionResponse;
import id.co.bsi.walled.dto.response.Response;
import id.co.bsi.walled.model.Account;
import id.co.bsi.walled.model.Transaction;
import id.co.bsi.walled.model.TransactionType;
import id.co.bsi.walled.repository.AccountRepository;
import id.co.bsi.walled.repository.TransactionRepository;
import id.co.bsi.walled.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions(){
        return this.transactionRepository.findAll();

    }

    public Response transfer (TransactionsRequest req, String type) {
        TransactionType data = transactionTypeRepository.findByTitle(type);
        if (data == null) {
            Response res = new Response();
            res.setMessage("Transaction type not found!");
            res.setFailure();
            return res;
        }

        List<String> error = checkTransactionsBody(req);
        if (!error.isEmpty()) {
            Response res = new Response();
            res.setMessage(error.toString());
            res.setFailure();
            return res;
        }

        Optional<Account> accountQuery = this.accountRepository.findById(1);
        if (accountQuery.isPresent()) {
            Account account = accountQuery.get();
            if (req.getAmount() > account.getBalance()) {
                Response res = new Response();
                res.setMessage("Not enough balance!");
                res.setFailure();
                return res;
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
        return res;
    }


    public List<String> checkTransactionsBody(TransactionsRequest req) {
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
}
