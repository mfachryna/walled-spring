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
}
