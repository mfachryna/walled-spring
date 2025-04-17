package id.co.bsi.walled.service;


import id.co.bsi.walled.model.TransactionType;
import id.co.bsi.walled.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public List<TransactionType> getAllType(){
        return this.transactionTypeRepository.findAll();
    }

    public TransactionType createTransactionType(TransactionType transactionType) {
        if (transactionType.getTitle() == null || transactionType.getTitle().isEmpty()) {
            throw new RuntimeException("Transaction type title cannot be null or empty");
        }

//        if (transactionType.getTitle() != "transfer" ||
//            transactionType.getTitle() != "topup"){
//            throw new RuntimeException("Transaction type title must be transfer or topup ");
//        }

        return this.transactionTypeRepository.save(transactionType);
    }


}
